package com.cooksys.service;

import com.cooksys.entity.Flight;
import com.cooksys.entity.Itinerary;

import java.util.ArrayList;
import java.util.List;

public interface FlightService {

    List<Flight> getDailyFlightList();

    public List<Itinerary> getAllAvailableFlightsFromOriginToDestination(Flight flight);

    Itinerary createItinerary(List<Flight> flightSet, Integer userId);

    List<Itinerary> findAllItinerary(Integer userId);

}
