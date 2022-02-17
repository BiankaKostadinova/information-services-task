package com.airport.management.system.airportmanagementsystem.repositories;

import com.airport.management.system.airportmanagementsystem.models.CrewCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewCategoryRepository extends JpaRepository<CrewCategory, Integer> {

}
