import java.nio.file.*;
import java.nio.*;
import java.util.*;

public class ReadFromFile{
	
	public static void main(String[] args){
		
		try{
			
			Path p = Paths.get("DataSet/myGuitar.txt");
			
			List<String> data = Files.readAllLines(p);
			
			for(String str:data){
				System.out.println(str);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}