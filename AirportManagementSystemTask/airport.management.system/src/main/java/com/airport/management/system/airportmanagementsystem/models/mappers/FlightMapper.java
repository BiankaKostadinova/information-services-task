package com.airport.management.system.airportmanagementsystem.models.mappers;

import com.airport.management.system.airportmanagementsystem.models.Flight;
import com.airport.management.system.airportmanagementsystem.models.FlightDto;
import com.airport.management.system.airportmanagementsystem.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FlightMapper {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightMapper(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight fromDto(FlightDto flightDto) {
        Flight flight = new Flight();
        dtoToObject(flightDto, flight);
        return flight;
    }

    private void dtoToObject(FlightDto flightDto, Flight flight) {
        flight.setDepartureTime(flightDto.getDepartureTime());
        flight.setArrivalTime(flightDto.getArrivalTime());
        flight.setStatus(flightDto.getStatus());
        flight.setFlightNumber(flightDto.getFlightNumber());
    }

}
