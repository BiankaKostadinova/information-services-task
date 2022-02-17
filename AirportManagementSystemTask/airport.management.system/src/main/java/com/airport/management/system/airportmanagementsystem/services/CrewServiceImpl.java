package com.airport.management.system.airportmanagementsystem.services;

import com.airport.management.system.airportmanagementsystem.models.Crew;
import com.airport.management.system.airportmanagementsystem.repositories.CrewRepository;
import com.airport.management.system.airportmanagementsystem.services.interfaces.CrewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CrewServiceImpl implements CrewService {

    private final CrewRepository crewRepository;

    @Override
    public List<Crew> getAll() {
        List<Crew> crews = new ArrayList<>();
        crewRepository.findAll().forEach(crews::add);
        return crews;
    }

    @Override
    public Crew getById(Integer id) {
        Optional<Crew> optional = crewRepository.findById(id);
        Crew crew = null;
        if (optional.isPresent()) {
            crew = optional.get();
        }
        return crew;
    }

    @Override
    public Crew save(Crew crew) {
        return crewRepository.save(crew);
    }

    @Override
    public void deleteById(Crew crew, int id) {
        crewRepository.deleteById(id);
    }
}
