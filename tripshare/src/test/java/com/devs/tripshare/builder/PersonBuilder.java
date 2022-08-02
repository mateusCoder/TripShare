package com.devs.tripshare.builder;

import com.devs.tripshare.dto.person.PersonDto;
import com.devs.tripshare.dto.person.PersonForm;
import com.devs.tripshare.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class PersonBuilder {

    private static final Long id            = 1L;
    private static final String name        = "Mateus";
    private static final boolean driver     = true;
    private static final String email       = "mateus@email.com";
    private static final String password    = "123";


    public static Person getPerson(){
        return Person.builder()
                .id(id)
                .name(name)
                .driver(driver)
                .email(email)
                .password(password)
                .build();
    }

    public static PersonDto getPersonDto(){
        return PersonDto.builder()
                .id(id)
                .name(name)
                .driver(driver)
                .build();
    }

    public static PersonForm getPersonForm(){
        return PersonForm.builder()
                .name(name)
                .driver(driver)
                .email(email)
                .password(password)
                .build();
    }

    public static Page<Person> getPagePerson(){
        return new PageImpl<>(List.of(getPerson()));
    }

    public static Page<PersonDto> getPagePersonDto(){
        return new PageImpl<>(List.of(getPersonDto()));
    }
}
