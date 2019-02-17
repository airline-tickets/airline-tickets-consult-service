package com.airline.tickets.airlineticketsconsultservice.controller;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import com.airline.tickets.airlineticketsconsultservice.service.AirportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService service;

    @RequestMapping(value = "/batch", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(value = "Insert airports", response = List.class)
    public ResponseEntity<List<Airport>> createAirports(List<Airport> airports) {
        return ResponseEntity.ok(service.createAirportsInBatch(airports));
    }
}
