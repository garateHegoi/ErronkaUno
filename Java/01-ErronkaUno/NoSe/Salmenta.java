package eus.uni.dam;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Salmenta {

	private int id;
	private String name;
	private String state;
	private Date date_order;
	private Date validity_order;
	private Date create_date;
	private int user_id;
	private int partner_id;
	private int amount_total;

	public Salmenta() {
	}

	public Salmenta(int id, String name, String state, Date date_order, Date validity_order, Date create_date,
			int user_id, int partner_id, int amount_total) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.date_order = date_order;
		this.validity_order = validity_order;
		this.create_date = create_date;
		this.user_id = user_id;
		this.partner_id = partner_id;
		this.amount_total = amount_total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate_order() {
		return date_order;
	}

	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}

	public Date getValidity_order() {
		return validity_order;
	}

	public void setValidity_order(Date validity_order) {
		this.validity_order = validity_order;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}

	public int getAmount_total() {
		return amount_total;
	}

	public void setAmount_total(int amount_total) {
		this.amount_total = amount_total;
	}

	@Override
	public String toString() {
		return "Salmenta [id=" + id + ", name=" + name + ", state=" + state + ", date_order=" + date_order
				+ ", validity_order=" + validity_order + ", create_date=" + create_date + ", user_id=" + user_id
				+ ", partner_id=" + partner_id + ", amount_total=" + amount_total + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount_total, create_date, date_order, id, name, partner_id, state, user_id,
				validity_order);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salmenta other = (Salmenta) obj;
		return amount_total == other.amount_total && Objects.equals(create_date, other.create_date)
				&& Objects.equals(date_order, other.date_order) && id == other.id && Objects.equals(name, other.name)
				&& partner_id == other.partner_id && Objects.equals(state, other.state) && user_id == other.user_id
				&& Objects.equals(validity_order, other.validity_order);
	}

}
