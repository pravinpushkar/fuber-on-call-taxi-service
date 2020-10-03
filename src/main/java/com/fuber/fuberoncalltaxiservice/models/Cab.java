package com.fuber.fuberoncalltaxiservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Cab {
	private String id;
	
	@Setter boolean isFree;
	@Setter Location location;
	
	public Cab(String id) {
		this.id = id;
		isFree = true;
	}
}
