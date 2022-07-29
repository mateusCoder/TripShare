package com.devs.tripshare.repository;

import com.devs.tripshare.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride>  findByCrewMembersId(Long id);
}
