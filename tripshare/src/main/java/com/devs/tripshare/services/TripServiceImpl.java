package com.devs.tripshare.services;

import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.dto.trip.TripForm;
import com.devs.tripshare.entities.Trip;
import com.devs.tripshare.exceptions.ObjectNotFound;
import com.devs.tripshare.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public URI create(TripForm tripForm) {
        Trip trip = mapper.map(tripForm, Trip.class);
        repository.save(trip);
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(trip.getId());
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
        return repository.findById(id).orElseThrow(() -> new ObjectNotFound("Trip not found!"));
    }
}
