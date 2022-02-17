package com.airport.management.system.airportmanagementsystem.services;

import com.airport.management.system.airportmanagementsystem.exeptions.EntityNotFoundException;
import com.airport.management.system.airportmanagementsystem.models.Flight;
import com.airport.management.system.airportmanagementsystem.repositories.FlightRepository;
import com.airport.management.system.airportmanagementsystem.services.interfaces.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Override
    public List<Flight> getAll() {
        List<Flight> flights = new ArrayList<>();
        flightRepository.findAll().forEach(flights::add);
        return flights;
    }

    @Override
    public Flight getById(Integer id) {
        Optional<Flight> optional = flightRepository.findById(id);
        Flight flight = null;
        if (optional.isPresent()) {
            flight = optional.get();
        } else {
            throw new EntityNotFoundException("Flight", "id", String.valueOf(id));
        }
        return flight;
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteById(Flight flight, int id) {
        flightRepository.deleteById(id);
    }
}
