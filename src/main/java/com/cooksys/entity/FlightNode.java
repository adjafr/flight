package com.cooksys.entity;

import java.io.Serializable;

public class FlightNode implements Serializable {

    private FlightNode parentNode;

    private Flight flight;
        
    private int tripDuration;

    public FlightNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(FlightNode parentNode) {
        this.parentNode = parentNode;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
        
    }

	public int getTripDuration() {
		return tripDuration;
	}

	public void setTripDuration(int tripDuration) {
		this.tripDuration = tripDuration;
	}
    
    
}
