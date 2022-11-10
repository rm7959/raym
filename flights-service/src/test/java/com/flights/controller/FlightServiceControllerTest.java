package com.flights.controller;

import static com.flights.util.TestUtil.MAPPER;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.flights.models.Flight;
import com.flights.repositories.FlightRepository;
import com.flights.util.TestUtil;

@WebMvcTest(FlightServiceController.class)
class FlightServiceControllerTest {

	private static final String FLIGHTS_QF_JSON = TestUtil.getJsonString("src/test/resources/data/QFFlights.json");
	private static final String FLIGHT_JSON = TestUtil.getJsonString("src/test/resources/data/Flight.json");

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FlightRepository repository;

	private static Map<String, List<Flight>> flightsMap;

	@BeforeAll
	static void setup() throws JsonMappingException, JsonProcessingException {
		flightsMap = MAPPER.readValue(FLIGHTS_QF_JSON, new TypeReference<Map<String, List<Flight>>>() {
		});
	}

	@Test
	void testGetFlights() throws JsonProcessingException, Exception {
		when(repository.findByAirlineCode(Mockito.anyString())).thenReturn(flightsMap.get("flights"));
		this.mockMvc.perform(get("/v1/flights").param("airlineCode", "QF").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(FLIGHTS_QF_JSON, true));
	}

	@Test
	void testAddFlight() throws Exception {
		Flight flight =  MAPPER.readValue(FLIGHT_JSON, Flight.class);
		when(repository.save(Mockito.any(Flight.class))).thenReturn(flight);
		this.mockMvc.perform(post("/v1/flights").content(MAPPER.writeValueAsString(flight)).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isCreated()).andExpect(content().json(FLIGHT_JSON, true));
	}

}
