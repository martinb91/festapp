package hu.bandur.boot.dto;

public class AccommodationDTO {
	
	private double price;
	private String name;
	private int heads;
	private PositionDTO address;
	private String description;
	private String email;
	private String phoneNumber;
	private int id;
	private String website;

	public AccommodationDTO() { }

	public AccommodationDTO(double price, String name, int heads, PositionDTO address, String description, String email, String phoneNumber, int id, String website) {

		this.price = price;
		this.name = name;
		this.heads = heads;
		this.address = address;
		this.description = description;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.website = website;
	}

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

	public PositionDTO getAddress() {
		return address;
	}

	public void setAddress(PositionDTO address) {
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

	public void setId(int id) {
		this.id = id;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "AccommodationDTO{" +
				"price=" + price +
				", name='" + name + '\'' +
				", heads=" + heads +
				", address=" + address +
				", description='" + description + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", id=" + id +
				", website='" + website + '\'' +
				'}';
	}
}
