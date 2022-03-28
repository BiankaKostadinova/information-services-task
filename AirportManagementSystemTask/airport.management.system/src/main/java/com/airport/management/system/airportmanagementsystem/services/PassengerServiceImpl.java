package com.airport.management.system.airportmanagementsystem.services;

import com.airport.management.system.airportmanagementsystem.exeptions.DuplicateEntityException;
import com.airport.management.system.airportmanagementsystem.exeptions.EntityNotFoundException;
import com.airport.management.system.airportmanagementsystem.models.Passenger;
import com.airport.management.system.airportmanagementsystem.repositories.PassengerRepository;
import com.airport.management.system.airportmanagementsystem.services.interfaces.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<Passenger> getAll() {
        List<Passenger> passengers = new ArrayList<>();
        passengerRepository.findAll().forEach(passengers::add);
        return passengers;
    }

    @Override
    public Passenger getById(Integer id) {
        Optional<Passenger> optional = passengerRepository.findById(id);
        Passenger passenger = null;
        if (optional.isPresent()) {
            passenger = optional.get();
        } else {
            throw new EntityNotFoundException("Passenger", "id", String.valueOf(id));
        }
        return passenger;
    }

    @Override
    public Passenger save(Passenger passenger) {
        if (passengerRepository.findAll().contains(passengerRepository.getByTicketNumber(passenger.getTicketNumber()))) {
            throw new DuplicateEntityException("Passenger", "ticketNumber", passenger.getTicketNumber());
        }
        return passengerRepository.save(passenger);
    }

    @Override
    public void deleteById(int id) {
        passengerRepository.deleteById(id);
    }

    @Override
    public Passenger update(int id, Passenger passenger) {
        Passenger found = null;
        for (Passenger p : passengerRepository.findAll()) {
            if (p.getId() == id) {
                found = p;
                found.setPassportNumber(passenger.getPassportNumber());
            }
        }

        if (found != null) {
            return passengerRepository.save(found);
        } else {
            throw new EntityNotFoundException("Passenger", "passportNumber", passenger.getPassportNumber());
        }
    }

}
