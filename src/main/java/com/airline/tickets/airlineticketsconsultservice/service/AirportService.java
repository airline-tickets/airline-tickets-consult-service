package com.airline.tickets.airlineticketsconsultservice.service;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import com.airline.tickets.airlineticketsconsultservice.repository.AirportRepository;
import com.airline.tickets.airlineticketsconsultservice.repository.specification.AirportSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport findAirportById(Integer id) {
        return airportRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Airport not found")
        );
    }

    public List<Airport> findAirportByTerm(String term) {
        return airportRepository.findAll(AirportSpecification.getTerm(term));
    }
}
