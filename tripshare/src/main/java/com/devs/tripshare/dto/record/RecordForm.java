package com.devs.tripshare.dto.record;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordForm {

    private String name;
    private LocalDate initialDate;
    private LocalDate finalDate;
}
