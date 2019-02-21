package com.airline.tickets.airlineticketsconsultservice.model.db;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
