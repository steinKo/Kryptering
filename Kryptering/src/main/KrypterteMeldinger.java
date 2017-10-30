package main;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KrypterteMeldinger {
	private Lock laas;
    private Condition meldingerFinnes;
	private LinkedList<Melding> meldinger;
	
	public KrypterteMeldinger()
	{
		meldinger = new LinkedList<Melding>();
		laas = new ReentrantLock();
	    meldingerFinnes=laas.newCondition();
	}

	public void lever(Melding melding) {
		
		try
		{
			laas.lock();
		    meldinger.addLast(melding);
		    meldingerFinnes.signalAll();
		}
		finally
		{
			laas.unlock();
		}
	}
	
	public Melding hent() 
	{   
	    System.out.println("hent");
		try
		{
			
			laas.lock();
			System.out.println(meldinger.isEmpty());
			while (meldinger.isEmpty())
			{
				try
				{
					meldingerFinnes.await();
				}
				catch (InterruptedException ie)
				{
					
				}
			}
				
			Melding melding = meldinger.getFirst();
			meldinger.removeFirst();
			System.out.println("End hent");
			return melding;
		}
		finally
		{
			laas.unlock();
		}
		
	}

}
