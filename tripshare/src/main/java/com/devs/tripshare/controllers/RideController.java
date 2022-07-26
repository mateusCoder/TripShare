package com.devs.tripshare.controllers;

import com.devs.tripshare.dto.ride.RideDto;
import com.devs.tripshare.dto.ride.RideFormDto;
import com.devs.tripshare.entities.Ride;
import com.devs.tripshare.services.RideServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tripshare/rides")
public class RideController {

    private final RideServiceImpl service;

    @Transactional
    @PostMapping
    public ResponseEntity<RideDto> save(@RequestBody RideFormDto rideFormDto){
        return ResponseEntity.created(service.saveRide(rideFormDto)).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
