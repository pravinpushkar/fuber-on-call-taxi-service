package com.fuber.fuberoncalltaxiservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuber.fuberoncalltaxiservice.enums.TAXI_TYPE;
import com.fuber.fuberoncalltaxiservice.models.Customer;
import com.fuber.fuberoncalltaxiservice.models.Location;
import com.fuber.fuberoncalltaxiservice.models.Trip;
import com.fuber.fuberoncalltaxiservice.models.taxi.TaxiFactory;
import com.fuber.fuberoncalltaxiservice.serviceManagers.TaxiManager;
import com.fuber.fuberoncalltaxiservice.serviceManagers.TripManager;

@RestController
public class TaxiBookingcontroller {
	@Autowired
	TaxiManager taxiManager;
	
	@Autowired
	TaxiFactory taxiFactory;
	
	@Autowired
	TripManager tripManager;
	
	@PostMapping("/register/taxi/taxiId/{taxiId}/taxitype/{taxiType}")
	public ResponseEntity<String> registerTaxi(@PathVariable String taxiId, @PathVariable TAXI_TYPE taxiType) {
		try {
			int size = taxiManager.registerTaxi(taxiFactory.getTaxiInstance(taxiId, taxiType));
			String res = "Current fleet size " +size; 
			return ResponseEntity.ok(res);
		} catch(Exception e) {
			return (ResponseEntity<String>) ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@PostMapping("/register/taxi/taxiId/{taxiId}")
	public ResponseEntity<String> registerTaxi(@PathVariable String taxiId) {
		try {
			int size = taxiManager.registerTaxi(taxiFactory.getTaxiInstance(taxiId, TAXI_TYPE.NORMAL));
			String res = "Current fleet size " +size; 
			return ResponseEntity.ok(res);
		} catch(Exception e) {
			return (ResponseEntity<String>) ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/update/taxilocation/taxiId/{taxiId}/xcord/{x1}/ycord/{y1}")
	public ResponseEntity<String> registerTaxi(@PathVariable String taxiId, @PathVariable double x1, @PathVariable double y1) {
		try {
			Location loc = new Location(x1,y1);
			taxiManager.updateTaxiLocation(taxiId, loc);
			return ResponseEntity.ok("Taxi location updated");
		} catch(Exception e) {
			return (ResponseEntity<String>) ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@PostMapping("/book/trip/x1/{x1}/y1/{y1}/x2/{x2}/y2/{y2}")
	public ResponseEntity<String> bookTrip(@PathVariable double x1,
			@PathVariable double y1,
			@PathVariable double x2,
			@PathVariable double y2) {
		try {
			
			Location src = new Location(x1, y1);
			Location dest = new Location(x2, y2);
			Trip trip = tripManager.book(src, dest);
			
			String res = trip.getTaxi().getId() + "::: BOOKED";
			return ResponseEntity.ok(res);
		} catch(Exception e) {
			return (ResponseEntity<String>) ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@PostMapping("/update/trip/endtrip/taxiId/{taxiId}")
	public ResponseEntity<String> finishTrip(@PathVariable String taxiId) {
		try {
			double fare = tripManager.finishTripAndShowFare(taxiId);
			String totalfare = "Totalfare:  " + fare;
			return ResponseEntity.ok(totalfare);
		} catch(Exception e) {
			return (ResponseEntity<String>) ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
