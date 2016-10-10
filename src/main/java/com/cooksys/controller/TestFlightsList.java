/*package com.cooksys.controller;

import java.util.List;

import com.cooksys.pojo.Flight;

public class TestFlightsList {

    public static void main(String[] args) {
        FlightsController flightsController = new FlightsController();
        Flight flight = new Flight("Chattanooga", "Memphis", 2, 3, 11, 13);
        for(List<Flight> flightList: flightsController.getAllAvailableFlightForOToD(flight)) {
            for(Flight flight1: flightList) {
                System.out.print(flight1.getOrigin() + "-->" + flight1.getDestination());
            }
            System.out.println();
        }
    }
}*/
