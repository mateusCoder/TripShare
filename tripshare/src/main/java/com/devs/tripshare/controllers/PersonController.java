package com.devs.tripshare.controllers;

import com.devs.tripshare.dto.person.PersonDto;
import com.devs.tripshare.dto.person.PersonForm;
import com.devs.tripshare.entities.Person;
import com.devs.tripshare.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/tripshare/people")
public class PersonController {

    @Autowired
    PersonServiceImpl service;

    @GetMapping
    public ResponseEntity<Page<PersonDto>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable page){
        return ResponseEntity.ok().body(service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonForm personForm){
        return ResponseEntity.created(service.create(personForm)).build();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable Long id, @RequestBody PersonForm personForm){
        return ResponseEntity.ok().body(service.update(id, personForm));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
