package com.devs.tripshare.services;

import com.devs.tripshare.builder.PersonBuilder;
import com.devs.tripshare.dto.person.PersonDto;
import com.devs.tripshare.entities.Person;
import com.devs.tripshare.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.net.URI;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@AutoConfigureTestDatabase
class PersonServiceImplTest {

    @InjectMocks
    PersonServiceImpl service;

    @Mock
    PersonRepository repository;

    @Spy
    ModelMapper mapper;

    private final Long id = 1L;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        when(repository.findAll((Pageable) any())).thenReturn(PersonBuilder.getPagePerson());

        Pageable page = PageRequest.of(0, 100);
        Page<PersonDto> response = service.findAll(page);

        assertNotNull(response);
        assertEquals(1, response.getTotalElements());
    }

    @Test
    void findById() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(PersonBuilder.getPerson()));

        PersonDto response = service.findById(id);

        assertNotNull(response);
        assertEquals(PersonDto.class, response.getClass());
        assertEquals(id, response.getId());
    }

    @Test
    void update() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(PersonBuilder.getPerson()));
        when(repository.save(any())).thenReturn(PersonBuilder.getPerson());

        PersonDto response = service.update(id, PersonBuilder.getPersonForm());

        assertNotNull(response);
        assertEquals(PersonDto.class, response.getClass());
        assertEquals(PersonBuilder.getPersonForm().getName(), response.getName());

    }

    @Test
    void deleteById() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(PersonBuilder.getPerson()));
        doNothing().when(repository).deleteById(anyLong());

        service.deleteById(id);

        verify(repository, times(1)).deleteById(id);

    }

    @Test
    void create() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(repository.save(any())).thenReturn(PersonBuilder.getPerson());

        URI response = service.create(PersonBuilder.getPersonForm());

        verify(repository, times(1)).save(any(Person.class));
    }

    @Test
    void checkExistence(){
        when(repository.findById(anyLong())).thenReturn(Optional.of(PersonBuilder.getPerson()));
    }
}