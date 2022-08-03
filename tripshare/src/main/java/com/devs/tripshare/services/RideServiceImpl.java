package com.devs.tripshare.services;

import com.devs.tripshare.dto.ride.RideDto;
import com.devs.tripshare.dto.ride.RideFormDto;
import com.devs.tripshare.entities.Person;
import com.devs.tripshare.entities.Ride;
import com.devs.tripshare.entities.Trip;
import com.devs.tripshare.exceptions.ObjectNotFound;
import com.devs.tripshare.repository.PersonRepository;
import com.devs.tripshare.repository.RideRepository;
import com.devs.tripshare.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RideServiceImpl implements RideService{

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TripRepository tripRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<RideDto> findAll(Pageable page) {
        Page<Ride> ride = rideRepository.findAll(page);
        return ride.map(e -> modelMapper.map(e, RideDto.class));
    }

    @Override
    public RideDto findById(Long id) {
        Ride ride = checkExistence(id);
        return modelMapper.map(ride, RideDto.class);
    }

    @Override
    public URI saveRide(RideFormDto rideFormDto) {

        Ride ride = new Ride();
        List<Person> crewMembers = new ArrayList<>();

        rideFormDto.getCrewMembers().forEach(
                e -> {
                    Person person = personRepository.findByName(e).orElseThrow(() -> new ObjectNotFound("Ride Not found"));
                    crewMembers.add(person);
                });

        Trip trip = tripRepository.findById(rideFormDto.getTripId()).orElseThrow(() -> new ObjectNotFound("Ride Not found"));

        BigDecimal finalPrice = BigDecimal.valueOf(((trip.getDistance() / trip.getFuelUse()) * trip.getFuelPrice()) / crewMembers.size());

        ride.setCrewMembers(crewMembers);
        ride.setTrip(trip);
        ride.setDailyPrecimal(finalPrice);
        ride.setDate(rideFormDto.getDate());

        rideRepository.save(ride);

        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(ride.getId());
    }

    @Override
    public void deleteById(Long id) {
        checkExistence(id);
        rideRepository.deleteById(id);
    }


    private Ride checkExistence(Long id){
        return rideRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Ride Not found"));
    }

}
