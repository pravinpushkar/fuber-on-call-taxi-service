package com.fuber.fuberoncalltaxiservice.serviceManagers.farecalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fuber.fuberoncalltaxiservice.enums.TAXI_TYPE;
import com.fuber.fuberoncalltaxiservice.exceptions.InvalidTaxiType;
import com.fuber.fuberoncalltaxiservice.models.Trip;
import com.fuber.fuberoncalltaxiservice.models.taxi.NormalTaxi;
import com.fuber.fuberoncalltaxiservice.models.taxi.PinkTaxi;
import com.fuber.fuberoncalltaxiservice.models.taxi.Taxi;

import lombok.NonNull;

@Component
public class Farefactory {
	
	public FareDecorator getFareDecoratorInstance(FareCalculator fareCalculator,Trip trip) throws InvalidTaxiType {
		if(trip.getTaxi().getType() == TAXI_TYPE.NORMAL) {
			return new DefaultDecorator(fareCalculator);
		}
		else if(trip.getTaxi().getType() == TAXI_TYPE.PINK) {
			return new PinkTaxiFareDecorator(fareCalculator);
		}
		else {
			throw new InvalidTaxiType("Provided taxi type is not valid!!");
		}
	}
}
