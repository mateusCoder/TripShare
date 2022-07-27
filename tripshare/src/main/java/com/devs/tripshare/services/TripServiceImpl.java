package com.devs.tripshare.services;

import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.dto.trip.TripForm;
import com.devs.tripshare.entities.Trip;
import com.devs.tripshare.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    TripRepository repository;

    @Override
    public Page<TripDto> findAll(Pageable page) {
        Page<Trip> trip = repository.findAll(page);
        Page<TripDto> tripDtos = new PageImpl<>(trip.stream().map(e -> mapper.map(e, TripDto.class)).collect(Collectors.toList()));
        return tripDtos;
    }

    @Override
    public TripDto findById(Long id) {
        return mapper.map(checkExistence(id), TripDto.class);
    }

    @Override
    public TripDto update(Long id, TripForm tripForm) {
        checkExistence(id);
        Trip trip = mapper.map(tripForm, Trip.class);
        trip.setId(id);
        repository.save(trip);

        return mapper.map(trip, TripDto.class);
    }


    @Override
    public void deleteById(Long id) {
        checkExistence(id);
        repository.deleteById(id);
    }

    public Trip checkExistence(Long id){
        Optional<Trip> trip = repository.findById(id);
        if(trip.isPresent()){
            return trip.get();
        }else{
            throw new RuntimeException("Trip not found!");
        }
    }
}