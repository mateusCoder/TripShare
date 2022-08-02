package com.devs.tripshare.controllers;

import com.devs.tripshare.builder.PersonBuilder;
import com.devs.tripshare.dto.person.PersonDto;
import com.devs.tripshare.services.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@AutoConfigureTestDatabase
class PersonControllerTest {

    @InjectMocks
    private PersonController controller;

    @Mock
    private PersonServiceImpl service;

    private final Long id = 1L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void WhenFindAllWithSuccess() {
        when(service.findAll((Pageable) any())).thenReturn(PersonBuilder.getPagePersonDto());

        Pageable page = PageRequest.of(0, 100);
        ResponseEntity<Page<PersonDto>> response = controller.findAll(page);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
    }

    @Test
    void WhenFindByIdWithSuccess() {
        when(service.findById(anyLong())).thenReturn(PersonBuilder.getPersonDto());

        ResponseEntity<PersonDto> response = controller.findById(id);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void whenCreateWithSuccess() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("tripShare/people/{id}")
                .build(PersonBuilder.getPerson().getId());

        when(service.create(any())).thenReturn(uri);

        ResponseEntity<PersonDto> response = controller.create(PersonBuilder.getPersonForm());

        assertNotNull(response);
        assertEquals(uri.toString(), "http://localhost/tripShare/people/1");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

    }

    @Test
    void whenUpdateWithSuccess() {
        when(service.update(id, PersonBuilder.getPersonForm())).thenReturn(PersonBuilder.getPersonDto());

        ResponseEntity<PersonDto> response = controller.update(id, PersonBuilder.getPersonForm());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void whenDeleteByIdWithSuccess(){
        doNothing().when(service).deleteById(anyLong());

        ResponseEntity<?> response = controller.delete(id);

        assertEquals(ResponseEntity.class, response.getClass());
        verify(service, times(1)).deleteById(anyLong());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}