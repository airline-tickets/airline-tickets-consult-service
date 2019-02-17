package com.airline.tickets.airlineticketsconsultservice.service;

import com.airline.tickets.airlineticketsconsultservice.model.db.Flight;
import com.airline.tickets.airlineticketsconsultservice.model.dto.FlightDTO;
import com.airline.tickets.airlineticketsconsultservice.model.filter.FlightFilter;
import com.airline.tickets.airlineticketsconsultservice.repository.FlightRepository;
import com.airline.tickets.airlineticketsconsultservice.repository.specification.FlightSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public Flight createFlight(FlightDTO flight) {
        return repository.save(flight.getEntity());
    }

    public List<Flight> findAllByFilter(FlightFilter filter) {
        return repository.findAll(FlightSpecification.getFilter(filter));
    }

    public Flight getFlight(Integer id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Entity flight not found")
                );
    }

    public List<Flight> createFlights(List<FlightDTO> flights) {
        List<Flight> entities = flights.stream().map(FlightDTO::getEntity).collect(Collectors.toList());
        return repository.saveAll(entities);
    }

    public Flight updateFlight(Integer id, FlightDTO dto) {
        Integer idValid = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Entity not found")
        ).getId();
        Flight entity = dto.getEntity();
        entity.setId(idValid);
        return repository.save(entity);
    }

}
