package com.fuber.fuberoncalltaxiservice.models;

import com.fuber.fuberoncalltaxiservice.enus.CAB_TYPE;

import lombok.Getter;

@Getter
public class NormalCab extends Cab {
	
	private CAB_TYPE type;
	public NormalCab(String id) {
		super(id);
		this.type = CAB_TYPE.NORMAL;
	}

}
