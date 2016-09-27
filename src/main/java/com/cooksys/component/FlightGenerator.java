package com.cooksys.component;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.cooksys.pojo.Cities;
import com.cooksys.pojo.Flight;

@Component
public class FlightGenerator {

	public ArrayList<Flight> generateNewFlightList() {
		
		ArrayList<Flight> result = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			int originIndex = ThreadLocalRandom.current().nextInt(0, 4);

			int destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			while (destinationIndex == originIndex)
				destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			String origin = Cities.values()[originIndex].getName();
			String destination = Cities.values()[destinationIndex].getName();
			int flightTime = ThreadLocalRandom.current().nextInt(1, 4);
			int offset = ThreadLocalRandom.current().nextInt(0, 10);
			
			int departureTime = offset + 8;
			int arrivalTime = offset + 8 + flightTime;
			
//			int layoverTime = 
			
			

			Flight f = new Flight(origin, destination, flightTime, offset, departureTime, arrivalTime);

			result.add(f);
		}
		return result;
	}

}
