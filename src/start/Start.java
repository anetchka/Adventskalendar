package start;

import adventsmodell.Adventskalender;

/**Dateiname: Start.java
 * @author Anna Kovtun
 * s0552342@htw-berlin.de
 * @since 06.12.2016
 * letzte �nderung: 05.01.2017
 * @version Eclipse neon 1
 * Beschreibung: Klasse mit main Methode 
 */

public class Start { // Anfang Klasse Start
	
	/**
	 * anfang main-Methode
	 * ----------------
	 * @param String [] args
	 * -----------------
	 * Methode zum Ausf�hren des Programmes
	 * ---------------
	 */
	public static void main(String[] args) {
		
		Adventskalender kalend = new Adventskalender();
		kalend.kalendarAusgabe();
		kalend.kalender�ffnen();
		
	}
} // Ende Klasse Start
