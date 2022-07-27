package com.devs.tripshare.services;

import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.dto.trip.TripForm;
import com.devs.tripshare.entities.Trip;
import com.devs.tripshare.repository.TripRepository;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    TripRepository repository;

    @Override
    public void deleteById(Long id) {
    findById(id);
    repository.deleteById(id);
    }

    @Override
    public TripDto update(Long id, TripForm tripForm) {
        findById(id);
        Trip trip = mapper.map(tripForm, Trip.class);
        trip.setId(id);
        repository.save(trip);

        return mapper.map(trip, TripDto.class);
    }

    public Trip findById(Long id){
        Optional<Trip> trip = repository.findById(id);
        if(trip.isPresent()){
            return trip.get();
        }else{
            throw new RuntimeException("Trip not found!");
        }
    }
}
