package com.example.demo;

import java.util.Collection;

public interface ProductFile {

public Collection<Product> getProducts();
	
    public void init();

	public Collection<Product> findAll() ;

	public void insert(Product pelicula);

	public void edit(Product pelicula);
	
	public void delete(long id) ;
	
}
