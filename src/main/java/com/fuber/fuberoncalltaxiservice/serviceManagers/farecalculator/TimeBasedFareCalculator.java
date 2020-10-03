package com.fuber.fuberoncalltaxiservice.serviceManagers.farecalculator;

import com.fuber.fuberoncalltaxiservice.models.Trip;

public class TimeBasedFareCalculator implements FareCalculator{
	private static final double ratePerMinute = 1;
	@Override
	public double calculate(Trip trip) {
		// TODO Auto-generated method stub
		return (trip.getEnd_time() - trip.getStart_time())*ratePerMinute;
	}

}
