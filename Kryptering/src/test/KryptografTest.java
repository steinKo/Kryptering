package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.KrypterteMeldinger;
import main.Kryptograf;
import main.Melding;

public class KryptografTest {
	Kryptograf kg;
	KrypterteMeldinger km;
	KrypterteMeldinger dm;
	Melding medling;
	
	@Before
	public void setUp()
	{
		
		km = new KrypterteMeldinger();
		dm = new KrypterteMeldinger();
		kg = new Kryptograf(km,dm);
		medling = new Melding("melding",1,1);
		
	}
	
	

	@Test
	public void testHentKrypterteMeldinger() {
		
		km.lever(medling);
		
		assertEquals(kg.hentMelding().hentInhhold(),"melding");
		
		
	}
	
	@Test
	public void testLeverDekrypterteMeldinger()
	{
		
		kg.lever(medling);
		assertEquals("melding",dm.hent().hentInhhold());
		
	}
	 

	

}
