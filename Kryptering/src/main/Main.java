package main;
import static org.junit.Assert.assertNotNull;

import krypto.Kanal;
import krypto.Operasjonssentral;

public class Main {

	public static void main(String[] args) {
		
		int antallKryptografer;
		int antallTelegrafister;
		Operasjonssentral os;
		Kanal[] kanaler;
		Telegrafist[] telegrafister;
		Kryptograf[] kryptografer;

	
		
		antallKryptografer = Integer.parseInt(args[0]);
		antallTelegrafister = Integer.parseInt(args[1]);
		
		os = new Operasjonssentral(antallTelegrafister);
		kanaler = new Kanal[antallTelegrafister];
		kanaler = os.hentKanalArray();
		KrypterteMeldinger km;
		km = new KrypterteMeldinger();
		KrypterteMeldinger dm;
		dm = new KrypterteMeldinger();
		telegrafister = new Telegrafist[antallTelegrafister];
		Thread[] telegrafisterThread = new Thread[antallTelegrafister];
		kryptografer = new Kryptograf[antallKryptografer];
		Thread[] kryptografThread = new Thread[antallKryptografer];
		
		
		
		for (int i=0;i<antallTelegrafister;i++)	
		{	
			
		 telegrafister[i] = new Telegrafist(kanaler[i],km);
		 telegrafisterThread[i]= new Thread(telegrafister[i]);
		 telegrafisterThread[i].start();
		 System.out.println("TelegrafistTread" +Integer.toString(i) + "startet" );
		}
		//try  
		//{
		//    Thread.sleep(1000);
		//}
		//catch (InterruptedException ie)
		//{
			
		//}
		kryptografer = new Kryptograf[antallKryptografer];
		for (int i=0;i<antallKryptografer;i++)	
		{	
		  kryptografer[i] = new Kryptograf(km,dm);
		  kryptografThread[i]= new Thread(kryptografer[i]);
		  kryptografThread[i].start();
		  System.out.println("KryptografTread" +Integer.toString(i) + "startet" );
		}
		
		//try  
		//{
		   // Thread.sleep(1000);
		//}
		//catch (InterruptedException ie)
		//{
			
		//}
		
		  OprasjonsLeder opersejonsleder;
		  opersejonsleder = new OprasjonsLeder(dm);
		  Thread opersjonsLederThread;
		  opersjonsLederThread= new Thread(opersejonsleder);
		  opersjonsLederThread.start();
		  System.out.println(" opersjonsLederThread"  + "startet" );
	
		  

	}

}
