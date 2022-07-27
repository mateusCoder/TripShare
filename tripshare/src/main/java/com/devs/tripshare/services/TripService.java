package com.devs.tripshare.services;

import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.dto.trip.TripForm;

public interface TripService{
    void deleteById(Long id);

    TripDto update(Long id, TripForm tripForm);
}
