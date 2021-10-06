package dam;

public class Products{
	
	int ID;
	String name,list_price,description,volume,weight,stock;
	boolean sale_ok,active,is_published;
	
	public Products(int iD, String name, String list_price, String description, String volume, String weight,String stock,
			boolean sale_ok, boolean active, boolean is_published) {
		super();
		ID = iD;
		this.name = name;
		this.list_price = list_price;
		this.description = description;
		this.volume = volume;
		this.weight = weight;
		this.stock = stock;
		this.sale_ok = sale_ok;
		this.active = active;
		this.is_published = is_published;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getList_price() {
		return list_price;
	}

	public void setList_price(String list_price) {
		this.list_price = list_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public boolean isSale_ok() {
		return sale_ok;
	}

	public void setSale_ok(boolean sale_ok) {
		this.sale_ok = sale_ok;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isIs_published() {
		return is_published;
	}

	public void setIs_published(boolean is_published) {
		this.is_published = is_published;
	}

	@Override
	public String toString() {
		return "Products [ID=" + ID + ", name=" + name + ", list_price=" + list_price + ", description=" + description
				+ ", volume=" + volume + ", weight=" + weight + ", stock=" + stock + ", sale_ok=" + sale_ok
				+ ", active=" + active + ", is_published=" + is_published + "]";
	}

	

	


	
}
