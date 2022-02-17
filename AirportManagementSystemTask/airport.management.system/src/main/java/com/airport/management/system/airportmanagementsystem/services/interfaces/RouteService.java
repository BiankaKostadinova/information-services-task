package com.airport.management.system.airportmanagementsystem.services.interfaces;

import com.airport.management.system.airportmanagementsystem.models.Route;

import java.util.List;

public interface RouteService {
    List<Route> getAll();

    Route getById(Integer id);

    Route save(Route route);

    void deleteById(Route route, int id);
}
