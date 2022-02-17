package com.airport.management.system.airportmanagementsystem.services.interfaces;

import com.airport.management.system.airportmanagementsystem.models.Crew;

import java.util.List;

public interface CrewService {
    List<Crew> getAll();

    Crew getById(Integer id);

    Crew save(Crew crew);

    void deleteById(Crew crew, int id);
}
