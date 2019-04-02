package com.airline.tickets.airlineticketsconsultservice.service;

import com.airline.tickets.airlineticketsconsultservice.model.db.Flight;
import com.airline.tickets.airlineticketsconsultservice.model.dto.FlightDTO;
import com.airline.tickets.airlineticketsconsultservice.model.filter.FlightFilter;
import com.airline.tickets.airlineticketsconsultservice.repository.FlightRepository;
import com.airline.tickets.airlineticketsconsultservice.repository.specification.FlightSpecification;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

	private FlightRepository flightRepository;

	public FlightService(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	public List<Flight> findAllByFilter(FlightFilter filter) {
		return flightRepository.findAll(FlightSpecification.getFilter(filter));
	}

	public Flight getFlight(Integer id) {
		return flightRepository.findById(id)
				.orElseThrow(
						() -> new RuntimeException("Entity flight not found")
				);
	}

	public Flight updateFlight(Integer id, FlightDTO dto) {
		Integer idValid = flightRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Entity not found")
		).getId();
		Flight entity = Flight.builder().build();
		BeanUtils.copyProperties(entity, dto);
		entity.setId(idValid);
		return flightRepository.save(entity);
	}
}
