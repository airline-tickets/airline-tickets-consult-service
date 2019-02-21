package com.airline.tickets.airlineticketsconsultservice.service;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import com.airline.tickets.airlineticketsconsultservice.model.dto.AirportDTO;
import com.airline.tickets.airlineticketsconsultservice.repository.AirportRepository;
import com.airline.tickets.airlineticketsconsultservice.repository.specification.AirportSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    @Autowired
    private AirportRepository repository;

    public List<Airport> createAirportsInBatch(List<AirportDTO> airports) {
        List<Airport> entities = airports.stream()
                .map(AirportDTO::getEntity)
                .collect(Collectors.toList());
        return repository.saveAll(entities);
    }

    public Airport findAirportById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Airport not found")
        );
    }

    public List<Airport> findAirportByTerm(String term) {
        return repository.findAll(AirportSpecification.getTerm(term));
    }
}
