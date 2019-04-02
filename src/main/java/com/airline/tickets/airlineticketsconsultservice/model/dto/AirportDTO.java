package com.airline.tickets.airlineticketsconsultservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportDTO {

    private String initial;
    private String name;
    private String city;
    private String uf;
}
