package main;
import krypto.Kryptografi;
public class Kryptograf  implements Runnable{
	
	private KrypterteMeldinger krypterteMeldinger;
	private KrypterteMeldinger dekrypterteMeldinger;
	
	
	public Kryptograf(KrypterteMeldinger km, KrypterteMeldinger dm) {
		krypterteMeldinger = km;
		dekrypterteMeldinger = dm;
		
	}

	public Melding hentMelding() {
	
		return krypterteMeldinger.hent();
	}
	
	
	public String dekrypter(String melding)
	{
		return Kryptografi.dekrypter(melding);
	}

	@Override
	public void run() {
		Melding kryptertmMelding;
		
	      
		   kryptertmMelding = hentMelding();
		   kryptertmMelding.settInhhold(dekrypter( kryptertmMelding.hentInhhold()));
		   dekrypterteMeldinger.lever(kryptertmMelding);
		 
		   
		   System.out.println("Run KRyptograf " + kryptertmMelding.hentInhhold());
		   
	
	}

	public void lever(Melding melding) {
		dekrypterteMeldinger.lever(melding);
		
	}
	

}
