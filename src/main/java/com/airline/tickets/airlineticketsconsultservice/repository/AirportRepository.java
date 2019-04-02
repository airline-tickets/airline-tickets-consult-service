package com.airline.tickets.airlineticketsconsultservice.repository;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AirportRepository extends JpaRepository<Airport, Integer>, JpaSpecificationExecutor<Airport> {

}
