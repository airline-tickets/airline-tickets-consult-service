package com.airline.tickets.airlineticketsconsultservice.factory;

import com.airline.tickets.airlineticketsconsultservice.repository.AirportRepository;
import com.airline.tickets.airlineticketsconsultservice.repository.FlightRepository;
import com.airline.tickets.airlineticketsconsultservice.service.AirportService;
import com.airline.tickets.airlineticketsconsultservice.service.FlightService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DependencyFactory {

	private AirportRepository airportRepository;
	private FlightRepository flightRepository;

	@Bean
	public AirportService getAirportService() {
		return new AirportService(airportRepository);
	}

	@Bean
	public FlightService getFlightService() {
		return new FlightService(flightRepository);
	}
}
