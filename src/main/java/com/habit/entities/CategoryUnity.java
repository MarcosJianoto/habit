package com.habit.entities;

public enum CategoryUnity {

	LT("LITROS"), KG("QUILOGRAMA"), MT("METROS"), CM("CENTIMETROS"), KM("KILOMETROS"), HR("HORAS"), MM("MINUTOS");

	String value;

	CategoryUnity(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
