package com.airline.tickets.airlineticketsconsultservice.model.dto;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    private Airport toWhere;
    private Airport fromWhere;
    private LocalDate depart;
    private LocalDate arrival;
    private Integer capacity;
    private LocalTime duration;
    private BigDecimal price;

}
