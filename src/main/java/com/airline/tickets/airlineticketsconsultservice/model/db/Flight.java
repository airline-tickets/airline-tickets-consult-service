package com.airline.tickets.airlineticketsconsultservice.model.db;

import com.airline.tickets.airlineticketsconsultservice.constant.TableConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TableConstants.FLIGHT)
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Airport toWhere;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Airport fromWhere;
    @Column
    private LocalDate depart;
    @Column
    private LocalDate arrival;
    @Column
    private Integer capacity;
    @Column
    private BigDecimal price;
    @Version
    private Integer version;

}



