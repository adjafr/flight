package com.cooksys.entity;

import javax.persistence.*;

@Entity
public class SavedFlight

{
	
	@Id
	@GeneratedValue
	private Integer id;
	
	//Name of city where flight originates
		private String origin;
		
		//Name of city where flight lands
		private String destination;
		
		//How many hours flight is in the air
		private long flightTime;
		
		//How many hours after the start of the day until the flight takes off
		private long offset;
		
		
		
		public Integer getId()
		{
			return id;
		}
		public void setId(Integer id)
		{
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
		public SavedFlight(String origin, String destination, long flightTime, long offset) {
			super();
			this.origin = origin;
			this.destination = destination;
			this.flightTime = flightTime;
			this.offset = offset;
		}
		public SavedFlight()
		{
			super();
			// TODO Auto-generated constructor stub
		}
		
		

}
