import java.util.Random;
import java.io.Serializable;

public abstract class Posiljka implements Serializable	//	https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Serializable.html
{
	
	public String adresaPrimaoca;
	public String adresaPosiljaoca;
	public int tezina;
	
	public static Random random = new Random();		
	/*
		Citajuci tekst zadatka, nailazim na
		",a njegova tezina je slucajan broj"
		tako da imam dvije opcije i odabrao sam drugu jer je povoljnija.
		
		1) U svakoj podklasi import java.util.Random;
		Napravi objekat klase Random i generisi slucajan broj..
		
		2) U roditeljskoj klasi ovako kao sto je ovdje uradjeno da definisem jedan staticki atribut
		klase pa da ga iskoristim-pozovem u podklasama..
		Stedi linije koda, vrijeme(Imas 3 podklase i 1 glavnu klasu, sta je brze? Odraditi import na 3 mjesta ili na 1?) izvrsavanja programa
		i ujedno te uci o nacinu razmisljana OOPa:
		-Dakle, pitam se kakve su veze izmedju klasa? 
		-Moze li nesto iz glavne klase da se nametne u djecijoj?
	*/
	
	public Posiljka()
	{
		
	}
	
	public Posiljka(String adresaPrimaoca, String adresaPosiljaoca, int tezina)
	{
		this.adresaPrimaoca = adresaPrimaoca;
		this.adresaPosiljaoca = adresaPosiljaoca;
		this.tezina = tezina;
	}
	
	@Override
	public String toString()
	{
		return this.adresaPrimaoca + ", " + this.adresaPosiljaoca + ", " + this.tezina;
	}
	
	@Override
	public boolean equals(Object object)
	{
		if(this == object)
		{
			return true;
		}
		
		if(object == null || this.getClass() != object.getClass())
		{
			return false;
		}
		
		Posiljka p = (Posiljka)object;
		return(this.adresaPrimaoca.equals(p.adresaPrimaoca) && this.adresaPosiljaoca.equals(p.adresaPosiljaoca));
	}
	
	@Override
	public int hashCode()
	{
		
		int hash = 3;
		hash = hash * 7 + this.adresaPrimaoca.hashCode();
		hash = hash * 7 + this.adresaPosiljaoca.hashCode();
		return hash;

	}
	/*
		Neka uobicajena praksa jeste da se u glavnoj( roditeljskoj, abstraktnoj..) klasi odradi Override metoda toString(), equals() i hashCode()
		kao sto je to ovdje i uradjeno.

		Logicno, statuse objekata cemo porediti(equals()), ispisivati na ekran(toString())..
		Naravno hesiranje je sastavni dio OOP ali vise rijeci o njemu kasnije..
	*/
}