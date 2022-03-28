package com.airport.management.system.airportmanagementsystem.repositories;

import com.airport.management.system.airportmanagementsystem.models.Flight;
import com.airport.management.system.airportmanagementsystem.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    @Query(value = "select * from airport_management_system.passenger where ticket_number = :ticketNumber", nativeQuery = true)
    Passenger getByTicketNumber(@Param("ticketNumber") String ticketNumber);

    @Query(value = "select * from airport_management_system.passenger where passport_number = :passportNumber", nativeQuery = true)
    Passenger getByPassportNumber(@Param("passportNumber") String ticketNumber);

}
