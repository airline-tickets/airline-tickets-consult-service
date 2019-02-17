package com.airline.tickets.airlineticketsconsultservice.model.dto;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportDTO implements BaseDTO<Airport> {

    private String initial;
    private String name;
    private String city;
    private String uf;
    private String country;

    @Override
    public Airport getEntity() {
        return Airport.builder()
                .city(this.getCity())
                .country(this.getCountry())
                .initial(this.getInitial())
                .name(this.getName())
                .uf(this.getUf())
                .build();
    }
}
