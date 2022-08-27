package filecrawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class filecrawler {
	
	public static void main(String[] args) {
		
		Scanner inp = null;
		String searchText = null;
		
		inp = new Scanner(System.in);
		System.out.print("Enter searchtext - ");  
		searchText= inp.next();
	
		if (inp != null) {
			inp.close();
		}
		
		readFile("c:\\filecrawler\\röd.txt", searchText);
		
	}
	
	protected static void readFile(String filepath, String searchText) {
		File file = new File(filepath);
		
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
				String text = (scanner.nextLine());
				System.out.println("Text in file " +file +": " +text);
				
				boolean val = text.contains(searchText);
				if(val)
					System.out.println("String found: "+searchText);
				else 
					System.out.println("string not found");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Filen finns inte");
		} finally {
			if (scanner != null) {
				scanner.close(); 
			}
			
		}
	}

}