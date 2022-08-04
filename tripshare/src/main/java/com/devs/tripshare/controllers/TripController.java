package com.devs.tripshare.controllers;

import com.devs.tripshare.config.annotations.trips.*;
import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.dto.trip.TripForm;
import com.devs.tripshare.services.TripServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/tripshare/trips")
public class TripController{

    @Autowired
    TripServiceImpl service;

    @GetMapping
    @GetAllTripDocConfig
    public ResponseEntity<Page<TripDto>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)Pageable page){
        return ResponseEntity.ok().body(service.findAll(page));
    }

    @GetMapping("/{id}")
    @GetTripByIdDocConfig
    public ResponseEntity<TripDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Transactional
    @PostMapping
    @SaveTripDocConfig
    public ResponseEntity<TripDto> create(@Valid @RequestBody TripForm tripForm){
        return ResponseEntity.created(service.create(tripForm)).build();
    }

    @Transactional
    @PutMapping("/{id}")
    @UpdateTripDocConfig
    public ResponseEntity<TripDto> update(@PathVariable Long id, @Valid @RequestBody TripForm tripForm){
        return ResponseEntity.ok().body(service.update(id, tripForm));
    }

    @Transactional
    @DeleteMapping("/{id}")
    @DeleteTripDocConfig
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
