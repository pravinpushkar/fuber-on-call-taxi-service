package com.fuber.fuberoncalltaxiservice.serviceManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fuber.fuberoncalltaxiservice.exceptions.InvalidTaxiType;
import com.fuber.fuberoncalltaxiservice.models.Trip;
import com.fuber.fuberoncalltaxiservice.serviceManagers.farecalculator.FareCalculator;
import com.fuber.fuberoncalltaxiservice.serviceManagers.farecalculator.FareDecorator;
import com.fuber.fuberoncalltaxiservice.serviceManagers.farecalculator.Farefactory;

@Component
public class FareCalculatorManager {
	FareCalculator fareCalculatorStaregy;
	
	@Autowired
	Farefactory farefactory;
	public void setFareCalculationStrategy(FareCalculator fareCalculatorStaregy) {
		this.fareCalculatorStaregy = fareCalculatorStaregy;
	}
	
	public double calculateFare(Trip trip) throws InvalidTaxiType {
		FareDecorator fareDecorator = farefactory.getFareDecoratorInstance(this.fareCalculatorStaregy, trip);
		
		return fareDecorator.calculate(trip);
	}
}
