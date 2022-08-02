package com.devs.tripshare.services;

import com.devs.tripshare.dto.person.PersonDto;
import com.devs.tripshare.dto.person.PersonForm;
import com.devs.tripshare.entities.Person;
import com.devs.tripshare.entities.Ride;
import com.devs.tripshare.exceptions.ObjectNotFound;
import com.devs.tripshare.repository.PersonRepository;
import com.devs.tripshare.repository.RideRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    RideRepository rideRepository;

    @Override
    public Page<PersonDto> findAll(Pageable page) {
        Page<Person> person = personRepository.findAll(page);
        return new PageImpl<>(person.stream().map(e -> mapper.map(e, PersonDto.class)).collect(Collectors.toList()));
    }

    @Override
    public PersonDto findById(Long id) {
        Person person = checkExistence(id);
        return mapper.map(person, PersonDto.class);
    }

    @Override
    public PersonDto update(Long id, PersonForm personForm) {
        checkExistence(id);
        Person person = mapper.map(personForm, Person.class);
        person.setId(id);
        personRepository.save(person);

        return mapper.map(person, PersonDto.class);
    }

    @Override
    public void deleteById(Long id) {
        checkExistence(id);
        personRepository.deleteById(id);
    }

    @Override
    public URI create(PersonForm personForm) {
        Person person = mapper.map(personForm, Person.class);
        personRepository.save(person);
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(person.getId());
    }

    private Person checkExistence(Long id){
        return personRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Person not found"));
    }
}
