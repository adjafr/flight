package com.cooksys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.Flight;
import com.cooksys.entity.Itinerary;
import com.cooksys.entity.User;
import com.cooksys.entity.response.UserResponse;
import com.cooksys.entity.response.ValidateResponse;
import com.cooksys.repository.FlightRepository;
import com.cooksys.service.FlightService;
import com.cooksys.service.UserService;

@RestController
@CrossOrigin
// (origins = "http://localhost:8000") // @CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	FlightsController flightsController;

	FlightService flightService;

	FlightRepository savedFlightRepo;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(value = "/{username}/validate", method = RequestMethod.GET)
	public ValidateResponse readValidate(@PathVariable String username) {
		return this.userService.readValidate(username);
	}

	@RequestMapping(value = { "currentAvailableFlights" }, method = RequestMethod.GET)
	public List<Flight> getCurrentFlights() {
		return userService.getAllFlights();
	}

//	@RequestMapping(value = "/{id}/itinerary", method = RequestMethod.GET)
//	public List<Itinerary> getItineraries(@PathVariable Integer id) {
//		return userService.getAllItineraries(id);
//	}

	@RequestMapping(value = "/{username}/itinerary", method = RequestMethod.POST)
    public Itinerary createItinerary(@PathVariable String username, @RequestBody Itinerary itinerary) {
        return this.userService.createItinerary(username, itinerary);
    }

	@RequestMapping(method = RequestMethod.POST)
	public UserResponse create(@RequestBody User user) {
		return this.userService.create(user);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<UserResponse> index() {
		return this.userService.index();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public UserResponse read(@PathVariable String username) {
		return this.userService.read(username);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public UserResponse update(@PathVariable Integer id,
			@RequestBody User userToUpdate) {
		return this.userService.updateUser(id, userToUpdate);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public UserResponse delete(@PathVariable User user) {
		return this.userService.delete(user);
	}

	   @RequestMapping(value = {"allavailableflights"}, method = RequestMethod.POST)
	    public List<List<Flight>> getAllAvailableFlightForOToD(@RequestBody Flight flight) {
	        List<List<Flight>> flights = new ArrayList<>();
	        List<Flight> availableFlights = getFlightFromOtoDes(flight.getOrigin(), flight.getDestination(), savedFlightRepo.findAll());
	        if (!availableFlights.isEmpty()) {
	            flights.add(availableFlights);
	        }
	        return flights;
	    }

	    private List<Flight> getFlightFromOtoDes(String origin, String destination, List<Flight> flights) {
	        List<Flight> newFlights = new ArrayList<>();
	        for (Flight availableFlight : flights) {
	            if (origin.equalsIgnoreCase(availableFlight.getOrigin())) {
	                if (destination.equalsIgnoreCase(availableFlight.getDestination())) {
	                    newFlights.add(availableFlight);
	                } else {
	                    getFlightFromOtoDes(availableFlight.getDestination(), destination, flights);
	                }
	            }
	        }
	        return newFlights;
	    }

}
