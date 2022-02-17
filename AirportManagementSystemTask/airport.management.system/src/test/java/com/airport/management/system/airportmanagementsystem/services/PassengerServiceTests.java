package com.airport.management.system.airportmanagementsystem.services;

import com.airport.management.system.airportmanagementsystem.repositories.PassengerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PassengerServiceTests {
    @Mock
    PassengerRepository mockRepository;
    @InjectMocks
    PassengerServiceImpl service;

    @Test
    public void getAll_should_callRepository() {
        Mockito.when(mockRepository.findAll())
                .thenReturn(new ArrayList<>());

        service.getAll();

        Mockito.verify(mockRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void getById_should_callRepository() {
        var mockPassenger = Helpers.createMockPassenger();

        Mockito.when(mockRepository.findById(mockPassenger.getId()))
                .thenReturn(Optional.of(mockPassenger));

        var result = service.getById(mockPassenger.getId());

        Assertions.assertEquals(mockPassenger.getFirstName(), result.getFirstName());
    }

    @Test
    public void save_should_callRepository() {
        var mockPassenger = Helpers.createMockPassenger();
        mockRepository.save(mockPassenger);

        Mockito.verify(mockRepository, Mockito.times(1))
                .save(mockPassenger);
    }

    @Test
    public void update_should_callRepository() {
        var mockPassenger = Helpers.createMockPassenger();
        mockRepository.save(mockPassenger);
        mockPassenger.setPassportNumber("new pass");
        mockRepository.save(mockPassenger);

        Mockito.verify(mockRepository, Mockito.times(2))
                .save(mockPassenger);
    }

    @Test
    public void delete_should_callRepository() {
        var mockPassenger = Helpers.createMockPassenger();
        mockRepository.save(mockPassenger);
        mockRepository.deleteById(mockPassenger.getId());

        Mockito.verify(mockRepository, Mockito.times(1))
                .save(mockPassenger);
    }
}