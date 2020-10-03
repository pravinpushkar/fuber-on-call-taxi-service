package com.fuber.fuberoncalltaxiservice.serviceManagers.farecalculator;

import com.fuber.fuberoncalltaxiservice.models.Location;
import com.fuber.fuberoncalltaxiservice.models.Trip;

public class DistanceBasedFareCalculator implements FareCalculator{
	private static final double ratePerKM = 2;
	@Override
	public double calculate(Trip trip) {
		// TODO Auto-generated method stub
		Location src = trip.getSource();
		double dist = src.distance(trip.getDestination());
		return dist*ratePerKM;
	}
}
