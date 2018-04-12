package hu.bandur.boot.entities;

import javax.persistence.*;

@Entity(name = "ACCOMMONDATION")
public class Accommodation {
	
	private double price; //price for a day
	private String name;
	private int heads;
	@OneToOne
	private Position address;
	private String description;
	private String website;
	private String email;
	@Column(name = "PHONENUMBER")
	private String phoneNumber;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	private Accommodation() {
	}

	public Accommodation(double price, String name, int heads, Position address, String description, String email, String phoneNumber, String website) {
		this.website=website;
		this.price = price;
		this.name = name;
		this.heads = heads;
		this.address = address;
		this.description = description;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

<<<<<<< HEAD
=======
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

>>>>>>> 33f7f8f21c8e1f4ec6997fed5deee1ab71089041
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeads() {
		return heads;
	}

	public void setHeads(int heads) {
		this.heads = heads;
	}

	public Position getAddress() {
		return address;
	}

	public void setAddress(Position address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Accommodation{" +
				"price=" + price +
				", name='" + name + '\'' +
				", heads=" + heads +
				", address=" + address +
				", description='" + description + '\'' +
				", website='" + website + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", id=" + id +
				'}';
	}
}
