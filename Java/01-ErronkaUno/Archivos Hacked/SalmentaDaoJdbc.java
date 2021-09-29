package eus.uni.dam;

	
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository
public class SalmentaDaoJdbc  implements SalmentaDao{

	public List<Salmenta> salmentas = new ArrayList<>();

	SalmentaDaoJdbc() {

	};

	public Collection<Salmenta> getPeliculas() {
		return salmentas;
	};

	/** Datu-basetik datuak berreskuratu eta memoriako zerrendan kargatu. 
	 *  
	 */
	@PostConstruct
	public void init() {
		
	}

	public Collection<Salmenta> findAll() {
		return salmentas;
	}

	/** DBan INSERT bat egin, eta dena ondo balego, memorian be egin insert-a.
	 * 
	 * @param pelicula
	 */
	public void insert(Salmenta salmenta) {
		// DBan insert-a
		salmentas.add(salmenta);
	};

	/** DBan UPDATE bat egin, eta dena ondo balego, memorian be...
	 *  
	 * @param pelicula
	 */
	public void edit(Salmenta salmenta) {
		//TO-DO
	};
	
	/**
	 * DBan DELETE bat egin, eta dena ondo balego, memorian be 
	 * @param id
	 */	
	public void delete(long id) {
		salmentas.remove(id);
	};

	/** Momentuoro, aldaketak, bai memorian, bai dban bertan egin izan ditugu,
	 *  beraz, ez da beharrezkoa orain zerrendako datuak dban berriz gordetzea. 
	 *  (DB-an beste norbaitek, beste aplikazio batetik 
	 *  eginiko aldaketez ez gara enteratzen. Kontuz)   
	 * 
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
