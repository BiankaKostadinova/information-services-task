package com.airport.management.system.airportmanagementsystem.services;

import com.airport.management.system.airportmanagementsystem.exeptions.EntityNotFoundException;
import com.airport.management.system.airportmanagementsystem.models.Airline;
import com.airport.management.system.airportmanagementsystem.repositories.AirlineRepository;
import com.airport.management.system.airportmanagementsystem.services.interfaces.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AirlineServiceImpl implements AirlineService {

    private AirlineRepository airlineRepository;

    @Override
    public List<Airline> getAll() {
        List<Airline> airlines = new ArrayList<>();
        airlineRepository.findAll().forEach(airlines::add);
        return airlines;
    }

    @Override
    public Airline getById(Integer id) {
        Optional<Airline> optional = airlineRepository.findById(id);
        Airline airline = null;
        if (optional.isPresent()) {
            airline = optional.get();
        } else {
            throw new EntityNotFoundException("Airline", "id", String.valueOf(id));
        }
        return airline;
    }

    @Override
    public Airline save(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public void deleteById(Airline airline, int id) {
        airlineRepository.deleteById(id);
    }
}
