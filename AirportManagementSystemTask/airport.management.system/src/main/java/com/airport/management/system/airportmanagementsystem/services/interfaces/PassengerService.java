package com.airport.management.system.airportmanagementsystem.services.interfaces;

import com.airport.management.system.airportmanagementsystem.models.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService {
    void deleteById(int id);

    List<Passenger> getAll();

    Passenger getById(Integer id);

    Passenger save(Passenger passenger);

    Passenger update(int id, Passenger passenger);


}
