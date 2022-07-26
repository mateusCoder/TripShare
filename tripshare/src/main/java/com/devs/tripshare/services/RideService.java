package com.devs.tripshare.services;

import com.devs.tripshare.dto.ride.RideDto;
import com.devs.tripshare.dto.ride.RideFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface RideService {

    URI saveRide(RideFormDto rideFormDto);

    void deleteById(Long id);

    Page<RideDto> findAll(Pageable page);
}
