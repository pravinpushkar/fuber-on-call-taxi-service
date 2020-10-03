package com.fuber.fuberoncalltaxiservice.models;

import lombok.Getter;
import lombok.NonNull;

enum TRIP_STATUS {
	IN_PROGRESS,
	FINISHED
}

@Getter
public class Trip {
	private Customer customer;
	private Taxi taxi;
	private double totalfare;
	private Location source;
	private Location destination;
	private TRIP_STATUS status;
	
	public Trip(
			@NonNull Customer customer,
			@NonNull Taxi cab,
			@NonNull double totalfare,
			@NonNull Location source,
			@NonNull Location destination) {
		
		this.taxi = cab;
		this.customer = customer;
		this.totalfare = totalfare;
		this.source = source;
		this.destination = destination;
		this.status = TRIP_STATUS.IN_PROGRESS;
	}
	
	public void finishTrip() {
		this.status = TRIP_STATUS.FINISHED;
	}
}
