package dam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WriteFile {
	
	public static void main(String[] args) {
		
		List<Products> lista= new ArrayList<Products>();
		String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
		String USER = "openpg";
		String PASS = "openpgpwd";
		String QUERY = "SELECT product_template.id, product_template.name, product_template.description_sale, product_template.list_price, product_template.volume, product_template.weight, product_template.sale_ok, SUM(stock_move.product_qty) - (select sum(stock_move.product_qty) from public.stock_move where stock_move.location_dest_id = 5 and stock_move.product_id = product_template.id) as stock ,product_template.is_published, product_template.active FROM public.product_template inner join stock_move on stock_move.product_id = product_template.id where stock_move.location_dest_id = 8 group by product_template.id";
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
				
		         ResultSet rs = stmt.executeQuery(QUERY);) {

		         while (rs.next()) {
		            // Retrieve by column name
		        	Products product = new Products(rs.getInt("id"),rs.getString("name"),rs.getString("list_price"),rs.getString("description_sale"),rs.getString("volume"),rs.getString("weight"),rs.getString("stock"),rs.getBoolean("sale_ok"),rs.getBoolean("active"),rs.getBoolean("is_published"));		      
		        	lista.add(product);
		        	System.out.println(product);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		
		//Writer
		try {
		      File myObj = new File("..\\..\\Android\\app\\src\\main\\res\\raw\\products.txt");		      
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        FileWriter myWriter = new FileWriter("..\\..\\Android\\app\\src\\main\\res\\raw\\products.txt");
		        for(Products cus:lista) {
		        	myWriter.write(cus.getID()+";"+cus.getName()+";"+cus.getList_price()+";"+cus.getDescription()+";"+cus.getVolume()+";"+cus.getWeight()+";"+cus.getStock()+";"+cus.isSale_ok()+";"+cus.isActive()+";"+cus.isIs_published()+"\n");
		        }
		        myWriter.close();
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		   }
		
	}
}
