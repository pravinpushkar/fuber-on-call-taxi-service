package com.fuber.fuberoncalltaxiservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {
	private double xcord;
	private double ycord;
	
	public double distance(Location loc) {
		return Math.sqrt(Math.pow(loc.xcord-this.xcord, 2) + Math.pow(loc.ycord-this.ycord, 2));
	}
}
