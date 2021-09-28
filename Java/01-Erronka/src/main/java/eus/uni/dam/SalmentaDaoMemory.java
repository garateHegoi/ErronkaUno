package eus.uni.dam;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository
public class SalmentaDaoMemory implements SalmentaDao {

	public List<Salmenta> salmentas = new ArrayList<>();

	SalmentaDaoMemory() {

	};

	public Collection<Salmenta> getPeliculas() {
		return salmentas;
	};

	@PostConstruct
	public void init() {

	}

	public Collection<Salmenta> findAll() {
		return salmentas;
	}

	public void insert(Salmenta salmenta) {
		salmentas.add(salmenta);
	};

	public void edit(Salmenta salmenta) {
		// pelikulen zerrendan id berdina daukan pelicula bilatu eta aldatu
	};

	public void delete(long id) {
		// pelikulen zerrendatik, id hori daukana bilatu eta ezabatu
	};

	/**
	 * Programa bukatu aurretik, memorian dauzkagun datuak inprimatuko ditugu.
	 */
	@PreDestroy
	public void destroy() {

	}

	@Override
	public Collection<Salmenta> getSalmenta() {
		// TODO Auto-generated method stub
		return null;
	}
}
