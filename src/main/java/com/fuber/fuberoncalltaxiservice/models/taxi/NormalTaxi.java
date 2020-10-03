package com.fuber.fuberoncalltaxiservice.models.taxi;

import com.fuber.fuberoncalltaxiservice.enums.TAXI_TYPE;

import lombok.Getter;

public class NormalTaxi extends Taxi {
	public NormalTaxi(String id, TAXI_TYPE type) {
		super(id,type);
	}

}
