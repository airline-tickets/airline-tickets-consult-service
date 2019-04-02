package com.airline.tickets.airlineticketsconsultservice.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightFilter {

	private LocalDate depart;
	private LocalDate arrival;
	private String from;
	private String to;
}
