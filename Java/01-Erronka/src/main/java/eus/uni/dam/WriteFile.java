package eus.uni.dam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	   public static void main(String[] args) {
	      BufferedWriter bw = null;
	      try {
		 String mycontent = Pelicula peli:peliDao.getPeliculas();
		 
		 File file = new File("C:/datuak.txt");
		 
		  if (!file.exists()) {
		     file.createNewFile();
		  }

		  FileWriter fw = new FileWriter(file);
		  bw = new BufferedWriter(fw);
		  bw.write(mycontent);
	          System.out.println("File written Successfully");

	      } catch (IOException ioe) {
		   ioe.printStackTrace();
		}
		finally
		{ 
		   try{
		      if(bw!=null)
			 bw.close();
		   }catch(Exception ex){
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}
	   }
	   ((AnnotationConfigApplicationContext) appContext).close();
	}