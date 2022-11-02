package org.aniobisiesto.calendario;

public class Gregoriano {

	public boolean esGregoriano(int anio) {
		if ((anio % 4) == 0 && (anio % 100) != 0 || (anio % 400) == 0) {
			return true;
		}

		return false;
	}
}
