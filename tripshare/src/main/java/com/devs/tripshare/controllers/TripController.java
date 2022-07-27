package com.devs.tripshare.controllers;

import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.dto.trip.TripForm;
import com.devs.tripshare.entities.Trip;
import com.devs.tripshare.services.TripServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/tripshare/trips")
public class TripController{

    @Autowired
    TripServiceImpl service;

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<TripDto> update(@PathVariable Long id, @RequestBody TripForm tripForm){
        return ResponseEntity.ok().body(service.update(id, tripForm));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
