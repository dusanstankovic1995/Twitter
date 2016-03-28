package twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {

	TwitterPoruka tp;

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testSetKorisnikSveOk() {
		tp.setKorisnik("Pera");
		assertEquals("Pera", tp.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNULL() {
		tp.setKorisnik(null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");

	}

	@Test
	public void testSetPorukaSveOk() {
		tp.setPoruka("Sve je u najboljem redu.");
		assertEquals("Sve je u najboljem redu.", tp.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNULL() {
		tp.setPoruka(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPredugacko() {
		String poruka = "JUnit is a unit testing framework for the Java programming language."
				+ " A unit test is a piece of code written by a developer that executes a specific"
				+ " functionality in the code to be tested. A unit test targets a small unit of code,"
				+ " e.g., a method or a class, and they ensure that code works as intended."
				+ " JUnit has been important in the development of test-driven style of programming."
				+ "Javadoc is a documentation generator for generating API documentation in HTML format"
				+ " from Java source code. The HTML format is used to add the convenience of being able"
				+ " to hyperlink related documents together. The doc comments format used by Javadoc is"
				+ " the de facto industry standard for documenting Java classes.";

		tp.setPoruka(poruka);
	}

	@Test
	public void testToStringClassic() {
		tp.setKorisnik("Zika");
		tp.setPoruka("Proba");

		String test = tp.toString();
		assertEquals("KORISNIK:" + "Zika" + " PORUKA:" + "Proba", test);
	}

	public void testToStringNull() {
		tp.setKorisnik(null);
		tp.setPoruka(null);

		String test = tp.toString();
		assertEquals("KORISNIK:" + null + " PORUKA:" + null, test);
	}

}
