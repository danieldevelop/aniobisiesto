package org.aniobisiesto.calendario;

public class Juliano {

	public boolean esJuliano(int anio) {
		return ((anio % 4) == 0) ? true : false;
	}
}
