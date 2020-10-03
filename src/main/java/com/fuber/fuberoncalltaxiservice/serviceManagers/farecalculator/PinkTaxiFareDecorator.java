package com.fuber.fuberoncalltaxiservice.serviceManagers.farecalculator;

import com.fuber.fuberoncalltaxiservice.models.Trip;

public class PinkTaxiFareDecorator extends FareDecorator{
	FareCalculator fareCalculator;
	private static final double cost = 5;
	
	public PinkTaxiFareDecorator(FareCalculator fareCalculator) {
		this.fareCalculator = fareCalculator;
	}

	@Override
	public double calculate(Trip trip) {
		return fareCalculator.calculate(trip) + cost;
	}
	
	
}
