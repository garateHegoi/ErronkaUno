package dam;

import java.io.*;

public class ProcessErronka {

	public static void main(String[] args) {
		ProcessBuilder PB = new ProcessBuilder();	
		PB = new ProcessBuilder("java.exe", 
				"-cp",
				"C:\\Users\\romero.iker\\Documents\\ErronkaUno\\Java\\01-ErronkaUno\\src\\main\\java\\eus\\uni",
				"dam.WriteFile");
		
		try {
			Process process = PB.start();
			OutputStream OS = process.getOutputStream();
			OS.flush();
			OS.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

}
