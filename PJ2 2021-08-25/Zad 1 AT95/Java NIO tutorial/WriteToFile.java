import java.nio.file.*;
import java.nio.*;
import java.util.*;

public class WriteToFile{
	
	public static void main(String[] args){
		
		try{
			
			Path p = Paths.get("DataSet/newFile1.txt");
			Path donePath1 = Files.createFile(p);
			
			String content = "Hello Coding Owls";
			
			Files.write(donePath1, content.getBytes());
			System.out.println("Data Written as byte array \n");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}