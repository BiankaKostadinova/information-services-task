package com.airport.management.system.airportmanagementsystem.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight", schema = "airport_management_system", catalog = "")
public class Flight {
    private int id;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String status;
    private String flightNumber;
    private Route route;
    private Airline airline;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "departure_time")
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Column(name = "arrival_time")
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "status", length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "flight_number", length = 10)
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @OneToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @OneToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "id")
    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
