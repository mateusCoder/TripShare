package com.devs.tripshare.dto.trip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripForm {

    private Long id;
    private String name;
    private Double distance;
    private Double fuelUse;
    private Double fuelPrice;
    private LocalDate date;
}
