package dam;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	
	public static ArrayList<String> irakurri(String path){
		ArrayList<String> listaDatuak = new ArrayList<String>();
		 try {
		      File myObj = new File(path);
		      Scanner myReader = new Scanner(myObj);  
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        listaDatuak.add(data);
		      }
		      myReader.close();
		      return listaDatuak;
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } 
		 return null;

	}
	
}
