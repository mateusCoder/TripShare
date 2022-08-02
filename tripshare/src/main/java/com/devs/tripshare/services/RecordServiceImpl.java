package com.devs.tripshare.services;

import com.devs.tripshare.dto.record.RecordDto;
import com.devs.tripshare.dto.record.RecordForm;
import com.devs.tripshare.entities.Person;
import com.devs.tripshare.entities.Record;
import com.devs.tripshare.entities.Ride;
import com.devs.tripshare.exceptions.ObjectNotFound;
import com.devs.tripshare.repository.PersonRepository;
import com.devs.tripshare.repository.RideRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class RecordServiceImpl implements RecordService{

    private final PersonRepository personRepository;

    private final RideRepository rideRepository;

    private final PersonServiceImpl personService;

    private final ModelMapper mapper;

    @Override
    public RecordDto findAll(RecordForm form) {

        personRepository.findByName(form.getName()).orElseThrow(() -> new ObjectNotFound("Person Not Found"));

        List<Ride> rides = rideRepository.findByCrewMembersName(form.getName());
        List<Ride> ridesList = rideRepository.findByDateBetween(form.getInitialDate(), form.getFinalDate());
        Set<Ride> rideSet = new HashSet<>(rides);
        rideSet.retainAll(ridesList);

        BigDecimal totalRide = rideSet.stream().map(e -> e.getDailyPrecimal())
                .reduce(BigDecimal.valueOf(0), (x,y) -> x.add(y));

        Record record = new Record();
        record.setName(form.getName());
        record.setTotalPriceRides(totalRide);

        List<LocalDate> ridesDates = rideSet.stream().map(e -> e.getDate()).toList();

        record.setListOfRides(rideSet);

        RecordDto dto = new RecordDto();
        dto.setName(record.getName());
        dto.setTotalPriceRides(record.getTotalPriceRides());
        dto.setListOfDate(ridesDates);
        return dto;
    }
}
