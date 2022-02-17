package com.airport.management.system.airportmanagementsystem.models;

import javax.persistence.*;

@Entity
@Table(name = "assignments", schema = "airport_management_system", catalog = "")
public class CrewCategory {

    private int id;
    private String description;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
