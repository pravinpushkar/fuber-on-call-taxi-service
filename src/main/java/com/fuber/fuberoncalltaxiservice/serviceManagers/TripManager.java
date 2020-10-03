package com.fuber.fuberoncalltaxiservice.serviceManagers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fuber.fuberoncalltaxiservice.exceptions.InvalidTaxiType;
import com.fuber.fuberoncalltaxiservice.exceptions.NoTaxiAvailableAtTheMoment;
import com.fuber.fuberoncalltaxiservice.models.Customer;
import com.fuber.fuberoncalltaxiservice.models.Location;
import com.fuber.fuberoncalltaxiservice.models.Trip;
import com.fuber.fuberoncalltaxiservice.models.taxi.Taxi;
import com.fuber.fuberoncalltaxiservice.serviceManagers.farecalculator.DistanceBasedFareCalculator;

import lombok.NonNull;

@Component
public class TripManager {
	HashMap<String, Trip> tripStore = new HashMap<String, Trip>();
	
	@Autowired
	TaxiManager taxiManager;
	
	@Autowired
	FareCalculatorManager fareCalculatorManager;

	public Trip book(@NonNull Location src, @NonNull Location dest) throws NoTaxiAvailableAtTheMoment {
		Taxi taxi = taxiManager.getNearByTaxis(src);
		if(taxi==null) throw new NoTaxiAvailableAtTheMoment("Currently all taxis aaare busy!!");
		
		taxi.setFree(false);
		Trip trip = new Trip(taxi, src, dest);
		tripStore.put(taxi.getId(), trip);
		return trip;
	}
	
	public double finishTripAndShowFare(@NonNull String taxiId) throws NoTaxiAvailableAtTheMoment, InvalidTaxiType {
		Trip trip = tripStore.get(taxiId);
		trip.finishTrip();
		
		//set fare calculaton startegy
		fareCalculatorManager.setFareCalculationStrategy(new DistanceBasedFareCalculator());
		
		double fare = fareCalculatorManager.calculateFare(trip);
		return fare;
	}
}
