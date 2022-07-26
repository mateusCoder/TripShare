package com.devs.tripshare.dto.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonForm {

    @NotBlank
    private String name;

    @NotNull
    private boolean driver;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
