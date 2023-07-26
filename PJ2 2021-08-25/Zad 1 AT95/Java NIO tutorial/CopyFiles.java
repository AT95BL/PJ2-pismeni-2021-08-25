import java.nio.file.*;
import java.util.*;

public class CopyFiles{
	
	public static void main(String[] args){
		
		try{
			
			System.out.println("Started: " + new Date());
			
			Path source = Paths.get("Voice 005_sd.M4A");
			Path destination = Paths.get("DataSet/pasted.zip");
			
			Files.copy(source, destination);							//	Experiment: replace copy with move
			
			System.out.println("Completed: " + new Date());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}