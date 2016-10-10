package com.cooksys.entity;

import java.util.Comparator;

public class FlightNodeComparator implements Comparator<FlightNode> {

	@Override
	public int compare(FlightNode o1, FlightNode o2) {
		
		return ((Integer)o1.getTripDuration()).compareTo(((Integer)o2.getTripDuration()));
	}

}
