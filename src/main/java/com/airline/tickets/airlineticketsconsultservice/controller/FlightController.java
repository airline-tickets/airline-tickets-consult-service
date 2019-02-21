package com.airline.tickets.airlineticketsconsultservice.controller;

import com.airline.tickets.airlineticketsconsultservice.model.db.Flight;
import com.airline.tickets.airlineticketsconsultservice.model.dto.FlightDTO;
import com.airline.tickets.airlineticketsconsultservice.model.filter.FlightFilter;
import com.airline.tickets.airlineticketsconsultservice.service.FlightService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService service;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "View a list of flight", response = List.class)
    public ResponseEntity<List<Flight>> listFlight(@RequestBody FlightFilter filter) {
        return ResponseEntity.ok(service.findAllByFilter(filter));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "View a flight", response = Flight.class)
    public ResponseEntity<Flight> getFlight(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getFlight(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Flight> updateFlight(@PathVariable Integer id,@RequestBody FlightDTO flight) {
        return ResponseEntity.ok(service.updateFlight(id, flight));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(value = "Create a new flight", response = Flight.class)
    public ResponseEntity<Flight> createFlight(@RequestBody FlightDTO dto) {
        return ResponseEntity.ok(service.createFlight(dto));
    }

    @RequestMapping(value = "/batch", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Create flights in batch")
    public ResponseEntity<?> createFlights(@RequestBody List<FlightDTO> dtos) {
        return ResponseEntity.ok(service.createFlights(dtos));
    }

}
