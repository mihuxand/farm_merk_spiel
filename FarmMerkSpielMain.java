package ue205_farm_merk_spiel;

import inoutPkg.In;

public class FarmMerkSpielMain {

	public static void main(String[] args) {
		Farm meineFarm = new Farm();
		final int MIN_TIERE = 3;	// Wenigstens so viele Tiere sollten in den Boxen sein
		
		// Farm mit Tieren füllen
		System.out.println("============== FARM MERK SPIEL ==================");
		System.out.println("Zuerst die Farm mit Tieren füllen\n");
		boolean fuellenOk;
		fuellenOk = farmFuellen(meineFarm, MIN_TIERE);
		if (!fuellenOk) {
			System.out.println("Danke und auf Wiedersehen!");
			return;
		}
		
		// Spielen
		System.out.println("\nDas Spiel kann beginnen!\n");
		int[] ergebnis;
		ergebnis = new int[2];	// Punkte für Spieler*in 1 und 2. Mit 0 initialisieren.
		int spielerInNr;
		spielerInNr = 0;		// Spieler*in 1 hat Nummer 0
		char nochEinmal = 'j';
		while (nochEinmal == 'j') {
			System.out.print("Spieler*in " + (spielerInNr+1) + " - noch eine Runde? j/n: ");
			nochEinmal = In.readChar();
			if (nochEinmal == 'j') {
				nochEineRunde(meineFarm, spielerInNr, ergebnis);
				spielerInNr = (spielerInNr +1 ) % 2;
			}
		}
		
		// Ergebnis ausgeben
		System.out.println(
			"\n=======================================" +
			"\nSpieler*in 1: " + ergebnis[0] +
			"\nSpieler*in 2: " + ergebnis[1] +
			"\n=======================================");
	}
		
		// HILFSMETHODEN
		private static boolean farmFuellen(Farm farm, int minimaleAnzahl) {
			int anzahlTiere = 0;
			char tierart    = ' ';
			do {
				System.out.print("Bitte Tier eingeben(q=quit): Kuh/Pferd/Schwein (k/p/s): ");
				tierart = In.readChar();
				if (tierart == 'k') {
					farm.tierAufnehmen(new Kuh());
					anzahlTiere++;
				}
				else if (tierart == 'p') {
					farm.tierAufnehmen(new Pferd());
					anzahlTiere++;
				}
				else if (tierart == 's') {
					farm.tierAufnehmen(new Schwein());
					anzahlTiere++;
				}
				else if (tierart != 'q') {
					System.out.println("Falsche Tierart: " + tierart);
				}
			} while (tierart != 'q');
			
			boolean fuellenOk = false;
			if (anzahlTiere >= minimaleAnzahl) {
				fuellenOk = true;
			}
			return fuellenOk;
		}
		
		private static void nochEineRunde(Farm farm, int spielerIn, int[] erg) {
			if (farm==null || spielerIn<0 || spielerIn>1 || erg==null) {
				System.err.println("nochEineRunde: falsche/r Parameter!!: " +
					farm + ", " + spielerIn + ", " + erg);
				return;
			}
			int boxNr = -1;		// zuerst mal auf ungültig setzen
			char futter = ' ';	// detto
			boolean eingabeOk = false;
			while (!eingabeOk) {
				System.out.print("Bitte Box-Nummer eingeben: ");
				boxNr = In.readInt();
				if (boxNr<0 || boxNr>farm.getLength()-1) {
					System.out.println("Falsche Nummer: " + boxNr);
				}
				else {
					eingabeOk = true;
				}
			}
			// boxNr ist korrekt eingegeben
			eingabeOk = false;
			while (!eingabeOk) {
				System.out.print("Bitte Futter eingeben: Gras/Hafer/Küchenabfälle (g/h/k): ");
				futter = In.readChar();
				if (!(futter=='g' || futter=='k' || futter=='h')) {
					System.out.println("Falsches Futter: " + futter);
				}
				else {
					eingabeOk = true;
				}
			}
			// boxNr und Futter sind korrekt eingegeben
			boolean futterOk= false;
			futterOk = farm.fuettern(boxNr, futter);
			if (futterOk) {
				erg[spielerIn]++;
			}
		}
}
