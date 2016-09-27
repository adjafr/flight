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
	/*
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
	    */

	    // flight node with null child nodes
	@RequestMapping(value="/allavailable", method=RequestMethod.POST)
	   public List<Map<String, List<Flight>>> getAllAvailableFlightForOToD(@RequestBody Flight flight) {
        List<Map<String, List<Flight>>> flights = new ArrayList<>();
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


        //flights.addAll(getFlights(flightNode, flight.getOrigin().toUpperCase(), flight.getDestination().toUpperCase()));
        getFlightsFromNode(flightNode, flight.getOrigin().toUpperCase(), flight.getDestination().toUpperCase(), flights);

        List<Map<String, List<Flight>>> filteredMap = new ArrayList<>();
        for (Map<String, List<Flight>> map : flights) {
            if (map.keySet().size() > 1) {
                filteredMap.add(getPossibleFlights(map, flight.getOrigin().toUpperCase(), flight.getDestination().toUpperCase()));
            } else {
                filteredMap.add(map);
            }
        }
        return filteredMap;
    }

    public Map<String, List<Flight>> getPossibleFlights(Map<String, List<Flight>> flightMap, String origin, String destination) {
        String firstConnection = getFlightConnectionLocation(flightMap, origin, destination);
        String nexConnection = getFlightConnectionLocation(flightMap, firstConnection, destination);
        while (firstConnection != null && !firstConnection.equalsIgnoreCase(getFlightLastConnectionLocation(flightMap, origin, destination))) {
            List<Flight> flights = new ArrayList<>();
            List<Flight> connectionFoundFlights = new ArrayList<>();
            for (Flight nextFlight : flightMap.get(nexConnection)) {
                for (Flight previousFlight : flightMap.get(firstConnection)) {
                    if (nextFlight.getDepartureTime() > (previousFlight.getArrivalTime() + 1)) {
                    	connectionFoundFlights.add(previousFlight);
                        flights.add(nextFlight);
                        break;
                    }
                }
            }
            flightMap.get(firstConnection).clear();
            flightMap.get(firstConnection).addAll(connectionFoundFlights);
            flightMap.get(nexConnection).clear();
            flightMap.get(nexConnection).addAll(flights);
            firstConnection = getFlightConnectionLocation(flightMap, firstConnection, destination);
            nexConnection = getFlightConnectionLocation(flightMap, firstConnection, destination);
        }
        if (getFlightConnectionLocation(flightMap, origin, destination).equalsIgnoreCase(destination)) {
            List<Flight> flights = new ArrayList<>();
            List<Flight> connectionFoundFlights = new ArrayList<>();
            for (Flight nextFlight : flightMap.get(destination)) {
                for (Flight previousFlight : flightMap.get(firstConnection)) {
                    if (nextFlight.getDepartureTime() > (previousFlight.getArrivalTime() + 1)) {
                    	connectionFoundFlights.add(previousFlight);
                        flights.add(nextFlight);
                        break;
                    }
                }
            }
            flightMap.get(firstConnection).clear();
            flightMap.get(firstConnection).addAll(connectionFoundFlights);
            flightMap.get(destination).clear();
            flightMap.get(destination).addAll(flights);
        }
        return flightMap;
    }

    public String getFlightConnectionLocation(Map<String, List<Flight>> flightMap, String origin, String destination) {
        String firstConnection = null;
        for (Map.Entry<String, List<Flight>> entry : flightMap.entrySet()) {
            for (Flight flight : entry.getValue()) {
                if (flight.getOrigin().equalsIgnoreCase(origin)) {
                    firstConnection = entry.getKey();
                    break;
                }
            }
            if (firstConnection != null) {
                break;
            }
        }
        return firstConnection;
    }

    public String getFlightLastConnectionLocation(Map<String, List<Flight>> flightMap, String origin, String destination) {
        String firstConnection = null;
        for (Map.Entry<String, List<Flight>> entry : flightMap.entrySet()) {
            for (Flight flight : entry.getValue()) {
                if (flight.getDestination().equalsIgnoreCase(destination)) {
                    firstConnection = flight.getOrigin();
                    break;
                }
            }
            if (firstConnection != null) {
                break;
            }
        }
        return firstConnection;
    }

	    // flight node with null child nodes
	    public List<Map<String, List<Flight>>> getFlightsFromNode(FlightNode flightNode, String origin, String destination, List<Map<String, List<Flight>>> flightsList) {
	        Map<String, List<Flight>> flights = new HashMap<>();

	        if (flightNode.getDestinationFlightMap().get(destination) != null && !flightNode.getDestinationFlightMap().get(destination).isEmpty()) {
	            if (flightNode.getFlightToNodeMap() != null && !flightNode.getFlightToNodeMap().isEmpty()) {
	                    flights.putAll(flightNode.getFlightToNodeMap());
	            }
	            flights.put(destination.toUpperCase(), flightNode.getDestinationFlightMap().get(destination));
	            flightsList.add(flights);
	        }

	        for (FlightNode node : flightNode.getChildNodes()) {
	            getFlightsFromNode(node, origin, destination, flightsList);
	        }
	        return flightsList;
	    }

	    /*
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
	    */

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
