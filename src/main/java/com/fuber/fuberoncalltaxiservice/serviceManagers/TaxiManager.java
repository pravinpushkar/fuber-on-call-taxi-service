package com.fuber.fuberoncalltaxiservice.serviceManagers;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.fuber.fuberoncalltaxiservice.exceptions.TaxiAlreadyCreated;
import com.fuber.fuberoncalltaxiservice.models.Taxi;

import lombok.NonNull;

@Component
public class TaxiManager {
	HashMap<String, Taxi> taxiStore = new HashMap<String, Taxi>();
	
	public int registerTaxi(@NonNull Taxi taxi) throws TaxiAlreadyCreated {
		if(taxiStore.containsKey(taxi.getId())) {
			throw new TaxiAlreadyCreated("Gievn Taxi id is already created");
		}
		
		taxiStore.put(taxi.getId(), taxi);
		return taxiStore.size();
	}
}
