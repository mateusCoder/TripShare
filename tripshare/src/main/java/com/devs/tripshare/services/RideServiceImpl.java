package com.devs.tripshare.services;

import com.devs.tripshare.dto.ride.RideFormDto;
import com.devs.tripshare.entities.Person;
import com.devs.tripshare.entities.Ride;
import com.devs.tripshare.entities.Trip;
import com.devs.tripshare.repository.PersonRepository;
import com.devs.tripshare.repository.RideRepository;
import com.devs.tripshare.repository.TripRepository;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class RideServiceImpl implements RideService{

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private ModelMapper modelMapper;

    private RuntimeException objectNotFoundEx = new RuntimeException("Object Not Found!");

    @Override
    public URI saveRide(RideFormDto rideFormDto) {
        Ride ride = modelMapper.map(rideFormDto, Ride.class);

        List<Person> crewMembers = new ArrayList<>();

        rideFormDto.getCrewMembers().forEach(
                e -> {
                    Person person = personRepository.findByName(e).orElseThrow(() -> objectNotFoundEx);
                    crewMembers.add(person);
                });

        Trip trip = tripRepository.findById(rideFormDto.getTripId()).orElseThrow(() -> objectNotFoundEx);

        ride.setCrewMembers(crewMembers);
        ride.setTrip(trip);

        rideRepository.save(ride);

        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ride.getId()).toUri();
    }

}