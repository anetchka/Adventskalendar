package adventsmodell;
/**Dateiname: Adventkalendar.java
 * @author Anna Kovtun
 * s0552342@htw-berlin.de
 * @since 30.12.2016
 * letzte �nderung:  12.12.2016
 * @version Eclipse neon 1
 * Beschreibung: eine Klasse, die die M�glichkeit gibt, 
 * die Frage, die m�glichen Antworten und richtige ANtwort zu bekommen.
 */
public class Raetsel {
	// Attributen der Klasse Raetsel
	private String frage = "";
	private String [] antworten = null;
	private int richtigeAntwort;
	
	/**
	 * Konstruktor Raetsel 
	 * ----------------
	 * @param String frage, String [] antworten, char richtigeAntwort
	 * -----------------
	 */
	
	public Raetsel (String frage, String [] antworten, char richtigeAntwort)
	{
		this.frage = frage;
		this.antworten = antworten;
		this.richtigeAntwort = richtigeAntwort; 
	}
	
	/**
	 * Anfang der Methode frageBekommen
	 * ----------------
	 * @return frage (Typ String)
	 * -----------------
	 * Methode damit man die Fragen bekommen k�nnte
	 * ---------------
	 */
	public String frageBekommen()
	{
		return frage;
	}
	
	/**
	 * Anfang der Methode antwortenBekommen
	 * ----------------
	 * @return antowren (String [])
	 * -----------------
	 * Methode damit man die Antowrt bekommen k�nnte
	 * ---------------
	 */
	public String [] antwortenBekommen()
	{
		return antworten;
	}
	
	/**
	 * Anfang der Methode antwort�berpr�fen
	 * ----------------
	 * @param m�glicheAntwort(Typ char)
	 * ------------------
	 * @return true oder false
	 * -----------------
	 * Methode damit man die Antwort mit der rictigen Antwort vergleichen k�nnte
	 * ---------------
	 */
	public boolean antwort�berpr�fen(char m�glicheAntwort)
	{
		return m�glicheAntwort==richtigeAntwort;
	}
	
	/**
	 * Anfang der Methode richtigeAntwortBekommen
	 * -----------------
	 * @return rictigeAntwort(Typ int)
	 * ----------------------------
	 * Methode um die richtige Antwort zu bekommen
	 * ---------------
	 */
	public int richtigeAntwortBekommen() {
		return richtigeAntwort;
	}
}
