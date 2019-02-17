package com.airline.tickets.airlineticketsconsultservice.service;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import com.airline.tickets.airlineticketsconsultservice.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository repository;

    public List<Airport> createAirportsInBatch(List<Airport> airports) {
        return repository.saveAll(airports);
    }
}
