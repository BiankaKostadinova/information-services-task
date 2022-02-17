package com.airport.management.system.airportmanagementsystem.services.interfaces;

import com.airport.management.system.airportmanagementsystem.models.Airline;
import com.airport.management.system.airportmanagementsystem.models.Crew;

import java.util.List;

public interface AirlineService {
    List<Airline> getAll();

    Airline getById(Integer id);

    Airline save(Airline airline);

    void deleteById(Airline airline, int id);
}
