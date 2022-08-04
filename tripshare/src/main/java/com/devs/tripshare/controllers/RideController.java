package com.devs.tripshare.controllers;

import com.devs.tripshare.config.annotations.rides.DeleteRideDocConfig;
import com.devs.tripshare.config.annotations.rides.GetAllRidesDocConfig;
import com.devs.tripshare.config.annotations.rides.GetRideByIdDocConfig;
import com.devs.tripshare.config.annotations.rides.SaveRideDocConfig;
import com.devs.tripshare.dto.ride.RideDto;
import com.devs.tripshare.dto.ride.RideFormDto;
import com.devs.tripshare.services.RideServiceImpl;
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
@RequiredArgsConstructor
@RequestMapping("/tripshare/rides")
public class RideController {

    private final RideServiceImpl service;

    @GetMapping
    @GetAllRidesDocConfig
    public ResponseEntity<Page<RideDto>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable page){
        return ResponseEntity.ok().body(service.findAll(page));
    }

    @GetMapping("/{id}")
    @GetRideByIdDocConfig
    public ResponseEntity<RideDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Transactional
    @PostMapping
    @SaveRideDocConfig
    public ResponseEntity<RideDto> save(@Valid @RequestBody RideFormDto rideFormDto){
        return ResponseEntity.created(service.saveRide(rideFormDto)).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    @DeleteRideDocConfig
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
