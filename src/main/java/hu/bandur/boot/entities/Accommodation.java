package hu.bandur.boot.entities;

import javax.persistence.*;

@Entity(name = "ACCOMMONDATION")
public class Accommodation {
	
	private double price; //price per for day
	private String name;
	private int heads;

	private Accommodation() {
	}

	public Accommodation(double price, String name, int heads, Position address, String description, String email, String phoneNumber) {

		this.price = price;
		this.name = name;
		this.heads = heads;
		this.address = address;
		this.description = description;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	@OneToOne
	private Position address;
	private String description;
	private String email;
	private String phoneNumber;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
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

	@Override
	public String toString() {
		return "AccommodationMapper{" +
				"price=" + price +
				", name='" + name + '\'' +
				", heads=" + heads +
				", address=" + address +
				", description='" + description + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", id=" + id +
				'}';
	}

	public void setId(int id) {
		this.id = id;
	}
}
