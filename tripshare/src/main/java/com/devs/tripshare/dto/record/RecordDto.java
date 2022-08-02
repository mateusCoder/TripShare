package com.devs.tripshare.dto.record;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class RecordDto {

    private String name;
    private List<LocalDate> listOfDate;
    private BigDecimal totalPriceRides;
}
