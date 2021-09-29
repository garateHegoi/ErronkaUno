package eus.uni.dam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WriteFile {
	
	public static void main(String[] args) {
		
		List<Customer> lista= new ArrayList<Customer>();
		
		String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
		String USER = "openpg";
		String PASS = "openpgpwd";
		String QUERY = "SELECT id, \"name\", company_id, create_date, display_name, \"date\", title, parent_id, \"ref\", lang, tz, user_id, vat, website, \"comment\", credit_limit, active, employee, \"function\", \"type\", street, street2, zip, city, state_id, country_id, partner_latitude, partner_longitude, email, phone, mobile, is_company, industry_id, color, partner_share, commercial_partner_id, commercial_company_name, company_name, create_uid, write_uid, write_date, message_main_attachment_id, email_normalized, message_bounce, signup_token, signup_type, signup_expiration, team_id, partner_gid, additional_info, phone_sanitized, debit_limit, last_time_entries_checked, invoice_warn, invoice_warn_msg, supplier_rank, customer_rank, sale_warn, sale_warn_msg, picking_warn, picking_warn_msg, calendar_last_notif_ack, purchase_warn, purchase_warn_msg, website_id, is_published\n"
				+ "FROM public.res_partner;\n"
				+ "";
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);) {

		         while (rs.next()) {
		            // Retrieve by column name
		        	Customer customer = new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("calendar_last_notif_ack"));		      
		        	lista.add(customer);
		        	System.out.println(customer);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		
		try {
		      File myObj = new File("db\\customers.txt");		      
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        FileWriter myWriter = new FileWriter("db\\customers.txt");
		        for(Customer cus:lista) {
		        	myWriter.write(cus.getID()+","+cus.getName()+","+cus.getEmail()+","+cus.getDate()+"\n");
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
