package com.airline.tickets.airlineticketsconsultservice.controller;

import com.airline.tickets.airlineticketsconsultservice.model.db.Flight;
import com.airline.tickets.airlineticketsconsultservice.model.dto.FlightDTO;
import com.airline.tickets.airlineticketsconsultservice.model.filter.FlightFilter;
import com.airline.tickets.airlineticketsconsultservice.service.FlightService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Filter;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "View a list of flight", response = List.class)
    public ResponseEntity<List<Flight>> listFlight(
            @RequestParam(value = "depart", required = false)LocalDate depart,
            @RequestParam(value = "arrival", required = false)LocalDate arrival,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to){
        FlightFilter filter = FlightFilter.builder().build();
        return ResponseEntity.ok(flightService.findAllByFilter(filter));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "View a flight", response = Flight.class)
    public ResponseEntity<Flight> getFlight(@PathVariable Integer id) {
        return ResponseEntity.ok(flightService.getFlight(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Flight> updateFlight(@PathVariable Integer id,@RequestBody FlightDTO flight) {
        return ResponseEntity.ok(flightService.updateFlight(id, flight));
    }

}
