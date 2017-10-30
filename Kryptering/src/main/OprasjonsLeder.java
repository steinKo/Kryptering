package main;

public class OprasjonsLeder implements Runnable{
	
	KrypterteMeldinger krypteringsmelinger;
	OprasjonsLeder(KrypterteMeldinger dm )
	 {
		this.krypteringsmelinger= dm;
		
	 }
	
	public Melding hent()
	 {
		return krypteringsmelinger.hent();
	 }
	
	public String organiser()
	 {
		return null;
	 }

	@Override
	public void run() {
	Melding melding =	hent();
	System.out.println("opersjosleder hent" + melding.hentInhhold());
		
	}

}
