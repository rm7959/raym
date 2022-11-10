package com.flights.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Flight {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
    private long id;
	
    @Column(nullable = false)
    private String flightNumber;
    
    @Column(nullable = false)
    private String departurePort;
    
    @Column(nullable = false)
    private String arrivalPort;
    
    @Column(nullable = false)
    private LocalDateTime departureTime;
    
    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Autowired
	public Flight() {}
	
    @Autowired
	public Flight(String flightNumber, String departurePort, String arrivalPort, LocalDateTime departureTime,
			LocalDateTime arrivalTime) {
    	super();
		this.flightNumber = flightNumber;
		this.departurePort = departurePort;
		this.arrivalPort = arrivalPort;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}

	public String getArrivalPort() {
		return arrivalPort;
	}

	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
