package com.cooksys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table
public class Flight implements Serializable {

    /**
	 * 
	 */
	@Id
    @Column
    @SequenceGenerator(name = "flight_id_seq", sequenceName = "flight_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "flight_id_seq")
    private Long id;

    @Column
    private String origin;

    @Column
    private String destination;

    @Column
    private int flightTime;

//    @Column
//    private int offset;
    
    @Column
    private int offsetter;

    @Column
    private int departureTime;

    @Column
    private int arrivalTime;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itinerary_id", nullable = false)
    private Itinerary itinerary;
    
    @Column
    private int layOver;
    
    @Column
    private int totalTripTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

//	public int getOffset() {
//		return offset;
//	}
//
//	public void setOffset(int offset) {
//		this.offset = offset;
//	}
	
	
	public int getOffsetter() {
		return offsetter;
	}

	public void setOffsetter(int offsetter) {
		this.offsetter = offsetter;
	}
	
	

	public int getDepartureTime() {
		return departureTime;
	}



	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	public int getLayOver() {
		return layOver;
	}

	public void setLayOver(int layOver) {
		this.layOver = layOver;
	}

	public int getTotalTripTime() {
		return totalTripTime;
	}

	public void setTotalTripTime(int totalTripTime) {
		this.totalTripTime = totalTripTime;
	}
	
	

	
}
