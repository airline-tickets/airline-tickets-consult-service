package com.airline.tickets.airlineticketsconsultservice.model.dto;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import com.airline.tickets.airlineticketsconsultservice.model.db.Flight;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class FlightDTO implements BaseDTO<Flight> {

    private String numberFligtht;
    private Airport toWhere;
    private Airport fromWhere;
    private LocalDate depart;
    private LocalDate arrival;
    private Integer capacity;
    private LocalTime duration;
    private BigDecimal price;

    @Override
    public Flight getEntity() {
        return Flight.builder()
                .arrival(this.getArrival())
                .capacity(this.getCapacity())
                .depart(this.getDepart())
                .duration(this.getDuration())
                .fromWhere(this.getFromWhere())
                .numberFligtht(this.getNumberFligtht())
                .price(this.getPrice())
                .toWhere(this.getToWhere())
                .build();
    }
}
