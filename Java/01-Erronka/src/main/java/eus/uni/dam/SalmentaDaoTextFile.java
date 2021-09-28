package eus.uni.dam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

@Repository
public class SalmentaDaoTextFile  implements SalmentaDao{

	String filename = "Salmentas.csv";
	public List<Salmenta> salmentas = new ArrayList<>();

	SalmentaDaoTextFile() {

	};

	public Collection<Salmenta> getPeliculas() {
		return salmentas;
	};

	/**
	 * Hasieran, fitxategia irakurri eta datuak memorian, zerrenda baten kargatuko
	 * dira. Stream-ak erabiliz.
	 * 
	 */
	@PostConstruct
	public void init() {
		// TO-DO
	}

	/**
	 * Memorian, aurretik kargatu dugun zerrenda itzultzen du metodo honek
	 * 
	 */
	public Collection<Salmenta> findAll() {
		return salmentas;
	}

	/**
	 * Pelikula berri bat txertatzen du memoriako zerrendan
	 * 
	 * @param pelicula
	 */
	public void insert(Salmenta salmenta) {
		salmentas.add(salmenta);
	};

	/**
	 * Pelikulen zerrendan id berdina daukan pelikula bilatu eta aldatu
	 * 
	 * @param pelicula
	 */
	public void edit(Salmenta salmenta) {
		// TO-DO
	};

	/**
	 * Pelikulen zerrendatik, id hori daukana bilatu eta ezabatu
	 * 
	 * @param id
	 */
	public void delete(long id) {
		// TO-DO
	};

	/**
	 * Katalogoa berriz behar ez dugunean, memorian daukagun zerrenda 
	 * testu fitxategi baten egingo dugu persistente.
	 * 
	 */
	@PreDestroy
	public void destroy() {
        //TO-DO
	}

	@Override
	public Collection<Salmenta> getSalmenta() {
		// TODO Auto-generated method stub
		return null;
	}
}
