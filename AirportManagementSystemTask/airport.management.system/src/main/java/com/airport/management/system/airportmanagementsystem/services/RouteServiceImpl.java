package com.airport.management.system.airportmanagementsystem.services;

import com.airport.management.system.airportmanagementsystem.models.Route;
import com.airport.management.system.airportmanagementsystem.repositories.RouteRepository;
import com.airport.management.system.airportmanagementsystem.services.interfaces.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;

    @Override
    public List<Route> getAll() {
        List<Route> routes = new ArrayList<>();
        routeRepository.findAll().forEach(routes::add);
        return routes;
    }

    @Override
    public Route getById(Integer id) {
        Optional<Route> optional = routeRepository.findById(id);
        Route route = null;
        if (optional.isPresent()) {
            route = optional.get();
        }
        return route;
    }

    @Override
    public Route save(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public void deleteById(Route route, int id) {
        routeRepository.deleteById(id);
    }
}
