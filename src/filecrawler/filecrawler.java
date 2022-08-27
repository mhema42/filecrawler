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
	
	private static void readFile(String filepath, String searchText) {
		File file = new File(filepath);
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String text = (scanner.nextLine());
				boolean val = text.contains(searchText);
				if(val) {
					System.out.println(filepath);
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