package com.airline.tickets.airlineticketsconsultservice.repository.specification;

import com.airline.tickets.airlineticketsconsultservice.model.db.Airport;
import com.airline.tickets.airlineticketsconsultservice.model.db.Flight;
import com.airline.tickets.airlineticketsconsultservice.model.filter.FlightFilter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class AirportSpecification {

    public static Specification<Airport> getTerm(String term) {
        return Specification.where(
                likeInitialTerm(term).or(
                        likeNameTerm(term).or(
                                likeCityTerm(term))));
    }

    private static Specification<Airport> likeInitialTerm(String term) {
        return (root, query, cb) ->
                cb.equal(root.get("initial"), term);
    }

    private static Specification<Airport> likeNameTerm(String term) {
        return (root, query, cb) ->
                cb.like(root.get("name"), term);
    }

    private static Specification<Airport> likeCityTerm(String term) {
        return ((root, query, cb) ->
                cb.like(root.get("city"), term));
    }


}
