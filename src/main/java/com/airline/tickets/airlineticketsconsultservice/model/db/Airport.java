package com.airline.tickets.airlineticketsconsultservice.model.db;

import com.airline.tickets.airlineticketsconsultservice.constant.TableConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = TableConstants.AIRPORT)
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	@NotEmpty
	private String initial;
	@Column
	@NotEmpty
	private String name;
	@Column
	@NotEmpty
	private String city;
	@Column
	@NotEmpty
	private String uf;
	@Version
	private Integer version;
}
