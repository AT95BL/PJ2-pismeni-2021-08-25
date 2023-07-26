import java.util.ArrayList;
import java.util.Random;

public class PaketMakerNit extends Thread
{
	
	public ArrayList<Razglednica> razglednice;
	public ArrayList<Pismo> pisma;
	public ArrayList<VrijednosnaPosiljka> vrijednosnePosiljke;
	
	public PaketMakerNit()
	{
		
	}
	
	public PaketMakerNit(ArrayList razglednice, ArrayList<Pismo> pisma, ArrayList<VrijednosnaPosiljka> vrijednosnePosiljke)
	{
		this.razglednice = razglednice;
		this.pisma = pisma;
		this.vrijednosnePosiljke = vrijednosnePosiljke;
	}
	
	@Override
	public void run()
	{
		
		Paket<Razglednica> paket1 = new Paket<>();
		Paket<Pismo> paket2 = new Paket<>();
		Paket<VrijednosnaPosiljka> paket3 = new Paket<>();
		
		Random rand = new Random();
		
		for(int i=1;i<=5;i++)
		{
			int pos=rand.nextInt(razglednice.size());
			paket1.addPosiljka(razglednice.get(pos));
			razglednice.remove(pos);
		}
		
		for(int i=1;i<=5;i++)
		{
			int pos=rand.nextInt(pisma.size());
			paket2.addPosiljka(pisma.get(pos));
			pisma.remove(pos);
		}
		
		for(int i=1;i<=5;i++)
		{
			int pos=rand.nextInt(vrijednosnePosiljke.size());
			paket3.addPosiljka(vrijednosnePosiljke.get(pos));
			vrijednosnePosiljke.remove(pos);
		}
		
		/*
			int pos = rand.nextInt(razglednice.size());: 
			This line generates a random number pos using the nextInt() method of the Random class (rand). 
			The random number will be between 0 (inclusive) and the size of the razglednice list (exclusive).

			paket1.addPosiljka(razglednice.get(pos));: 
			This line adds a Posiljka object from the razglednice list to the paket1 object 
			(assuming paket1 is an instance of some class that has an addPosiljka() method to add Posiljka objects). 
			The get() method retrieves the Posiljka object at the specified index pos from the razglednice list.
			
			In summary, the code snippet uses a for loop to repeat the process five times. 
			Each iteration randomly selects a Posiljka object from the razglednice list, adds it to the paket1 object, and then removes it from the razglednice list. 
			This process ensures that paket1 contains five randomly selected Posiljka objects from the razglednice list without any duplicates. 
			The Random class (rand) is used to generate random indices for picking elements from the list.
		*/
		
		ArrayList<ArrayList<? extends Posiljka>> kolekcija = new ArrayList<>();
		kolekcija.add(this.razglednice);
		kolekcija.add(this.pisma);
		kolekcija.add(this.vrijednosnePosiljke);
		
		ArrayList<Paket<? extends Posiljka>> paketi = new ArrayList<>();
		paketi.add(paket1);
		paketi.add(paket2);
		paketi.add(paket3);
		
		SenderNit sn = new SenderNit(kolekcija, paketi);
		sn.start();
		try
		{
			sn.join();
		}
		catch (InterruptedException ex){
			System.out.println("PREKID!!!");
		}
	}
}