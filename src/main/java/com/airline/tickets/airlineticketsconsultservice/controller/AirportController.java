package com.airline.tickets.airlineticketsconsultservice.controller;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import com.airline.tickets.airlineticketsconsultservice.service.AirportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

	private final AirportService airportService;

	public AirportController(AirportService airportService) {
		this.airportService = airportService;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get an airport", response = Airport.class)
	public ResponseEntity<Airport> getAirport(@PathVariable Integer id) {
		return ResponseEntity.ok(airportService.findAirportById(id));
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get an airport", response = Airport.class)
	public ResponseEntity<List<Airport>> findAirportByTerm(@RequestParam(value = "term") String term) {
		return ResponseEntity.ok(airportService.findAirportByTerm(term));
	}
}
