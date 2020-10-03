package com.fuber.fuberoncalltaxiservice.exceptions;

public class NoTaxiAvailableAtTheMoment extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoTaxiAvailableAtTheMoment(String message) {
		super(message);
	}
}
