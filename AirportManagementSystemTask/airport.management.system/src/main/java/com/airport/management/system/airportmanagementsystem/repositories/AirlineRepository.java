package com.airport.management.system.airportmanagementsystem.repositories;

import com.airport.management.system.airportmanagementsystem.models.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}
