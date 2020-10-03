package com.fuber.fuberoncalltaxiservice.serviceManagers.farecalculator;

import com.fuber.fuberoncalltaxiservice.models.Trip;

public abstract class FareDecorator {
	public abstract double calculate(Trip trip);
}
