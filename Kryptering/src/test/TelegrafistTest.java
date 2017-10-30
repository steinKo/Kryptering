package test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import krypto.Kanal;
import krypto.Operasjonssentral;
import main.KrypterteMeldinger;
import main.Melding;
import main.Telegrafist;

public class TelegrafistTest {

	Operasjonssentral os;
	  Kanal[] kanaler;
	 int antallKanaler;
	Telegrafist telegrafist;
	 KrypterteMeldinger km;
		
	
	@Before
	public void setUp()
	{ 
	
	   os = new Operasjonssentral(1);
	   kanaler = new Kanal[1];
	   kanaler = os.hentKanalArray();
	   km = new KrypterteMeldinger();
	   telegrafist = new Telegrafist(kanaler[0],km);
	   
	}
	
	@Test
	public void testLytt() {
		
		assertNotNull( telegrafist.lytt());
		
	}
	
	@Test
	public void testLever() {
		Melding melding = telegrafist.lytt();
		telegrafist.lever(melding);
		assertNotNull(km.hent());
	}

}
