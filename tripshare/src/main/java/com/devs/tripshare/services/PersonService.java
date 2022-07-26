package com.devs.tripshare.services;

import com.devs.tripshare.dto.person.PersonDto;
import com.devs.tripshare.dto.person.PersonForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService{

   Page<PersonDto> findAll(Pageable page);

    PersonDto findById(Long id);

    PersonDto update(Long id, PersonForm personForm);

    void deleteById(Long id);
}
