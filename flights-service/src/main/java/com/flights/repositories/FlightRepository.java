package com.flights.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.flights.models.Flight;

@RepositoryRestResource
public interface FlightRepository extends CrudRepository<Flight, Long> {

	List<Flight> findAll();

	@Query("SELECT f from Flight f WHERE f.flightNumber LIKE CONCAT(:airlineCode, '%')")
	List<Flight> findByAirlineCode(@Param("airlineCode") String airlineCode);
}
