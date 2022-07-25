package com.devs.tripshare.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Person> crewMembers;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private BigDecimal dailyPrecimal;

}
