import java.util.ArrayList;

public class Paket<T extends Posiljka>							//		!=	public class Paket<T> extends Posiljka{..}	vise o tome dostavljam u prilogu GenericClassLearning1,2,3
{
	
	public ArrayList<T> posiljke = new ArrayList<>();			//		Svaku posiljku dodaj u listu..kao sto je i receno u samom tekstu zadatka..
	public int ukupnaTezina = 0;
	
	public void addPosiljka(T posiljka)							//		Constructor
	{
		this.posiljke.add(posiljka);
		this.ukupnaTezina += posiljka.tezina;
	}
	
	@Override
	public String toString()
	{
		
		StringBuilder builder = new StringBuilder();
		builder.append("Paket:\n");
		/*
			Appending Header: The first line adds the string "Paket:\n" to the builder. 
			This is a header that is added at the beginning of the generated string. 
			The "\n" represents a newline character, so each time the builder.append() method is called with this string, it adds a newline to the output.
		*/
		
		posiljke.forEach((a)->{builder.append(a.toString()+"\n");});
		/*
			Lambda Expression: The lambda expression (a) -> {builder.append(a.toString() + "\n");} is used as the parameter to the forEach method. 
			It defines a behavior to be applied to each element a in the collection.
			
			(a) -> is a lambda expression in Java, and it represents an anonymous function or a shorthand way of defining a functional interface implementation.
			In Java, a lambda expression has the following syntax	(parameters) -> { body }
			In this case, (a) is the parameter list, and it indicates that the lambda expression takes one parameter named a. 
			The arrow -> separates the parameter list from the body of the lambda expression.
			The lambda expression you provided (a) -> { builder.append(a.toString() + "\n"); } is a concise way of implementing the Consumer functional interface. 
			The Consumer interface is a part of the Java API.
			
		*/
		return builder.toString();
	}
	/*
		In summary, the toString() method creates a string representation of the object by iterating through a collection (posiljke) and calling 
		the toString() method of each element in the collection. 
		The final output is a multiline string with each element's string representation separated by newlines.
		
		Znaci u paket trpas posiljke i sa metodom toString() imas mogucnost da na standardni izlaz tj. ekran ispises sadrzaj paketa.
	*/
}
