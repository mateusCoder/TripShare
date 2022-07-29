package com.devs.tripshare.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Person> crewMembers;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private BigDecimal dailyPrecimal;
}
