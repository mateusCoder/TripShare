package com.devs.tripshare.services;

import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.dto.trip.TripForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TripService{
    void deleteById(Long id);

    TripDto update(Long id, TripForm tripForm);

    Page<TripDto> findAll(Pageable page);

    TripDto findById(Long id);
}
