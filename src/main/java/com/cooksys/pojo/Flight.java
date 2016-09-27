package com.cooksys.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Flight {
	
	//Name of city where flight originates
	private String origin;
	
	//Name of city where flight lands
	private String destination;
	
	//How many hours flight is in the air
	private long flightTime;
	
	//How many hours after the start of the day until the flight takes off
	private long offset;
	
	//Get departure time
	private long departureTime;
	
	//Get arrival time
	private long arrivalTime;
	
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
	public long getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(long flightTime) {
		this.flightTime = flightTime;
	}
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	}
	
	
	
	public long getDepartureTime()
	{
		return departureTime;
	}
	public void setDepartureTime(long departureTime)
	{
		this.departureTime = departureTime;
	}
	public long getArrivalTime()
	{
		return arrivalTime;
	}
	public void setArrivalTime(long arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}
	
	
//	public long getLayoverTime()
//	{
//		return layoverTime;
//	}
//	public void setLayoverTime(long arrivalTime)
//	{
//		this.layoverTime = layoverTime;
//	}
	
	
	public Flight(String origin, String destination, long flightTime, long offset, long departureTime, long arrivalTime) {  //, long layoverTime
		super();
		this.origin = origin;
		this.destination = destination;
		this.flightTime = flightTime;
		this.offset = offset;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	
	public Flight() {
		
	}
	
	

}
