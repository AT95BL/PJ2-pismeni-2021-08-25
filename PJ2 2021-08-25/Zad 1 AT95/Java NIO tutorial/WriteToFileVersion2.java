import java.nio.file.*;
import java.nio.*;
import java.util.*;

public class WriteToFileVersion2{
	
	public static void main(String[] args){
		
		try{
			
			/*
			Path p = Paths.get("DataSet/newFile1.txt");
			Path donePath1 = Files.createFile(p);
			
			String content = "Hello Coding Owls";
			
			Files.write(donePath1, content.getBytes());
			System.out.println("Data Written as byte array \n");
			*/
			
			Path p2=Paths.get("DataSet/newFile2.txt.txt");
			Path donePath2=Files.createFile(p2);
			
			Path p3 = Paths.get("DataSet/myGuitar.txt");
			List<String> data = Files.readAllLines(p3);
			
			Files.write(donePath2,data);
			System.out.println("Data Written in File using List of String \n");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}