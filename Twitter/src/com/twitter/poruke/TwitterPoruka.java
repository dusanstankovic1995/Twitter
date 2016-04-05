package com.twitter.poruke;

/**
 * Ovo je klasa koja koja sadrzi dva atributa:
 * <ul>
 * <li>korisnik</li>
 * <li>poruka</li>
 * </ul>
 * i predstavlja poruku na tviteru.
 * 
 * @author Dusan Stankovic
 *
 */

public class TwitterPoruka {
	/**
	 * Atribut korisnik predstavlja ime korisnika.
	 */
	private String korisnik;
	/**
	 * Atribut poruka predstavlja sadrzaj poruke.
	 */
	private String poruka;

	/**
	 * Ova metoda vraca ime korisnika.
	 * 
	 * @return ime korisnika
	 */

	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Ova metoda postavlja vrednost atributa korisnik na datog korisnika.
	 * 
	 * @param korisnik
	 *            ime korisnika
	 * @throws java.lang.RuntimeException kada je korisnik null ili prazan string
	 */

	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Ova metoda vraca odgovarajucu poruku.
	 * 
	 * @return odgovarajuca poruka
	 */

	public String getPoruka() {
		return poruka;
	}

	/**
	 * Ova metoda postavlja vrednost atributa poruka na unetu poruku.
	 * 
	 * @param poruka
	 *            odgovarajuca poruka
	 * @throws java.lang.RuntimeException kada je poruka null ili duza od 140 karaktera
	 */

	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Ova metoda vraca vrednosti atributa korisnik i atributa poruka.
	 */

	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((korisnik == null) ? 0 : korisnik.hashCode());
		result = prime * result + ((poruka == null) ? 0 : poruka.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterPoruka other = (TwitterPoruka) obj;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (poruka == null) {
			if (other.poruka != null)
				return false;
		} else if (!poruka.equals(other.poruka))
			return false;
		return true;
	}
	
	
}
