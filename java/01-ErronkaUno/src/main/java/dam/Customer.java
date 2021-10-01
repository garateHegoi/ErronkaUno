package dam;

public class Customer{
	
	private int ID;
	private String Name;
	private String Email;
	private String Date;

	public Customer(int ID, String name,String email,String date) {
		this.ID = ID;
		this.Name = name;
		this.Email = email;
		this.Date = date;	
	}
		

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", Name=" + Name + ", Email=" + Email + ", Date=" + Date + "]";
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
}
