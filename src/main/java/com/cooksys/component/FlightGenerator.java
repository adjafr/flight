package com.cooksys.component;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.cooksys.entity.Cities;
import com.cooksys.entity.Flight;

@Component
public class FlightGenerator {

	public ArrayList<Flight> generateNewFlightList() {

		ArrayList<Flight> result = new ArrayList<>();

		for (int i = 0; i < 50; i++) {

			int originIndex = ThreadLocalRandom.current().nextInt(0, 4);

			int destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			while (destinationIndex == originIndex)
				destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			String origin = Cities.values()[originIndex].getName();
			String destination = Cities.values()[destinationIndex].getName();
			int flightTime = ThreadLocalRandom.current().nextInt(1, 4);
//			int offset = ThreadLocalRandom.current().nextInt(0, 10);
			int offsetter = ThreadLocalRandom.current().nextInt(0, 10);

			int departureTime = offsetter + 8;
			int arrivalTime = offsetter + 8 + flightTime;

			Flight f = new Flight();
			f.setOrigin(origin);
			f.setDestination(destination);
			f.setFlightTime(flightTime);
//			f.setOffset(offset);
			f.setOffsetter(offsetter);
			f.setDepartureTime(departureTime);
			f.setArrivalTime(arrivalTime);
			result.add(f);
			result.add(f);
		}
		return result;
	}

}
