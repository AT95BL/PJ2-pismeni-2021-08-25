public class VrijednosnaPosiljka extends Posiljka
{
	
	public int vrijednost;
	public Valuta valuta;
	
	public VrijednosnaPosiljka()
	{
		
	}
	
	public VrijednosnaPosiljka(String adresaPrimaoca, String adresaPosiljaoca, int vrijednost, Valuta valuta)
	{
		super(adresaPrimaoca, adresaPosiljaoca, 0);
		this.vrijednost = vrijednost;
		this.valuta = valuta;
		this.tezina=Posiljka.random.nextInt(91)+10;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", " + this.vrijednost + ", " + this.valuta;
	}
}