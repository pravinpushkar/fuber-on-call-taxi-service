package com.fuber.fuberoncalltaxiservice.models;

import com.fuber.fuberoncalltaxiservice.enums.TAXI_TYPE;

import lombok.Getter;

public class PinkTaxi extends Taxi {
	@Getter private TAXI_TYPE type;
	
	public PinkTaxi(String id) {
		super(id);
		this.type = TAXI_TYPE.PINK;
	}
}
