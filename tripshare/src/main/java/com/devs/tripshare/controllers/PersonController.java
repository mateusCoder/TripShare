package com.devs.tripshare.controllers;

import com.devs.tripshare.config.annotations.persons.*;
import com.devs.tripshare.dto.person.PersonDto;
import com.devs.tripshare.dto.person.PersonForm;
import com.devs.tripshare.exceptions.FieldMessage;
import com.devs.tripshare.exceptions.StandardError;
import com.devs.tripshare.services.PersonServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/tripshare/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl service;

    @GetMapping
    @GetAllPersonDocConfig
    public ResponseEntity<Page<PersonDto>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable page){
        return ResponseEntity.ok().body(service.findAll(page));
    }

    @GetMapping("/{id}")
    @GetPersonByIdDocConfig
    public ResponseEntity<PersonDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Transactional
    @PostMapping
    @SavePersonDocConfig
    public ResponseEntity<PersonDto> create(@Valid @RequestBody PersonForm personForm){
        return ResponseEntity.created(service.create(personForm)).build();
    }

    @Transactional
    @PutMapping("/{id}")
    @UpdatePersonDocConfig
    public ResponseEntity<PersonDto> update(@PathVariable Long id, @Valid  @RequestBody PersonForm personForm){
        return ResponseEntity.ok().body(service.update(id, personForm));
    }

    @Transactional
    @DeleteMapping("/{id}")
    @DeletePersonDocConfig
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
