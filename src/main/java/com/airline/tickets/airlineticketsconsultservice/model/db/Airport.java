package com.airline.tickets.airlineticketsconsultservice.model.db;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity(name = "tb_airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String initial;
    @Column
    private String name;
    @Column
    private String city;
    @Column
    private String uf;
    @Column
    private String country;
}
