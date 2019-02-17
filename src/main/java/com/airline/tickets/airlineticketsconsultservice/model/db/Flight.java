package com.airline.tickets.airlineticketsconsultservice.model.db;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@Entity(name = "tb_flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String numberFligtht;
    @ManyToOne
    private Airport toWhere;
    @ManyToOne
    private Airport fromWhere;
    @Column
    private LocalDate depart;
    @Column
    private LocalDate arrival;
    @Column
    private Integer capacity;
    @Column
    private LocalTime duration;
    @Column
    private BigDecimal price;

}



