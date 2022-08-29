package filecrawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;

public class filecrawler {
	
	public static void main(String[] args) {
		String path = ("./");
		
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter searchtext - ");  
		String searchText= inp.next();
		if (inp != null) {
			inp.close();
		}
		
		loopFiles(path, searchText);
	}
		
	private static void loopFiles(String path, String searchText) {
		File[] files = new File(path).listFiles();
			
		for (File file : files) {
			if (Files.isReadable(file.toPath())) {
				if (file.isFile()) {
			    	path = (file.getAbsolutePath());
			    	searchFile(path, searchText);
		    	} else if (file.isDirectory()) {
		    	path = (file.getAbsolutePath());
		    	loopFiles(path, searchText);
		    	}
			} else {
				System.err.println("File " + file.getAbsolutePath() +" is not readable");
			}	
		}
	}
	
	private static void searchFile(String path, String searchText) {
		File file = new File(path);
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String text = (scanner.nextLine());
				boolean val = text.contains(searchText);
				if(val) {
					System.out.println(path);
					return;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("sorry, file does not exist");
		} finally {
			if (scanner != null) {
				scanner.close(); 
			}
		}
	}
}