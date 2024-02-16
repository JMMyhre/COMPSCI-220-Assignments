package Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
	
	private Scanner in;
	
	public FileInput(String fileName) {
		
	try {
		in = new Scanner(new File(fileName));
	}
	catch (FileNotFoundException e) {
		System.err.println("Could not find the file "+fileName);
	  }
	} 
	
	public String readFromFile() {
		if (in.hasNextLine())
			return in.nextLine();
		else return null;
	}
	
	public void closeFile() {
		in.close();
	}
}