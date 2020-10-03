package com.fuber.fuberoncalltaxiservice.models.taxi;

import com.fuber.fuberoncalltaxiservice.enums.TAXI_TYPE;

import lombok.Getter;

public class PinkTaxi extends Taxi {
	
	public PinkTaxi(String id,TAXI_TYPE type) {
		super(id,type);
	}
}
