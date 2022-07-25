package com.devs.tripshare.dto.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonForm {

    private Long id;
    private String name;
    private boolean driver;
    private String email;
    private String password;
}
