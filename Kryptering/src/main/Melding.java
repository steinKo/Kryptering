package main;

public class Melding {
	private  String innhold;
	private final int ID;
	private final int kanalID;
	
	public Melding(String melding,int ID,int kanalID)
	{
		 this.innhold = melding;
		 this.ID= ID;
		 this.kanalID = kanalID;
		
	}

	public String hentInhhold() {
		return innhold;
	}
	public void settInhhold(String innhold) {
		this.innhold= innhold;
	}

	public int hentID() {
		return ID;
	}

	public int hentKanalID() {
		return kanalID;
	}
	

}
