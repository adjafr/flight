package com.cooksys.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.component.FlightGenerator;
import com.cooksys.entity.Flight;
import com.cooksys.entity.FlightNode;
import com.cooksys.entity.FlightNodeComparator;
import com.cooksys.entity.Itinerary;
import com.cooksys.entity.User;
import com.cooksys.repository.FlightRepository;
import com.cooksys.repository.ItineraryRepository;
import com.cooksys.repository.UserRepository;
import com.cooksys.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{
	   @Autowired
	    FlightGenerator generator;// = new FlightGenerator();

	    @Autowired
	    FlightRepository flightRepository;

	    @Autowired
	    UserRepository userRepository;

	    @Autowired
	    ItineraryRepository itineraryRepository;

	    private List<Flight> flightList = new ArrayList<>();

	    public List<Flight> getDailyFlightList() {
	        //refreshFlights();
	        return flightList;
	    }

	    //The fixedDelay parameter determines how often a new day is generated as expressed in milliseconds, 5000 = 5 seconds
	    @Scheduled(fixedDelay = 6000)
	    private void refreshFlights() {
	        flightList = generator.generateNewFlightList();
	    }
	    
	    // Post Itinerary
	    @Override
	    public Itinerary createItinerary(List<Flight> flightSet, Integer userId) {
	    	int layOver = 0;
	    	int flightDuration = 0;
	    	for(int i = flightSet.size() - 1; i >=0; i--) {
	    		if( i > 0) {
	    			layOver += flightSet.get(i).getDepartureTime() - flightSet.get(i - 1).getArrivalTime();
	    			flightDuration += flightSet.get(i).getFlightTime();
	    		} else {
	    			flightDuration += flightSet.get(i).getFlightTime();
	    		}
	    	}
	    
	        Itinerary itinerary = new Itinerary();
	        itinerary.setLayOver(layOver);
	        itinerary.setTotalTripTime(layOver + flightDuration); 
	        itinerary.setUser(userRepository.findOne(userId));
	        itinerary = itineraryRepository.save(itinerary);

	        List<Flight> savedFlight = new ArrayList<>();
	        
	        
	        
	        
	        for (Flight flight : flightSet) {
	            flight.setItinerary(itinerary);
	            savedFlight.add(flightRepository.save(flight));
	        }
	        itinerary.setSavedFlight(savedFlight);
	        return itinerary;
	    }

	    // Get Itineraries
	    @Override
	    public List<Itinerary> findAllItinerary(Integer userId) {
	        User user = userRepository.findOne(userId);
	        return itineraryRepository.findByUser(user);
	    }

	    
	    // Search Available Flights by Origin & Destination
	    @Override
	    public List<List<Flight>> getAllAvailableFlightsFromOriginToDestination(Flight flight) {

	    	List<List<Flight>> flightSet = new ArrayList<>();
	        List<FlightNode> flights = new ArrayList<>();
	        List<Flight> availableFlightsList = getDailyFlightList();
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
	        getListOfFlight(flight.getOrigin().toUpperCase(), flight.getDestination().toUpperCase(), flights, originCityFlightMap, null);
	        
	        for(FlightNode node : flights) {
	        	int tripDuration = node.getFlight().getFlightTime();
	        	FlightNode parentNode = node.getParentNode();
	        	Flight currentFlight = node.getFlight();
	        	while(parentNode != null) {
	        		int layover = currentFlight.getDepartureTime() - parentNode.getFlight().getArrivalTime();
	        		tripDuration += layover + parentNode.getFlight().getFlightTime();
	        		currentFlight = parentNode.getFlight();
	        		parentNode = parentNode.getParentNode();
	        	}
	        	node.setTripDuration(tripDuration);
	        }
	        
	        Collections.sort(flights, new FlightNodeComparator());
	        for(FlightNode node: flights) {
	        	flightSet.add(getFlightsFromNode(node));
	        }
	        return flightSet;
	    }
	    
	    
	    
	    public List<Flight> getFlightsFromNode(FlightNode node) {
	    	List<Flight> flights = new ArrayList<>();
	    	flights.add(node.getFlight());
	    	FlightNode parentNode = node.getParentNode();
	    	while (parentNode != null) {
	    		flights.add(parentNode.getFlight());
	    		parentNode = parentNode.getParentNode();
	    	}
	    	
	    	List<Flight> sortedFlight = new ArrayList<>();
	    	for(int i = flights.size() - 1; i >= 0; i--) {
	    		sortedFlight.add(flights.get(i));
	    	}
	    	return sortedFlight;
	    }



	    private List<FlightNode> getListOfFlight(String origin, String destination, List<FlightNode> flightNodes, Map<String, List<Flight>> flightMap, FlightNode parentNode) {
	        List<Flight> flightsFromOrigin = flightMap.get(origin.toUpperCase());
	        if (flightsFromOrigin != null) {
	            for (Flight flight : flightsFromOrigin) {
	                if (flight.getDestination().equalsIgnoreCase(destination)) {
	                    if (parentNode != null) {
	                        if (!isGoingBackToPreviousOrigin(parentNode, flight)) {
	                            Flight parentFlight = parentNode.getFlight();
	                            long pfAtWithOff = parentFlight.getArrivalTime() + 1;
	                            if (flight.getDepartureTime() >= pfAtWithOff) {
	                                FlightNode currNode = new FlightNode();
	                                currNode.setFlight(flight);
	                                currNode.setParentNode(parentNode);
	                                flightNodes.add(currNode);
	                            }
	                        }
	                    } else {
	                        FlightNode currNode = new FlightNode();
	                        currNode.setFlight(flight);
	                        flightNodes.add(currNode);
	                    }
	                } else {
	                    if (parentNode != null) {
	                        if (!isGoingBackToPreviousOrigin(parentNode, flight)) {
	                            Flight parentFlight = parentNode.getFlight();
	                            long pfAtWithOff = parentFlight.getArrivalTime() + 1;
	                            if (flight.getDepartureTime() >= pfAtWithOff) {
	                                List<Flight> flightsFromCurrentlyReachedCity = flightMap.get(flight.getDestination().toUpperCase());
	                                if (flightsFromCurrentlyReachedCity != null && !flightsFromCurrentlyReachedCity.isEmpty()) {
	                                    FlightNode currNode = new FlightNode();
	                                    currNode.setFlight(flight);
	                                    currNode.setParentNode(parentNode);
	                                    getListOfFlight(flight.getDestination().toUpperCase(), destination, flightNodes, flightMap, currNode);
	                                }
	                            }
	                        }
	                    } else {
	                        FlightNode currNode = new FlightNode();
	                        currNode.setFlight(flight);
	                        getListOfFlight(flight.getDestination(), destination, flightNodes, flightMap, currNode);
	                    }
	                }
	            }
	        }
	        return flightNodes;
	    }

	    private boolean isGoingBackToPreviousOrigin(FlightNode parentNode, Flight flight) {
	        boolean isGoingBackToPreviousOrigin = false;
	        while (parentNode != null) {
	            Flight parentFlight = parentNode.getFlight();
	            if (flight.getDestination().equalsIgnoreCase(parentFlight.getOrigin())) {
	                isGoingBackToPreviousOrigin = true;
	                break;
	            }
	            parentNode = parentNode.getParentNode();
	        }
	        return isGoingBackToPreviousOrigin;
	    }

}
