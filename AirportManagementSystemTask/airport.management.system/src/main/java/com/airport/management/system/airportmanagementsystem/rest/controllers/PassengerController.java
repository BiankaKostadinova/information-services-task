package com.airport.management.system.airportmanagementsystem.rest.controllers;

import com.airport.management.system.airportmanagementsystem.exeptions.DuplicateEntityException;
import com.airport.management.system.airportmanagementsystem.exeptions.EntityNotFoundException;
import com.airport.management.system.airportmanagementsystem.models.Passenger;
import com.airport.management.system.airportmanagementsystem.services.interfaces.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping()
    public ResponseEntity<List<Passenger>> getAll() {
        return ResponseEntity.ok().body(passengerService.getAll());
    }

    @GetMapping("/{id}")
    public Passenger getById(@PathVariable int id) {
        try {
            return passengerService.getById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<Passenger> create(@RequestBody Passenger passenger) {
        try {
            Passenger newPassenger = passengerService.save(passenger);
            return new ResponseEntity<>(newPassenger, HttpStatus.CREATED);
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> update(@PathVariable int id, @RequestBody Passenger passenger) {
        try {
            Passenger updatedPassenger = passengerService.update(id, passenger);
            return new ResponseEntity<>(updatedPassenger, HttpStatus.ACCEPTED);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            passengerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
