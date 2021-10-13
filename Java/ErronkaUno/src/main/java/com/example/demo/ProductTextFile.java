package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository
public class ProductTextFile implements ProductFile{
	String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
	String USER = "openpg";
	String PASS = "openpgpwd";
	String QUERY = "SELECT product_template.id, product_template.name, product_template.description_sale, product_template.list_price, product_template.volume, product_template.weight, SUM(stock_move.product_qty) - (select sum(stock_move.product_qty) from public.stock_move where stock_move.location_dest_id = 5 and stock_move.product_id = product_template.id) as stock,(select imagenes.imagen_hash from public.imagenes where imagenes.id_item = product_template.id) as imagen , product_template.sale_ok,product_template.is_published, product_template.active FROM public.product_template inner join stock_move on stock_move.product_id = product_template.id inner join imagenes on imagenes.id_item = product_template.id where stock_move.location_dest_id = 8 group by product_template.id";
	
	
	public List<Product> products = new ArrayList<>();

	ProductTextFile() {

	};

	public Collection<Product> getProducts() {
		return products;
	};

	/**
	 * Hasieran, fitxategia irakurri eta datuak memorian, zerrenda baten kargatuko
	 * dira. Stream-ak erabiliz.
	 * 
	 */
	@PostConstruct
	public void init() {
		// TO-DO
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
				
		         ResultSet rs = stmt.executeQuery(QUERY);) {

		         while (rs.next()) {
		            // Retrieve by column name
		        	 
		        	Product product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("list_price"),rs.getString("description_sale"),rs.getString("volume"),rs.getString("weight"),rs.getString("stock"),rs.getString("imagen"),rs.getBoolean("sale_ok"),rs.getBoolean("active"),rs.getBoolean("is_published"));		      
		        	insert(product);
		        	System.out.println(product.getImagen());
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		try {
		      File myObj = new File("..\\..\\Android\\app\\src\\main\\res\\raw\\products.txt");		      
		        System.out.println("File created: " + myObj.getName());
		        FileWriter myWriter = new FileWriter("..\\..\\Android\\app\\src\\main\\res\\raw\\products.txt");
		        for(Product cus:products) {
		        	myWriter.write(cus.getID()+"|"+cus.getName()+"|"+cus.getList_price()+"|"+cus.getDescription()+"|"+cus.getVolume()+"|"+cus.getWeight()+"|"+cus.getStock()+"|"+cus.getImagen()+"|"+cus.isSale_ok()+"|"+cus.isActive()+"|"+cus.isIs_published()+"\n");
		        }
		        myWriter.close();

		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		   }
	}

	/**
	 * Memorian, aurretik kargatu dugun zerrenda itzultzen du metodo honek
	 * 
	 */
	public Collection<Product> findAll() {
		return products;
	}

	/**
	 * Pelikula berri bat txertatzen du memoriako zerrendan
	 * 
	 * @param pelicula
	 */
	public void insert(Product product) {
		products.add(product);
	};

	/**
	 * Pelikulen zerrendan id berdina daukan pelikula bilatu eta aldatu
	 * 
	 * @param pelicula
	 */
	public void edit(Product product) {
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
}
