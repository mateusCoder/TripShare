package com.devs.tripshare.repository;

import com.devs.tripshare.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByCrewMembersName(String name);

    List<Ride> findByDateBetween(LocalDate initialDate, LocalDate finalDate);
}
