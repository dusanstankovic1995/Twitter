package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	Twitter t;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		t.unesi("Dusan", "proba");
		assertEquals("Dusan", t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("proba", t.vratiSvePoruke().get(0).getPoruka());
	}

	@Test
	public void testUnesi() {
		t.unesi("Zivko", "da li radi sve");
		assertEquals("Zivko", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("da li radi sve", t.vratiSvePoruke().getLast().getPoruka());
	}

	@Test
	public void testVratiPorukeSveOk() {
		t.unesi("Dusan", "sve je ok");
		t.unesi("Jovana", "nije sve ok");
		t.unesi("Stefan", "nema sanse");
		t.unesi("Uros", "probaj");

		TwitterPoruka[] tp = new TwitterPoruka[2];
		for (int i = 0; i < tp.length; i++) {
			tp[i] = new TwitterPoruka();
		}

		tp[0].setKorisnik("Dusan");
		tp[0].setPoruka("sve je ok");
		tp[1].setKorisnik("Jovana");
		tp[1].setPoruka("nije sve ok");

		assertArrayEquals(tp, t.vratiPoruke(2, "sve"));

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNULL() {
		t.vratiPoruke(4, null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(11, "");

	}

}
