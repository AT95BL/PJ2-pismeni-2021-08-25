import java.nio.file.*;
import java.nio.*;

public class CreateDirectory{
	
	public static void main(String[] args){
		
		try{
			
			Path p = Paths.get("DataSet");
			
			if(Files.exists(p)){
				System.out.println("Directory already exists");
			}
			else{
				Path donePath = Files.createDirectories(p);
				System.out.println("Directory Created at " + donePath.toString());
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}