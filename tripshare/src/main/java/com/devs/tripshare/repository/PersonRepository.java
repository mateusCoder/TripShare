package com.devs.tripshare.repository;

import com.devs.tripshare.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
