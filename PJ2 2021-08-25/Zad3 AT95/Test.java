
import java.util.ArrayList;
import java.util.function.Predicate;


public class Test
{
	public static void main(String[]args)
	{
		
	}
	
	public static<T extends Podatak> List<T> method(ArrayList<Predicate<T>> predicates,int start,int end,ArrayList<ArrayList<T>> lists)
	{
		ArrayList<T> result=new ArrayList<>();
		for(var list:lists)
		{
			for(var el:list)
			{
				boolean status=true;
				for(var pred:predicates)
					if(!pred.test(el))
					{
						status=false;
						break;
					}
				if(status)
					result.add(el);
			}
		}
		return result.stream().sorted((a,b)->b.hashCode()-a.hashCode()).collect(Collectors.toList());
	}
}