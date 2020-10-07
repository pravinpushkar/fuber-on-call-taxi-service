package com.fuber.fuberoncalltaxiservice.serviceManagers;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.fuber.fuberoncalltaxiservice.exceptions.TaxiAlreadyCreated;
import com.fuber.fuberoncalltaxiservice.exceptions.TaxisNotAvailable;
import com.fuber.fuberoncalltaxiservice.models.Location;
import com.fuber.fuberoncalltaxiservice.models.taxi.Taxi;

import lombok.NonNull;

@Component
public class TaxiManager {
	ConcurrentHashMap<String, Taxi> taxiStore = new ConcurrentHashMap<String, Taxi>();
	public int registerTaxi(@NonNull Taxi taxi) throws TaxiAlreadyCreated {
		if(taxiStore.containsKey(taxi.getId())) {
			throw new TaxiAlreadyCreated("Gievn Taxi id is already created");
		}
		
		taxiStore.put(taxi.getId(), taxi);
		return taxiStore.size();
	}
	
	public void updateTaxiLocation(String taxiId, Location loc) throws TaxisNotAvailable {
		if(!taxiStore.containsKey(taxiId)) {
			throw new TaxisNotAvailable("Provided taxiId is not available");
		}
		Taxi taxi = taxiStore.get(taxiId);
		taxi.setLocation(loc);
	}
	
	public Taxi getNearByTaxis(Location src) {
		Taxi availableAtMinDist = null;
		double dist = -1;
		for(Taxi taxi: taxiStore.values()) {
			if(taxi.isFree()) {
				double distTemp = src.distance(taxi.getLocation());
				if(availableAtMinDist==null) {
					availableAtMinDist = taxi;
				}
				else {
					availableAtMinDist = distTemp < dist?taxi:availableAtMinDist;
				}
			}
		}
		return availableAtMinDist;
	}
}
