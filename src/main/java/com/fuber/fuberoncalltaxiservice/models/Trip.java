package com.fuber.fuberoncalltaxiservice.models;

import java.util.Date;

import com.fuber.fuberoncalltaxiservice.models.taxi.Taxi;

import lombok.Getter;
import lombok.NonNull;

enum TRIP_STATUS {
	IN_PROGRESS,
	FINISHED
}

@Getter
public class Trip {
	private Taxi taxi;
	private double totalfare;
	private Location source;
	private Location destination;
	private TRIP_STATUS status;
	private long start_time;
	private long end_time;
	
	public Trip(
			@NonNull Taxi taxi,
			@NonNull Location source,
			@NonNull Location destination) {
		
		this.taxi = taxi;
		this.source = source;
		this.destination = destination;
		this.status = TRIP_STATUS.IN_PROGRESS;
		this.start_time = new Date().getTime();
	}
	
	public void finishTrip() {
		this.status = TRIP_STATUS.FINISHED;
		this.end_time = new Date().getTime();
		this.taxi.setFree(true);
	}
}
