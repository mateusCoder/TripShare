package com.devs.tripshare.services;

import com.devs.tripshare.dto.person.PersonDto;
import com.devs.tripshare.dto.person.PersonForm;
import com.devs.tripshare.entities.Person;
import com.devs.tripshare.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    PersonRepository repository;

    @Override
    public Page<PersonDto> findAll(Pageable page) {
        Page<Person> person = repository.findAll(page);
        return new PageImpl<>(person.stream().map(e -> mapper.map(e, PersonDto.class)).collect(Collectors.toList()));
    }

    @Override
    public PersonDto findById(Long id) {
        return mapper.map(checkExistence(id), PersonDto.class);
    }

    @Override
    public PersonDto update(Long id, PersonForm personForm) {
        checkExistence(id);
        Person person = mapper.map(personForm, Person.class);
        person.setId(id);
        repository.save(person);

        return mapper.map(person, PersonDto.class);
    }

    @Override
    public void deleteById(Long id) {
        checkExistence(id);
        repository.deleteById(id);
    }

    @Override
    public URI create(PersonForm personForm) {
        Person person = mapper.map(personForm, Person.class);
        repository.save(person);
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(person.getId());
    }

    private Person checkExistence(Long id){
        Optional<Person> person = repository.findById(id);
        if(person.isPresent()){
            return person.get();
        } else {
            throw new RuntimeException("Person not found!");
        }
    }
}
