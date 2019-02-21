package com.airline.tickets.airlineticketsconsultservice.controller;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import com.airline.tickets.airlineticketsconsultservice.model.dto.AirportDTO;
import com.airline.tickets.airlineticketsconsultservice.service.AirportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService service;

    @RequestMapping(value = "/batch", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(value = "Insert airports", response = List.class)
    public ResponseEntity<List<Airport>> createAirports(@RequestBody List<AirportDTO> airports) {
        return ResponseEntity.ok(service.createAirportsInBatch(airports));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get an airport", response = Airport.class)
    public ResponseEntity<Airport> getAirport(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findAirportById(id));
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get an airport", response = Airport.class)
    public ResponseEntity<List<Airport>> findAirportByTerm(@RequestParam(value = "term") String term) {
        return ResponseEntity.ok(service.findAirportByTerm(term));
    }
}
