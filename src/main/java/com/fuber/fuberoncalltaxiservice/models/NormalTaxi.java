package com.fuber.fuberoncalltaxiservice.models;

import com.fuber.fuberoncalltaxiservice.enums.TAXI_TYPE;

import lombok.Getter;

public class NormalTaxi extends Taxi {
	
	@Getter private TAXI_TYPE type;
	public NormalTaxi(String id) {
		super(id);
		this.type = TAXI_TYPE.NORMAL;
	}

}
