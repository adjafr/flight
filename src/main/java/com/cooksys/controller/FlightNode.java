package com.cooksys.controller;

import com.cooksys.pojo.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FlightNode {

    private String originCityName;

    private FlightNode parentNode;

    private List<FlightNode> childNodes = new ArrayList<>();

    private Map<String, List<Flight>> destinationFlightMap = new HashMap<>();

    private Map<String, List<Flight>> flightToNodeMap = new HashMap<>();

    public String getOriginCityName() {
        return originCityName;
    }

    public void setOriginCityName(String originCityName) {
        this.originCityName = originCityName;
    }

    public FlightNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(FlightNode parentNode) {
        this.parentNode = parentNode;
    }

    public List<FlightNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<FlightNode> childNodes) {
        this.childNodes = childNodes;
    }

    public Map<String, List<Flight>> getDestinationFlightMap() {
        return destinationFlightMap;
    }

    public void setDestinationFlightMap(Map<String, List<Flight>> destinationFlightMap) {
        this.destinationFlightMap = destinationFlightMap;
    }

    public Map<String, List<Flight>> getFlightToNodeMap() {
        return flightToNodeMap;
    }

    public void setFlightToNodeMap(Map<String, List<Flight>> flightToNodeMap) {
        this.flightToNodeMap = flightToNodeMap;
    }
}
