package com.devs.tripshare.dto.ride;

import com.devs.tripshare.entities.Person;
import com.devs.tripshare.entities.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RideDto {

    private Long id;
    private List<Person> crewMembers;
    private Trip trip;
    private BigDecimal dailyPrecimal;
    private LocalDate date;
}
