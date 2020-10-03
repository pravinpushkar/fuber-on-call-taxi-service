package com.fuber.fuberoncalltaxiservice.models;

import com.fuber.fuberoncalltaxiservice.CAB_TYPE;

import lombok.Getter;

@Getter
public class PinkCab extends Cab {
	private CAB_TYPE type;
	
	public PinkCab(String id) {
		super(id);
		this.type = CAB_TYPE.PINK;
	}
}
