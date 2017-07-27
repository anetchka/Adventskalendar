package adventsmodell;

/**Dateiname: Adventkalendar.java
 * @author Anna Kovtun
 * s0552342@htw-berlin.de
 * @since 30.11.2016
 * letzte Änderung:  05.01.2016
 * @version Eclipse neon 1
 * Beschreibung: eine Klasse, mit Kalender Ausgabe und die UserEingabe bearbeiten und entsprechend darauf reagiert
 */

import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Adventskalender { // Anfang der Klasse Adventskalendar
	/**
	 * Attributen der Klasse Adventskalender
	 */
	private final int MONAT = 1; // ausgehend, dass Januar dem Wert "1" entspricht ud Dezember - "12"
	private Raetsel[] raetseln = new Raetsel[24]; 
	private int tuerNummer = new GregorianCalendar().get(GregorianCalendar.DAY_OF_MONTH);

	/**
	 * Default Konstruktor mit leeren Parametern
	 */
	public Adventskalender() {

	}

	/**
	 * kalenderAusgabe 
	 * -------------------------
	 * Methode zur Ausgabe Adventskalendertabelle
	 * mit Nummern von 1 bis 24
	 */
	public void kalendarAusgabe() {
		System.out.println(" A D V E N T S K A L E N D E R ");
		System.out.println("+----+----+----+----+----+----+");
		for (int i = 1; i <= 24; i++) { // Zahl von 1 bis 24 
			System.out.printf("| %2d ", i);
			if (i % 6 == 0) // Zeilenabruch nach jeder 6.Zahl
			{
				System.out.println("|");
				System.out.println("+----+----+----+----+----+----+");
			}
		}
	}

	/**
	 * kalenderÖfnen
	 * ----------------- 
	 * Methode, die die Tür von Kalender öffnet 
	 * wenn bestimmte Vorraussetzungen erfüllt sind.
	 * Falls der User die Tür geöffnet bekommen hat, bekommt er eine Frage.
	 */
	public void kalenderÖffnen() {
		raetselnGenerieren(); // Aufruf Methode, um die Raetsel zu bekommen.
		Scanner scan = new Scanner(System.in);
		int userEingabe;
		GregorianCalendar calend = new GregorianCalendar();
		int monatNummer = calend.get(GregorianCalendar.MONTH); //"monatNummer" entspricht aktuellen Monat
		String heutigenMonat = monatNameBekommen(monatNummer + 1); // Aufruf Methode "montBekommen" um den Name vom Monat als String zu bekommen.
		String definierteMonat = monatNameBekommen(MONAT); // Den Name vom "MONAT" zu bekommen
		boolean exit = false;
		do {
			try { 
				System.out.print("\nWelches Türchen soll geöffnet werden (beenden mit 0)? ");
				userEingabe = scan.nextInt();
				scan.nextLine();
				// Hier wird geprüft, ob userEingabe im zulässigen Zeitraum 
				if (MONAT == (monatNummer + 1)) {
					if (userEingabe == 0) {
						System.out.println("Schönen Advent und Tschüss!");
						exit = true;
					} else if (userEingabe < 1 || userEingabe > 24) {
						System.out.println("Ungültiges Datum.Bitte geben Sie den Zahl " + "von 1 bis inkl.24 ein.");
						continue;
					} else if (userEingabe > tuerNummer) {
						System.out.println("Türchen läss sich noch nicht öffnen, " + "denn heute ist erst der "
								+ tuerNummer + ". " + heutigenMonat);
						continue;
					} else {
						System.out.println("Türchen wird geöffnet für  den " + userEingabe + ". " + heutigenMonat);
						frageAusgeben(userEingabe); // Aufruf Methode frageAusgeben
						antwortenVergleichen(userEingabe); // Aufruf Methode, um die Antworten zu vergleichen
					}
				} else {
					System.out.println("Oh, wir haben noch nicht den " + userEingabe + "." + definierteMonat);
					exit=true;
				}
			} catch (InputMismatchException e) { // Hier werden die Fälle gefangen, wenn der User nicht int eingegeben hat
				System.out.println("Bitte geben Sie den Zahl ein!");
				scan.nextLine();
			}
		} while (!exit);
	}
	
	/**
	 * raetselnGenerieren
	 * ----------------
	 * Methode, die 24 Raetseln in zufällige Orndnung generiert 
	 * 
	 */

	public void raetselnGenerieren() {
		raetseln[0] = new Raetsel("Welches Land heißt übersetzt 'Dorf'?",
				new String[] { "a) Mexico ", "b) Kanada ", "c) Iran? " }, 'b');
		raetseln[1] = new Raetsel("Was bedeutet das französische Sprichwort: 'Noblese oblige'?",
				new String[] { "a) Bete und Arbeite ", "b) Geld stinkt nicht ", "c) Adel verpflichtet? " }, 'c');
		raetseln[2] = new Raetsel("Welches der Elemente gehoert nicht zu den Edelgasen?",
				new String[] { "a) Barium ", "b) Helium ", "c) Xenon? " }, 'a');
		raetseln[3] = new Raetsel("Wann wurde das Drucken erfunden?", new String[] { "a) 1876 ", "b) 899 ", "c) 1455 " },
				'c');
		raetseln[4] = new Raetsel("Welches war der längste Dinosaurier?",
				new String[] { "a) Diplodocus ", "b) Supersaurus ", "c) Brachiosaurus? " }, 'b');
		raetseln[5] = new Raetsel("Wieviele Farben hat der Regenbogen?", new String[] { "a) 7 ", "b) 5 ", "c) 3? " }, 'a');
		raetseln[6] = new Raetsel("Welcher ist der Rote Planet?", new String[] { "a) Venus ", "b) Pluto ", "c) Mars? " },
				'c');
		raetseln[7] = new Raetsel("Wie viele Rillen hat eine Schallplatte?", new String[] { "a) 2 ", "b) 8 ", "c) 32?" },
				'a');
		raetseln[8] = new Raetsel("Der Weihnachtsmann hat kleine Helfer, wie heissen diese?",
				new String[] { "a) Neunen ", "b) Zehnen ", "c) Elfen?" }, 'c');
		raetseln[9] = new Raetsel("Wo wohnt der Weihnachtsmann im Sommer?",
				new String[] { "a) Am Nordpol ", "b) Auf Mallorca ", "c) Im Wald?" }, 'a');
		raetseln[10] = new Raetsel("Wie viele Rillen hat eine Schallplatte?", new String[] { "a) 2 ", "b) 8 ", "c) 32 ?" },
				'a');
		raetseln[11] = new Raetsel("Wann feiert man Weihnachten in der Ukraine?",
				new String[] { "a) 24.December ", "b) 6.Januart  ", "c) gar nicht?" }, 'b');
		raetseln[12] = new Raetsel("Wo befindet sich die Ukraine?",
				new String[] { "a) In Europa ", "b) in Afrika ", "c) in den USA" }, 'a');
		raetseln[13] = new Raetsel("Wie heißt die Haupstadt von der Ukraine?",
				new String[] { "a) Kiew ", "b) Donetsk ", "c) Odessa?" }, 'a');
		raetseln[14] = new Raetsel("Wann feiert man der Tag der Unabhängigkeit in der Ukraine?",
				new String[] { "a) 24.August", "b) 13.Dezember", "c) gar nicht?" }, 'a');
		raetseln[15] = new Raetsel("Wie viele Städte gibt es in der Ukraine?",
				new String[] { "a) 10 ", "b) 20 ", "c) 24" }, 'c');
		raetseln[16] = new Raetsel("Wie heißt der President von der Ukraine?",
				new String[] { "a) Klitschko", "b)Tymoschenko", "c)Poroschenko" }, 'c');
		raetseln[17] = new Raetsel("Was für eine Zahl ist das: 00001010? (Hinnweis - dies ist eine binäre Darstellung)",
				new String[] { "a) 1", "b) 1010", "c) 10" }, 'c');
		raetseln[18] = new Raetsel("Wie heißt die offizielle Sprache in der Ukraine?",
				new String[] { "a) Russisch", "b) Ukrainisch", "c) Englisch" }, 'b');
		raetseln[19] = new Raetsel("Wie heißt der Weihnachtsmann in der Ukraine?",
				new String[] { "a) Santa Clause", "b) Did Moroz", "c) Weihnachtsmann" }, 'b');
		raetseln[20] = new Raetsel("Wie viel Bits gibt es in einem Byte?", new String[] { "a) 2", "b) 8", "c) 4" },
				'b');
		raetseln[21] = new Raetsel("Wie lanng ist ein float?",
				new String[] { "a) 32 Bits", "b) 32 Byte", "c) 32 MegaBytes" }, 'a');
		raetseln[22] = new Raetsel("Wie viele Nachkommastellen hat einen double?",
				new String[] { "a) 6", "b) 13", "c) 15" }, 'c');
		raetseln[23] = new Raetsel("Ist diese Deklaration richtig: \"int = 12; ?\"",
				new String[] { "a) Ja!", "b) Nein, fehlt der Variable Name", "c) Nein, 12 ist kein Integer" }, 'b');
		randomizeRaetseln(); // Aufruf Methode randomizeRaetsel
	}

	/**
	 * randomRaetselGenerieren
	 * ---------------------
	 * Methode, die die Raetseln vermischt 
	 */
	public void randomizeRaetseln() {
		Random rand = new Random();
		for (int i = raetseln.length - 1; i > 0; i--) {
			int index = rand.nextInt(i + 1); 
			Raetsel a = raetseln[index]; // in "a" wird "raetsel" mit index "index" gespeichert
			raetseln[index] = raetseln[i]; // jetzt wird in "raetseln" mit dem index "index" i-te "raetseln" gespeichert
			raetseln[i] = a; // in i-te "raetseln" speichern wir raetsel "a"
		}
	}

	/**
	 * frageAusgeben
	 * -------------------------------
	 * @param zahl(Typ int): User Eingabe
	 * ----------------- 
	 * Methode, zur Ausgabe der Frage und 3 möglichen Antworten zu dieser Frage
	 * ---------------
	 */
	public void frageAusgeben(int zahl) {
		Raetsel einzelneRaetsel = raetseln[zahl - 1]; // "tuer - 1 " weil wir haben raetsel von o bis 23 und der User gibt die Zahl zwischen 1 und 24
		System.out.println(einzelneRaetsel.frageBekommen()); // Aufruf Methode aus der Klasse Raetsel
		for (String antwort : einzelneRaetsel.antwortenBekommen()) { // Aufruf Methode aus der Klasse Raetsel
			System.out.println(antwort);
		}
	}
	
	/**
	 * antwortenVergrleichen
	 * -------------------------------
	 * @param zahl1 (Typ int): User Eingabe
	 * ----------------- 
	 * Methode, die die User's Antwort mit der richtigen Antwort vergleicht.
	 * ---------------
	 */
	public void antwortenVergleichen(int zahl1) {
		Raetsel einzelneRaetsel = raetseln[zahl1 - 1];
		do {
			System.out.print("Geben Sie eine Antwort als a/b/c ein. ");
			Scanner in = new Scanner(System.in);
			char userAntwort = in.next().charAt(0);
			if (userAntwort == 'a' || userAntwort == 'b' || userAntwort == 'c') {
				if (einzelneRaetsel.antwortÜberprüfen(userAntwort)) { //if User's Antwort korrekt ist
					System.out.println("Frohe Weihnachten!");
					break;
				} else {
					System.out.println("Leider flasch. Die richtige Antwort ist: " + (char)(einzelneRaetsel.richtigeAntwortBekommen()) + 
							"\nProbieren Sie noch mal im nächsten Jahr\n");
					break;
				}
			} else { // falls der User nicht die Buchstaben "a/b/c" eingegeben hat
				System.out.print("Sie haben Ihre Antwort nicht als a/b/c eingegeben.\n");
			}
		} while (true);
	}

	/**
	 * monatNameBekommen
	 * -------------------------------
	 * @param monat (Typ int): Nummer des Monats
	 * ----------------- 
	 * @return months[monat] (Typ String)
	 * Methode, die den Name von Monat ausgibt
	 * ---------------
	 */
	public String monatNameBekommen(int monat) {
		String[] months = { "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };
		return months[monat-1];
	}
} // Ende der Klasse Adventskalender
