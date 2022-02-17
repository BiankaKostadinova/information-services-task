package com.airport.management.system.airportmanagementsystem.models;

import javax.persistence.*;

@Entity
@Table(name = "route", schema = "airport_management_system", catalog = "")
public class Route {

    private int id;
    private String departureAirport;
    private String arrivalAirport;
    private String airDistance;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "departure_airport", length = 100)
    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    @Basic
    @Column(name = "arrival_airport", length = 100)
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @Basic
    @Column(name = "air_distance", length = 20)
    public String getAirDistance() {
        return airDistance;
    }

    public void setAirDistance(String airDistance) {
        this.airDistance = airDistance;
    }
}
