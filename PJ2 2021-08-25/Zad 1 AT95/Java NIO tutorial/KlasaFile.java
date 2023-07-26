import java.io.*;
import java.nio.*;

public class KlasaFile{
	public static void main(String[] args) throws IOException{
		File datoteka = new File("C:\\Users\\AT95\\OneDrive\\Desktop\\JavaWorkSpace\\Java NIO tutorial\\datoteka.txt");
		// File datoteka = new File("datoteka.txt");
		System.out.println(datoteka.getName());
		System.out.println(datoteka.getPath());
		System.out.println(datoteka.getAbsolutePath());
		System.out.println(datoteka.getCanonicalPath());
		System.out.println(datoteka.getParent());
		System.out.println(datoteka.isAbsolute());
		System.out.println(datoteka.lastModified());
		System.out.println(datoteka.length());
		System.out.println(File.pathSeparator);
	}
}