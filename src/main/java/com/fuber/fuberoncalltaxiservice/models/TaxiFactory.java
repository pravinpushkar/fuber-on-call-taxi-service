package com.fuber.fuberoncalltaxiservice.models;

import org.springframework.stereotype.Component;

import com.fuber.fuberoncalltaxiservice.enums.TAXI_TYPE;
import com.fuber.fuberoncalltaxiservice.exceptions.InvalidTaxiType;

import lombok.NonNull;

@Component
public class TaxiFactory {
	public Taxi getTaxiInstance(@NonNull String taxiId, @NonNull TAXI_TYPE type) throws InvalidTaxiType {
		if(type == TAXI_TYPE.NORMAL) {
			return new NormalTaxi(taxiId);
		}
		else if(type == TAXI_TYPE.PINK) {
			return new PinkTaxi(taxiId);
		}
		else {
			throw new InvalidTaxiType("Provided taxi type is not valid!!");
		}
	}
}
