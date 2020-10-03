package com.fuber.fuberoncalltaxiservice.models;

import lombok.Getter;
import lombok.Setter;

public abstract class Taxi {
	@Getter private String id;
	
	@Setter boolean isFree;
	@Setter Location location;
	
	public Taxi(String id) {
		this.id = id;
		isFree = true;
	}
}
