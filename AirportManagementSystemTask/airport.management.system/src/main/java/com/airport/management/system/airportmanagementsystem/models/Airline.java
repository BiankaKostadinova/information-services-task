package com.airport.management.system.airportmanagementsystem.models;

import javax.persistence.*;

@Entity
@Table(name = "airline", schema = "airport_management_system", catalog = "")
public class Airline {
    private int id;
    private String airlineName;
    private String airlinePhone;
    private String airlineCode;

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
    @Column(name = "airline_name", length = 100)
    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @Basic
    @Column(name = "airline_phone", length = 30)
    public String getAirlinePhone() {
        return airlinePhone;
    }

    public void setAirlinePhone(String airlinePhone) {
        this.airlinePhone = airlinePhone;
    }

    @Basic
    @Column(name = "airline_code", length = 4)
    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }
}
