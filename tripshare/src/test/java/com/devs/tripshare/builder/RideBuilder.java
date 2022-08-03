package com.devs.tripshare.builder;

import com.devs.tripshare.dto.ride.RideDto;
import com.devs.tripshare.dto.ride.RideFormDto;
import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.dto.trip.TripForm;
import com.devs.tripshare.entities.Person;
import com.devs.tripshare.entities.Ride;
import com.devs.tripshare.entities.Trip;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RideBuilder {

    private static final List<String> CREWMEMBERSNAME = List.of("Mateus", "Fernanda");
    private static final Long ID = 1L;
    private static final List<Person> CREWMEMBERS = List.of(PersonBuilder.getPerson(), PersonBuilder.getPerson());
    private static final Trip TRIP = TripBuilder.getTrip();
    private static final BigDecimal DAILYPRECIMAL = BigDecimal.valueOf(15);
    private static final LocalDate DATE = LocalDate.now();


    public static Ride getRide(){
        return Ride.builder()
                .id(ID)
                .crewMembers(CREWMEMBERS)
                .trip(TRIP)
                .dailyPrecimal(DAILYPRECIMAL)
                .date(DATE)
                .build();
    }


    public static RideDto getRideDTO(){
        return RideDto.builder()
                .id(ID)
                .crewMembers(CREWMEMBERS)
                .trip(TRIP)
                .dailyPrecimal(DAILYPRECIMAL)
                .date(DATE)
                .build();
    }


    public static RideFormDto getRideForm(){
        return RideFormDto.builder()
                .crewMembers(CREWMEMBERSNAME)
                .tripId(TRIP.getId())
                .date(DATE)
                .build();
    }

    public static List<RideDto> getListOfRideDTO(){
        return List.of(getRideDTO(), getRideDTO());
    }

    public static List<Ride> getListOfRide(){
        return List.of(getRide(), getRide());
    }
}
