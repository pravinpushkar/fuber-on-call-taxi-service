package com.fuber.fuberoncalltaxiservice.models.taxi;

import com.fuber.fuberoncalltaxiservice.enums.TAXI_TYPE;
import com.fuber.fuberoncalltaxiservice.models.Location;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Taxi {
	private String id;
	private TAXI_TYPE type;
	@Setter boolean isFree;
	@Setter Location location;
	
	public Taxi(String id, TAXI_TYPE type) {
		this.id = id;
		isFree = true;
		this.type = type;
	}
}
