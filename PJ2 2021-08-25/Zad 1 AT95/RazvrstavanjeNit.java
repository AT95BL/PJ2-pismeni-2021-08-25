import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class RazvrstavanjeNit extends Thread
{
	
	public ArrayList<Posiljka> posiljke;
	public static final File SERIALIZATION_FOLDER = new File("./serijalizacija");
	/*
		Bolje ime za klasu File bi bilo FilePath.
		Razlog je ocigledan jer klasom file samo definisemo/regulisemo putanju( relativnu/apsolutnu ) do 
		destination file/folder-a..
		
		Pojednostavljeni java.nio tutorial objasnjava sve..
		Isti dostavljam u prilogu .
		
		Elem, ./serijalizacija je proizvoljno ime ,a da ti ne bi doslo do pada programa
		u tekucem folderu( tamo gdje ti se nalazi source code tekuce klase..) moras imati 
		jedan folder imena 'serijalizacija' ..
	*/
	
	static
	{
		try
		{
			if(!SERIALIZATION_FOLDER.exists())
			{
				SERIALIZATION_FOLDER.mkdir();
			}
		}
		catch (Exception ex)
		{
			
			System.out.println("Greska na io");
			System.exit(-1);
		}
	}
	/*
		The code snippet you provided is a static initializer block in Java. 
		Static initializer blocks are used to initialize static variables or perform other static initialization tasks when a class is loaded by the JVM. 
		It is executed only once, the first time the class is loaded.
	*/
	
	public RazvrstavanjeNit()
	{
		
	}
	
	public RazvrstavanjeNit(ArrayList<Posiljka> posiljke)
	{
		this.posiljke = posiljke;
	}
	
	private void serijalizuj(ArrayList<? extends Posiljka> list, String name)
	{
		
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(
			new FileOutputStream(SERIALIZATION_FOLDER + File.separator+name)));
			
			output.writeObject(list);
			output.flush();
			output.close();
		}
		catch(IOException e)
		{
			System.out.println("Greska na io");
		}
	}
	
	@Override
	public void run()
	{
		
		ArrayList<Razglednica> razglednice = new ArrayList<>();
		ArrayList<Pismo> pisma = new ArrayList<>();
		ArrayList<VrijednosnaPosiljka> vrijednosnePosiljke = new ArrayList<>();
		
		for(var el:this.posiljke)
		{	//	evo kako ih razvrstati..razvrstavas posiljke...imaj na umu to da program ulazi u ovu metodu sa argumentom 'ArrayList<Posiljka> posiljke'
			
			if(el instanceof Razglednica)
				razglednice.add((Razglednica)el);
			else if(el instanceof Pismo)
				pisma.add((Pismo)el);
			else if(el instanceof VrijednosnaPosiljka)
				vrijednosnePosiljke.add((VrijednosnaPosiljka)el);
		}
		
		this.serijalizuj(razglednice,"razglednice.ser");
		this.serijalizuj(pisma,"pisma.ser");
		this.serijalizuj(vrijednosnePosiljke,"vrijednosnePosiljke.ser");
		
		/*	nakon razvrstavanja, 
			kolekcije se prosljedjuju drugoj niti, koja iz svake kolekcije uzima po pet slucajno odabranih posiljki i pakuje ih u tri paketa (paketi se uklanjaju iz kolekcija),
			
			Pazi sada ovo, nakon sto ih sve razvrstas(onda odradis serijalizaciju objekata..)
			onda si dalje dazun da ih rasporedis u pakete ..tako da je sljedeci korak:
		*/
		PaketMakerNit pmk = new PaketMakerNit(razglednice, pisma, vrijednosnePosiljke);
		pmk.start();	//	idemo u klasu PaketMakerNit pa da vidimo kako se od razvrstanih posiljki prave paketi..
		try
		{	
			pmk.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("KIDPRE!!!");
		}
	}
}