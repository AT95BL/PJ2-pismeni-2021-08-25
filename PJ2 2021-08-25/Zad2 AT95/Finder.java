
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.awt.Desktop;
import java.util.Scanner;
import java.util.List;

public class Finder implements FileVisitor<Path>
{
	private Path root;
	private String pattern;
	private boolean pronadjeno=false;
	
	public Finder(Path root,String pattern)
	{
		this.root=root;
		this.pattern=pattern.toUpperCase();
	}
	
	private void find(Path path)
	{
		pronadjeno=false;
		if(path.getFileName().toString().toUpperCase().contains(this.pattern))
		{
			System.out.println("Patern pronadjen u imenu datoteke:"+path.toString());
			pronadjeno=true;
		}
		if(path.getFileName().toString().endsWith(".txt")||path.getFileName().toString().endsWith(".java"))
		{
			List<String> lines;
			try
			{
				lines=Files.readAllLines(path);
				for(int i=0;i<lines.size();i++)
				{
					String tmp=lines.get(i).toUpperCase();
					for(int index=-1;(index=tmp.indexOf(this.pattern,index+1))!=-1;)
					{
						System.out.println("Patern pronadjen  u fajlu:"+path+" u redu "+(i+1)+" pozicija"+index);
						pronadjeno=true;
					}
				}
			}
			catch(IOException e)
			{
				System.out.println("Greska prilikom otvaranja fajla!!");
			}
			
			if(pronadjeno)
			{
				try
				{
					Desktop desktop=Desktop.getDesktop();
					desktop.edit(new File(path.toString()));
				}
				catch(IOException e)
				{
					System.out.println("IO greska!!");
				}
			}
		}
		
		
	}
	
	
	public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs)throws IOException
	{
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)throws IOException
	{
		this.find(file);
		if(this.pronadjeno)
		{
			System.out.println("OPCIJA:");
			Scanner scanner=new Scanner(System.in);
			String opcija;
			while(true)
			{
				opcija=scanner.nextLine();
				if("NASTAVAK".equals(opcija))
					return FileVisitResult.CONTINUE;
				else if("KRAJ".equals(opcija))
					return FileVisitResult.TERMINATE;
				else
				{
					System.out.println("Pogresna opcija");
					continue;
				}
			}	
		}
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult visitFileFailed(Path file, IOException exc)throws IOException
	{
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult postVisitDirectory(Path dir,IOException exc)throws IOException
	{
		return FileVisitResult.CONTINUE;
	}
}