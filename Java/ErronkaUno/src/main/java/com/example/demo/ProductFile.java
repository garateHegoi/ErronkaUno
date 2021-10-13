package com.example.demo;

import java.util.Collection;

public interface ProductFile {

public Collection<Products> getProducts();
	
    public void init();

	public Collection<Products> findAll() ;

	public void insert(Products pelicula);

	public void edit(Products pelicula);
	
	public void delete(long id) ;
	
}
