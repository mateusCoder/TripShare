package com.devs.tripshare.dto.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripForm {

    @NotBlank
    private String name;

    @NotNull
    private Double distance;

    @NotNull
    private Double fuelUse;

    @NotNull
    private Double fuelPrice;

    @NotNull
    private LocalDate date;
}
