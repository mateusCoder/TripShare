package com.devs.tripshare.repository;

import com.devs.tripshare.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
