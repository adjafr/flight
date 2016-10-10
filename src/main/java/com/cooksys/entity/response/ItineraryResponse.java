package com.cooksys.entity.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cooksys.entity.Flight;
import com.cooksys.entity.Itinerary;

public class ItineraryResponse
{
	
	private Integer id;
	
	private List<Flight> savedFlight;
	
	public ItineraryResponse(Itinerary intinerary)
	{
		super();
		this.id = intinerary.getId();
		this.savedFlight = intinerary.getSavedFlight();
	}
	
	public static ItineraryResponse response(Itinerary itinerary)	
	{
		return new ItineraryResponse(itinerary);
	}
	
	public static List<ItineraryResponse> list(List<Itinerary> list) 
	{
		ArrayList<ItineraryResponse> result = new ArrayList<>();
		for (Itinerary intinerary : list)
			result.add(new ItineraryResponse(intinerary));
		return result;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public List<Flight> getSavedFlight() {
		return savedFlight;
	}

	public void setSavedFlight(List<Flight> savedFlight) {
		this.savedFlight = savedFlight;
	}

	
	

}
