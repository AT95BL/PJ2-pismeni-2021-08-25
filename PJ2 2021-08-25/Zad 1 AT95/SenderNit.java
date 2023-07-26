import java.util.Date;
import java.util.ArrayList;

public class SenderNit extends Thread
{
	
	public ArrayList<ArrayList<? extends Posiljka>> kolekcija;
	/*
		ArrayList<ArrayList<? extends Posiljka>>: This declares the type of the variable kolekcija. 
		It is an ArrayList of ArrayLists, where each inner ArrayList contains elements of a type that extends Posiljka.
		
		Znaci 'kolekcija' je referenca na ArrayList-u ArrayList-a koje skladiste djecije-klase-klase-Posiljka.
		Npr. kolekcija[0] <=> ArrayList<Razglednica> razglednica
			 kolekcija[1] <=> ArrayList<Pismo> pisma
			 kolekcija[2] <=> ArrayList<VrijednosnaPosiljka> vrijednosnePosiljke
	*/
	public ArrayList<Paket<? extends Posiljka>> paketi;
	/*
		paketi[0] <=> ArrayList<Paket<Razglednica>> paket1
		paketi[1] <=> ArrayList<Paket<Pismo>> paket2
		paketi[2] <=> ArrayList<Paket<VrijednosnaPosiljka>> paket3
	*/
	
	public SenderNit()
	{
		
	}
	
	public SenderNit(ArrayList<ArrayList<? extends Posiljka>> kolekcija, ArrayList<Paket<? extends Posiljka>> paketi)
	{
		this.kolekcija = kolekcija;
		this.paketi = paketi;
	}
	
	@Override
	public void run()
	{
		
		for(var paket:this.paketi)
		{
			
			for(int i = 1; i <= 3; i++)
			{
				if(paket.ukupnaTezina > 15){
				
				try
				{
					
					System.out.println("Salje se " + i + "." + " dio");
					sleep(3000);
				}
				catch(InterruptedException e)
				{
					
					System.out.println("PREKID!!!");
				}
			  }
			}
			System.out.println(paket+"\n"+" Uspjesno poslat!!");
		}
	
		for(var kol:this.kolekcija)
		{
			for(var paket:kol)
			{
				if(paket.tezina > 15)
				{
					for(int i = 1; i <= 3; i++)
					{
						try
						{
							System.out.println("Salje se " + i + "." + " dio");
							sleep(3000);
						}
						catch( InterruptedException e)
						{
							System.out.println("PREKID!!!");
						}
				}
				System.out.println(paket + "\n" + "Uspjesno poslat!!!");
				}
			}
		VirtuelnaPosta.endTime = new Date().getTime();
		}	
	}
}