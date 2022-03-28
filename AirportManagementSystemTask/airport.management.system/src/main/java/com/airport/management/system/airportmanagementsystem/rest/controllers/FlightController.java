package com.airport.management.system.airportmanagementsystem.rest.controllers;

import com.airport.management.system.airportmanagementsystem.exeptions.DuplicateEntityException;
import com.airport.management.system.airportmanagementsystem.exeptions.EntityNotFoundException;
import com.airport.management.system.airportmanagementsystem.models.Flight;
import com.airport.management.system.airportmanagementsystem.models.FlightDto;
import com.airport.management.system.airportmanagementsystem.models.mappers.FlightMapper;
import com.airport.management.system.airportmanagementsystem.services.interfaces.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;
    private final FlightMapper flightMapper;

    @Autowired
    public FlightController(FlightService flightService, FlightMapper flightMapper) {
        this.flightService = flightService;
        this.flightMapper = flightMapper;
    }

    @GetMapping()
    public ResponseEntity<List<Flight>> getAll() {
        return ResponseEntity.ok().body(flightService.getAll());
    }

    @GetMapping("/{id}")
    public Flight getById(@PathVariable int id) {
        try {
            return flightService.getById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public Flight create(@RequestBody FlightDto flightDto) {
        try {
            Flight flight = flightMapper.fromDto(flightDto);
            flightService.save(flight);
            return flight;
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

}
