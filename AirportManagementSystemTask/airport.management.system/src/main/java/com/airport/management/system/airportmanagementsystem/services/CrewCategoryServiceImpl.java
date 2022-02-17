package com.airport.management.system.airportmanagementsystem.services;

import com.airport.management.system.airportmanagementsystem.models.CrewCategory;
import com.airport.management.system.airportmanagementsystem.repositories.CrewCategoryRepository;
import com.airport.management.system.airportmanagementsystem.services.interfaces.CrewCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CrewCategoryServiceImpl implements CrewCategoryService {

    private final CrewCategoryRepository crewCategoryRepository;


    @Override
    public List<CrewCategory> getAll() {
        List<CrewCategory> crewCategories = new ArrayList<>();
        crewCategoryRepository.findAll().forEach(crewCategories::add);
        return crewCategories;
    }

    @Override
    public CrewCategory getById(Integer id) {
        Optional<CrewCategory> optional = crewCategoryRepository.findById(id);
        CrewCategory category = null;
        if (optional.isPresent()) {
            category = optional.get();
        }
        return category;
    }

    @Override
    public CrewCategory save(CrewCategory crewCategory) {
        return crewCategoryRepository.save(crewCategory);
    }

    @Override
    public void deleteById(CrewCategory crewCategory, int id) {
        crewCategoryRepository.deleteById(id);
    }
}
