package com.flights.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flights.models.Flight;
import com.flights.repositories.FlightRepository;

@RestController
@RequestMapping("/v1") // For no HATEOAS
public class FlightServiceController {

	@Autowired
	private FlightRepository repository;

	@GetMapping(value = "/flights", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<Flight>> getFlights(@Param("airlineCode") String airlineCode) {
		List<Flight> flightList = new ArrayList<>();
		if (StringUtils.hasText(airlineCode)) {
			flightList = repository.findByAirlineCode(airlineCode);
		} else {
			flightList = repository.findAll();
		}
		Map<String, List<Flight>> flights = new HashMap<>();
		flights.put("flights", flightList);
		return flights;
	}

	@PostMapping(value = "/flights", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flight addFlight(@RequestBody Flight flight) {
		return repository.save(flight);
	}
}
