package com.fuber.fuberoncalltaxiservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuber.fuberoncalltaxiservice.enums.TAXI_TYPE;
import com.fuber.fuberoncalltaxiservice.models.TaxiFactory;
import com.fuber.fuberoncalltaxiservice.serviceManagers.TaxiManager;

@RestController
public class TaxiBookingcontroller {
	@Autowired
	TaxiManager taxiManager;
	
	@Autowired
	TaxiFactory taxiFactory;
	
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
}
