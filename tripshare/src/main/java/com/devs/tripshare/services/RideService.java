package com.devs.tripshare.services;

import com.devs.tripshare.dto.ride.RideDto;
import com.devs.tripshare.dto.ride.RideFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface RideService {

    Page<RideDto> findAll(Pageable page);

    void deleteById(Long id);

    URI saveRide(RideFormDto rideFormDto);

    RideDto findById(Long id);
}
