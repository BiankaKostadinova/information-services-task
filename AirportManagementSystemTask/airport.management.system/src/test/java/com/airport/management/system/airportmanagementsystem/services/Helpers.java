package com.airport.management.system.airportmanagementsystem.services;

import com.airport.management.system.airportmanagementsystem.models.Flight;
import com.airport.management.system.airportmanagementsystem.models.Passenger;

public class Helpers {
    public static Passenger createMockPassenger() {
        var mockPassenger = new Passenger();
        mockPassenger.setId(1);
        mockPassenger.setFirstName("passenger");
        mockPassenger.setLastName("passenger");
        mockPassenger.setPassportNumber("1111111");
        mockPassenger.setTicketNumber("ticket111");
        mockPassenger.setFlight(new Flight());

        return mockPassenger;
    }
}
