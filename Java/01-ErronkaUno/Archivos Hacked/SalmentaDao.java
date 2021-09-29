package eus.uni.dam;

import java.util.Collection;

public interface SalmentaDao {

	public Collection<Salmenta> getSalmenta();

	public void init();

	public Collection<Salmenta> findAll();

	public void insert(Salmenta pelicula);

	public void edit(Salmenta pelicula);

	public void delete(long id);
}
