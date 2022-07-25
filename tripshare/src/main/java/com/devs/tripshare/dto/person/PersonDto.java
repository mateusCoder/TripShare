package com.devs.tripshare.dto.person;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;
    private String name;
    private boolean driver;
}
