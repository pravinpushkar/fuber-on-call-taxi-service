package com.fuber.fuberoncalltaxiservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {
	private double x;
	private double y;
	
	public double distance(Location loc) {
		return Math.sqrt(Math.pow(loc.x-this.x, 2) + Math.pow(loc.y-this.y, 2));
	}
}
