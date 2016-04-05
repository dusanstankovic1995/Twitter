package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa Twitter sadrzi:
 * <ul>
 * <li>atribu poruke koji predstavlja listu TwitterPoruka</li>
 * <li>Metode za unos i vracanje poruka</li>
 * </ul>
 * 
 * @author Dusan Stankovic
 */
public class Twitter {

	/**
	 * Atribut poruke predstavlja listu TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Ova metoda vraca sve poruke iz liste poruka.
	 * 
	 * @return lista poruka;
	 */

	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Ova metoda pravi novi objekat TwitterPoruka, postavlja vrednosti njegovih
	 * atributa i unosi ga u listu.
	 * 
	 * @param korisnik
	 *            ime korisnika
	 * @param poruka
	 *            ogdovarajuca poruka
	 */

	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Ova metoda vraca niz poruka koje sadrze odgovarajuci tag u sebi.
	 * 
	 * @param maxBroj
	 *            predstavlja kapacitet niza rezultat
	 * @param tag
	 *            trazeni tag u poruci
	 * @throws java.lang.RuntimeException
	 *             kada je tag null ili prazan string
	 * @return niz porka sa zeljenim tagom
	 */

	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0; // Pomocni niz koja predstavlja rezultat pretrage tj.
						// sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
