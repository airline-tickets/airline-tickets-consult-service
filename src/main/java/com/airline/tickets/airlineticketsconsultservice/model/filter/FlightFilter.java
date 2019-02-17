package com.airline.tickets.airlineticketsconsultservice.model.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FlightFilter {

    private LocalDate depart;
    private LocalDate arrival;
    private String from;
    private String to;
}
