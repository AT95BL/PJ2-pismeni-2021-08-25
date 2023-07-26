public class Pismo extends Posiljka
{
	
	public String tekst;
	
	public Pismo()
	{
		
	}
	
	public Pismo (String adresaPrimaoca, String adresaPosiljaoca, String tekst)throws IllegalArgumentException
	{
		super(adresaPrimaoca, adresaPosiljaoca, 0);
		if(!tekst.endsWith(".txt"))
		{
			throw new IllegalArgumentException("Pismo mora imati ekstenziju .txt");
		}
		
		this.tekst = tekst;
		this.tezina = random.nextInt(20)+1;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", " + this.tekst;
	}
}