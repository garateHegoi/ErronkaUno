package eus.uni.dam;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class FileWrite {
	static final String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
	static final String USER = "openpg";
	static final String PASS = "openpgpwd";
	static final String QUERY = "SELECT id, name, origin, client_order_ref, reference, state, date_order, validity_date, require_signature, require_payment, create_date, user_id, partner_id, partner_invoice_id, partner_shipping_id, pricelist_id, currency_id, analytic_account_id, invoice_status, note, amount_untaxed, amount_tax, amount_total, currency_rate, payment_term_id, fiscal_position_id, company_id, team_id, signed_by, signed_on, commitment_date, show_update_pricelist, campaign_id, source_id, medium_id, access_token, message_main_attachment_id, create_uid, write_uid, write_date, sale_order_template_id, incoterm, picking_policy, warehouse_id, procurement_group_id, effective_date, opportunity_id, cart_recovery_email_sent, website_id, warning_stock FROM public.sale_order";

	public static void main(String[] args) throws SQLException {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		ArrayList<String> listaDatuak = new ArrayList<String>();
		File file = new File("db\\datuak.txt");
		FileWriter fr = null;

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {

			while (rs.next()) {

				String dataWithNewLine = rs.getInt("id") + " , " + rs.getString("name") + " , " + rs.getString("state")
						+ " , " + rs.getDate("date_order") + " , " + rs.getDate("validity_date") + " , "
						+ rs.getDate("create_date") + " , " + rs.getInt("user_id") + " , " + rs.getInt("partner_id")
						+ " , " + rs.getInt("amount_total") + System.getProperty("line.separator");
				listaDatuak.add(dataWithNewLine);
			}
			
			try {
				fr = new FileWriter(file);
				for (String i : listaDatuak) {
					fr.write(i);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		((AnnotationConfigApplicationContext) appContext).close();
	}
}