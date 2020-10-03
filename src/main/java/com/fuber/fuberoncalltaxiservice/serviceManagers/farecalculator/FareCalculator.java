package com.fuber.fuberoncalltaxiservice.serviceManagers.farecalculator;

import com.fuber.fuberoncalltaxiservice.models.Trip;

public interface FareCalculator {
	public double calculate(Trip trip);
}
