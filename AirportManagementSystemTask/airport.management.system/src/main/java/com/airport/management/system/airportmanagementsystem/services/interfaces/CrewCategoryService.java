package com.airport.management.system.airportmanagementsystem.services.interfaces;


import com.airport.management.system.airportmanagementsystem.models.Crew;
import com.airport.management.system.airportmanagementsystem.models.CrewCategory;

import java.util.List;

public interface CrewCategoryService {
    List<CrewCategory> getAll();

    CrewCategory getById(Integer id);

    CrewCategory save(CrewCategory crewCategory);

    void deleteById(CrewCategory crewCategory, int id);

}
