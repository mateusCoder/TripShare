package com.devs.tripshare.dto.ride;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideFormDto {

    @NotNull
    private List<String> crewMembers;

    @NotNull
    private Long tripId;
    private LocalDate date;
}
