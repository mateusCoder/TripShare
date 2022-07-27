package com.devs.tripshare.dto.ride;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideFormDto {

    private List<String> crewMembers;
    private Long tripId;

}
