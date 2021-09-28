package eus.uni.dam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class WriteFile {
	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		BufferedWriter bw = null;

		try {
			PeliculaDao peliDao = appContext.getBean(PeliculaDaoMemory.class);

			System.out.println("Datuak gordetezen:");
			for (Pelicula peli : peliDao.getPeliculas()) {
				System.out.println(peli);
			}

			File file = new File("C:\\Users\\garate.hegoi\\Desktop\\datuak\\datuak.txt");
			FileWriter fr = null;
			BufferedWriter br = null;
			String dataWithNewLine = peliDao.getPeliculas() + System.getProperty("line.separator");
			try {
				fr = new FileWriter(file);
				br = new BufferedWriter(fr);
				for (int i = peliDao.getPeliculas().size(); i > 0; i--) {
					br.write(dataWithNewLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}
		((AnnotationConfigApplicationContext) appContext).close();
	}
}