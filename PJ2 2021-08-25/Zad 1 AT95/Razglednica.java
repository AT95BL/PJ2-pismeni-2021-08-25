// import java.util.Random; nema smisla!	Ne treba mi ako u roditeljskoj klasi imam public static Random random = new Random();

public class Razglednica extends Posiljka
{
	// Zasto/Kako?
	public String sadrzaj;
	public String vizuelniDio;
	
	public Razglednica()
	{
		
	}
	
	public Razglednica(String adresaPrimaoca, String adresaPosiljoca, /*int tezina,*/ String sadrzaj, String vizuelniDio) throws IllegalArgumentException
	{
		super(adresaPrimaoca, adresaPosiljoca, 0);
		this.sadrzaj = sadrzaj;
		if(!vizuelniDio.endsWith(".jpg") && !vizuelniDio.endsWith(".jpeg") && !vizuelniDio.endsWith(".png"))
		{
			throw new IllegalArgumentException("Fotografija mora da ima ekstenziju .jpg ili .jpeg ili .png"); 
		}
		this.vizuelniDio = vizuelniDio;
		this.tezina = random.nextInt(10)+1;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", " + this.sadrzaj + ", " +this.vizuelniDio;
	}
}
