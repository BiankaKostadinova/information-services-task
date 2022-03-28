package com.airport.management.system.airportmanagementsystem.services.interfaces;

import com.airport.management.system.airportmanagementsystem.models.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getAll();

    Flight getById(Integer id);

    Flight save(Flight flight);

    void deleteById(Flight flight, int id);

}
