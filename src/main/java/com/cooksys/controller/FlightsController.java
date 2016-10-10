package com.cooksys.controller;

import com.cooksys.entity.Flight;
import com.cooksys.entity.Itinerary;
import com.cooksys.service.FlightService;
import com.cooksys.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("flights")
@CrossOrigin
public class FlightsController {

    @Autowired
    LocationService locationService;

    @Autowired
    FlightService flightService;// = new FlightService();

    @RequestMapping
    public List<Flight> getFlightList() {
        return flightService.getDailyFlightList();
    }

    @RequestMapping(value = "/allavailable", method = RequestMethod.POST)
    public List<List<Flight>> getAllAvailableFlightForOToDNew(@RequestBody Flight flight) {
        return flightService.getAllAvailableFlightsFromOriginToDestination(flight);
    }

    @RequestMapping(value = "/create/{userId}/itinerary", method = RequestMethod.POST)
    public Itinerary createItinerary(@PathVariable("userId") Integer userId, @RequestBody List<Flight> flightSet) {
        return flightService.createItinerary(flightSet, userId);
    }

    @RequestMapping(value = "/findall/{userId}/itinerary", method = RequestMethod.GET)
    public List<Itinerary> findAllItinerary(@PathVariable("userId") Integer userId) {
        return flightService.findAllItinerary(userId);
    }

}
