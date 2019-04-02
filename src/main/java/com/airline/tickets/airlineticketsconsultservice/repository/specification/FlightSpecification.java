package com.airline.tickets.airlineticketsconsultservice.repository.specification;

import com.airline.tickets.airlineticketsconsultservice.model.db.Flight;
import com.airline.tickets.airlineticketsconsultservice.model.filter.FlightFilter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class FlightSpecification {

	public static Specification<Flight> getFilter(FlightFilter filter) {
		return Specification.where(
				equalArrival(filter).and(
						equalDepart(filter).and(
								equalFromWhere(filter).and(
										equalToWhere(filter)))));
	}

	private static Specification<Flight> equalFromWhere(FlightFilter filter) {

		return (root, query, cb) -> {
			if (Objects.isNull(filter.getFrom())) {
				return null;
			}
			return cb.equal(root.get("fromWhere"), filter.getFrom());
		};
	}

	private static Specification<Flight> equalToWhere(FlightFilter filter) {
		return (root, query, cb) -> {
			if (Objects.isNull(filter.getTo())) {
				return null;
			}
			return cb.equal(root.get("toWhere"), filter.getTo());
		};
	}

	private static Specification<Flight> equalArrival(FlightFilter filter) {
		return (root, query, cb) -> {
			if (Objects.isNull(filter.getArrival())) {
				return null;
			}
			return cb.equal(root.get("arrival"), filter.getArrival());
		};
	}

	private static Specification<Flight> equalDepart(FlightFilter filter) {
		return (root, query, cb) -> {
			if (Objects.isNull(filter.getDepart())) {
				return null;
			}
			return cb.equal(root.get("depart"), filter.getDepart());
		};
	}
}
