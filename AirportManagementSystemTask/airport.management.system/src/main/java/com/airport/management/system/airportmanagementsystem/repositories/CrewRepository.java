package com.airport.management.system.airportmanagementsystem.repositories;

import com.airport.management.system.airportmanagementsystem.models.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Integer> {
}
