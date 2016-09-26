package com.cooksys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.pojo.Flight;
import com.cooksys.service.FlightService;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("flights")
@CrossOrigin
public class FlightsController {
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	FlightService flightService;
	
	@RequestMapping
	public ArrayList<Flight> getFlightList()
	{
		return flightService.getDailyFlightList();
	}
	
	@RequestMapping(value="/allavailable", method=RequestMethod.POST)
	   public List<List<Flight>> getAllAvailableFlightForOToD(@RequestBody Flight flight) {
	        List<List<Flight>> flights = new ArrayList<>();
	        List<Flight> availableFlightsList = getFlightList();
	        Map<String, List<Flight>> originCityFlightMap = new HashMap<>();
	        for (Flight flight1 : availableFlightsList) {
	            if (originCityFlightMap.get(flight1.getOrigin().toUpperCase()) == null) {
	                List<Flight> flightList = new ArrayList<>();
	                flightList.add(flight1);
	                originCityFlightMap.put(flight1.getOrigin().toUpperCase(), flightList);
	            } else {
	                originCityFlightMap.get(flight1.getOrigin().toUpperCase()).add(flight1);
	            }
	        }
	        FlightNode flightNode = createFlightTree(originCityFlightMap, flight.getOrigin().toUpperCase(), flight.getDestination().toUpperCase(), null);


	        flights.addAll(getFlights(flightNode, flight.getOrigin().toUpperCase(), flight.getDestination().toUpperCase()));

	        //getFlightsFromNode(flightNode, flight.getOrigin().toUpperCase(), flight.getDestination().toUpperCase());
	        return flights;
	    }

	    // flight node with null child nodes
	    public List<List<Flight>> getFlightsFromNode(FlightNode flightNode, String origin, String destination) {
	        List<List<Flight>> listOfFlights = new ArrayList<>();
	        if (flightNode.getDestinationFlightMap().get(destination) != null) {
	            if (!flightNode.getDestinationFlightMap().get(destination).isEmpty()) {
	                List<Flight> flights = new ArrayList<>();
	                flights.addAll(flightNode.getDestinationFlightMap().get(destination));
	                listOfFlights.add(flights);
	            }
	        }
	        while (!flightNode.getChildNodes().isEmpty()) {
	            for (FlightNode childNode : flightNode.getChildNodes()) {
	                getFlightsFromNode(childNode, origin, destination);
	            }
	        }
	        return listOfFlights;
	    }

	    public List<List<Flight>> getFlights(FlightNode flightNode, String origin, String destination) {
	        List<List<Flight>> flights = new ArrayList<>();
	        if (flightNode.getDestinationFlightMap() != null)
	            if (flightNode.getDestinationFlightMap().keySet().contains(destination)) {
	                if (flightNode.getDestinationFlightMap().get(destination) != null)
	                    for (Flight flight : flightNode.getDestinationFlightMap().get(destination)) {
	                        List<Flight> directFlight = new ArrayList<>();
	                        directFlight.add(flight);
	                        flights.add(directFlight);
	                    }
	            }
	        return flights;
	    }

	    public FlightNode createFlightTree(Map<String, List<Flight>> flightMapByOrigin, String origin, String destination, FlightNode parentNode) {
	        FlightNode flightNode = new FlightNode();
	        flightNode.setOriginCityName(origin);
	        List<Flight> flights = flightMapByOrigin.get(origin.toUpperCase());
	        if (parentNode != null) {
	            flightNode.setParentNode(parentNode);
	        }
	        while (parentNode != null) {
	            if (parentNode.getDestinationFlightMap().get(origin.toUpperCase()) != null) {
	                flightNode.getFlightToNodeMap().put(origin.toUpperCase(), parentNode.getDestinationFlightMap().get(origin.toUpperCase()));
	            }
	            origin = parentNode.getOriginCityName().toUpperCase();
	            parentNode = parentNode.getParentNode();
	        }
	        origin = flightNode.getOriginCityName();
	        parentNode = flightNode.getParentNode();
	        if (flights != null) {
	            for (Flight flight1 : flights) {
	                boolean remove = false;
	                while (parentNode != null) {
	                    if (flight1.getDestination().equalsIgnoreCase(parentNode.getOriginCityName()) || flight1.getDestination().equalsIgnoreCase(origin)) {
	                        remove = true;
	                        break;
	                    }
	                    parentNode = parentNode.getParentNode();
	                }
	                if (!remove) {
	                    if (flightNode.getDestinationFlightMap().get(flight1.getDestination().toUpperCase()) == null) {
	                        List<Flight> list = new ArrayList<>();
	                        list.add(flight1);
	                        flightNode.getDestinationFlightMap().put(flight1.getDestination().toUpperCase(), list);
	                    } else {
	                        flightNode.getDestinationFlightMap().get(flight1.getDestination().toUpperCase()).add(flight1);
	                    }
	                }
	                parentNode = flightNode.getParentNode();
	            }
	        }
	        flightNode.getDestinationFlightMap().keySet().stream().filter(key -> !key.equalsIgnoreCase(destination)).forEach(key -> flightNode.getChildNodes().add(createFlightTree(flightMapByOrigin, key, destination, flightNode)));
	        return flightNode;
	    }

	}
