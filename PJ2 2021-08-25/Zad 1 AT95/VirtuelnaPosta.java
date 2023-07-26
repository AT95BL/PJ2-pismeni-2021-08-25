import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Date;

public class VirtuelnaPosta
{
	public static long startTime = 0;
	public static long endTime = 0;
	
	public static ArrayList<Razglednica> generisiRazglednice()
	{
		ArrayList<Razglednica> list = new ArrayList<>();
		for(int i = 1; i <= 15; i++)
			list.add(new Razglednica("Primalac" + i, "Posiljalac" + i, "Sadrzaj" + i, "Slika" + i + ".png"));
		return list;
	}
	
	public static ArrayList<Pismo> generisiPisma()
	{
		ArrayList<Pismo> list = new ArrayList<>();
		for(int i = 1; i <= 15; i++)
			list.add(new Pismo("Primalac" + i, "Posiljalac" + i, "Sadrzaj " + i + ".txt"));
		return list;
	}
	
	public static ArrayList<VrijednosnaPosiljka> generisiVrijednosnePosiljke()
	{
		ArrayList<VrijednosnaPosiljka> list=new ArrayList<>();
		Valuta[]valute=Valuta.values();
		Random random=new Random();
		for(int i=1;i<=15;i++)
		{
			list.add(new VrijednosnaPosiljka("Primalac"+i,"Posiljalac"+i,random.nextInt(1000),valute[random.nextInt(3)]));
		}
		return list;
	}
	
	public static void main(String[]args)
	{
		startTime=new Date().getTime();
		
		//	kreira se po 15 posiljki svakog tipa i smjestaju se u proizvoljno odabranu kolekciju
		ArrayList<Posiljka> posiljke=new ArrayList<>();
		posiljke.addAll(generisiPisma()); 															//	https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html#addAll(java.util.Collection)
		posiljke.addAll(generisiRazglednice()); 
		posiljke.addAll(generisiVrijednosnePosiljke());
		
		// nad dobijenom kolekcijom odradi se shuffle
		Collections.shuffle(posiljke);																//	https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collections.html#shuffle(java.util.List)
		
		RazvrstavanjeNit nit1=new RazvrstavanjeNit(posiljke);
		/*
			novodobijena kolekcija se proslijedjuje niti, koja vrši razvrstavanje dobijenih posiljki u tri kolekcije, po tipu i serijalizuje ove kolekcije,
			idemo sada da sredimo klasu za razvrstavanje..
			
			Hocu da primjetis sljedece:
			[52]:	poziv Constructor-a klase RazvrstavanjeNit sa argumentom ArrayList<Posiljka> posiljke
			[63]:	poziv .start() metode.	Na dalje ti se vrti isti mehanizam..simulacija traje, kreiraj objekat druge klase i neka isti pozove svoju .start() metodu..
			
		*/
		
		nit1.start();
		try
		{
			nit1.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("PREKID!!");
		}
		System.out.println("Vrijeme trajanja simulacije:"+(endTime-startTime));
		var files=RazvrstavanjeNit.SERIALIZATION_FOLDER.listFiles();
		for(var file:files)
		{
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length()+"B");
		}
	}
}
/*
	Savladaj Java API:
	-Klasa/Interface
	-procitaj sta sve nudi
	-za rezime reci za sta tu/taj klasu/interface mozes iskoristiti , kako je/ga mozes iskoristiti i dok radis zadatak sjeti se istih i reci sebi
	koje ti to funkcionalnosti trebaju?
	
	Elem, radi realizacije tacaka navedenih u samom tekstu zadatka.
	pocinje se od klase VirtuelnaPosta sve dok se ne dodje do poziva Constructor-a klase RazvrstavanjeNit..
	Zatim se implementira klasa RazvrstavanjeNit, pa onda idemo u PaketMakerNit i na kraju u SenderNit..
*/	