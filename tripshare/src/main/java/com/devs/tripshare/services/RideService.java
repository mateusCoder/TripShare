package com.devs.tripshare.services;

import com.devs.tripshare.dto.ride.RideFormDto;

import java.net.URI;

public interface RideService {

    URI saveRide(RideFormDto rideFormDto);
}
