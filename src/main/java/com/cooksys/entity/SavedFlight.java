package com.cooksys.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SavedFlight

{
	
	@Id
	@SequenceGenerator(name="savedflight_id_seq", sequenceName="savedflight_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="savedflight_id_seq")
	@Column
	private Integer id;
	
	//Name of city where flight originates
		@Column
		private String origin;
		
		//Name of city where flight lands
		@Column
		private String destination;
		
		//How many hours flight is in the air
		@Column
		private long flightTime;
		
		//How many hours after the start of the day until the flight takes off
		@Column(name = "off")
		private long offset;
		
		//The time the flight departs
		@Column
		private String departureTime;
		
		//The time the flight departs
		@Column
		private String arrivalTime;
		
		@JsonIgnore
		@ManyToOne(optional = false)
		private Itinerary itinerary;

		public SavedFlight()
		{
			super();
			// TODO Auto-generated constructor stub
		}

		public SavedFlight(Integer id, String origin, String destination, long flightTime, long offset,
				String departureTime, String arrivalTime)
		{
			super();
			this.id = id;
			this.origin = origin;
			this.destination = destination;
			this.flightTime = flightTime;
			this.offset = offset;
			this.departureTime = departureTime;
			this.arrivalTime = arrivalTime;
		}

		public Integer getId()
		{
			return id;
		}

		public void setId(Integer id)
		{
			this.id = id;
		}

		public String getOrigin()
		{
			return origin;
		}

		public void setOrigin(String origin)
		{
			this.origin = origin;
		}

		public String getDestination()
		{
			return destination;
		}

		public void setDestination(String destination)
		{
			this.destination = destination;
		}

		public long getFlightTime()
		{
			return flightTime;
		}

		public void setFlightTime(long flightTime)
		{
			this.flightTime = flightTime;
		}

		public long getOffset()
		{
			return offset;
		}

		public void setOffset(long offset)
		{
			this.offset = offset;
		}

		public String getDepartureTime()
		{
			return departureTime;
		}

		public void setDepartureTime(String departureTime)
		{
			this.departureTime = departureTime;
		}

		public String getArrivalTime()
		{
			return arrivalTime;
		}

		public void setArrivalTime(String arrivalTime)
		{
			this.arrivalTime = arrivalTime;
		}
		
		
		
		
		
		

}
