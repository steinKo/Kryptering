package main;
import krypto.Kanal;

public class Telegrafist implements Runnable {
	Kanal kanal;
	KrypterteMeldinger krypterteMeldinger;
	static int ID = 1;
	public Telegrafist(Kanal kanal, KrypterteMeldinger km) {
		
		this.kanal = kanal;
		this.krypterteMeldinger = km;
		
	}


	
	public Melding lytt()
	{   int kanalID; 
	    String innhold;
	    
		innhold = kanal.lytt();
		if (innhold !=null)
		{ 
			kanalID = kanal.hentId();
		  Melding melding = new Melding(innhold,kanalID,ID);
		  ID++;
		   return melding;
		}
		return null;
	}
	
	public void lever(Melding melding)
	{
		krypterteMeldinger.lever(melding);
	}



	@Override
	public void run() {
		
		Melding melding;
		
		  melding = lytt();
		  //while (melding!=null)
		  //{
		      System.out.println("Run Telegrafist"+ melding.hentInhhold());
		      lever(melding);
		     // melding = lytt();
		   
		  //} 
		 
		
		
		
	}

}
