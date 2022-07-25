package com.devs.tripshare.services;

import com.devs.tripshare.dto.person.PersonDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService{

   Page<PersonDto> findAll(Pageable page);
}
