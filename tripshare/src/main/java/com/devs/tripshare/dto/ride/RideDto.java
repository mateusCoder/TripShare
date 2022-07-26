package com.devs.tripshare.dto.ride;

import com.devs.tripshare.entities.Person;
import com.devs.tripshare.entities.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideDto {

    private Long id;
    private List<Person> crewMembers;
    private Trip trip;
    private BigDecimal dailyPrecimal;
}
