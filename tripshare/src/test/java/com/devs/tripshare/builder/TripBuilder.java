package com.devs.tripshare.builder;

import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.dto.trip.TripForm;
import com.devs.tripshare.entities.Trip;

import java.time.LocalDate;
import java.util.List;

public class TripBuilder {

    private static final Long ID = 1L;
    private static final String NAME = "Sem Juninho";
    private static final Double DISTANCE = 90.0;
    private static final Double FUELUSE = 15.0;
    private static final Double FUELPRICE = 5.50;
    private static final LocalDate DATE = LocalDate.now();

    public static Trip getTrip(){
        return Trip.builder()
                .id(ID)
                .name(NAME)
                .distance(DISTANCE)
                .fuelUse(FUELUSE)
                .fuelPrice(FUELPRICE)
                .build();
    }


    public static TripDto getTripDTO(){
        return TripDto.builder()
                .id(ID)
                .name(NAME)
                .distance(DISTANCE)
                .fuelUse(FUELUSE)
                .fuelPrice(FUELPRICE)
                .build();
    }


    public static TripForm getTripForm(){
        return TripForm.builder()
                .name(NAME)
                .distance(DISTANCE)
                .fuelUse(FUELUSE)
                .fuelPrice(FUELPRICE)
                .build();
    }

    public static List<TripDto> getListOfTripDTO(){
        return List.of(getTripDTO(), getTripDTO());
    }

    public static List<Trip> getListOfTrip(){
        return List.of(getTrip(), getTrip());
    }
}
