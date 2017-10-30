package main;
import java.util.LinkedList;

public class DekrypterteMeldinger {
	
	private LinkedList<String> meldinger;
	
	public DekrypterteMeldinger ()
	{
		meldinger = new LinkedList<String>();
	}
	
	
	public void lever(String medling)
	{
		meldinger.addLast(medling);
	}
	
	public String hent()
	{   String melding;
		melding = meldinger.getFirst();
		meldinger.removeFirst();
		return melding;
	}	
	

}
