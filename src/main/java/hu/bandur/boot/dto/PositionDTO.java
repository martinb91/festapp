package hu.bandur.boot.dto;

import javax.persistence.*;


public class PositionDTO {

	private int id;
	private double x;
	private double y;
	private String city;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String others) {
		this.description = others;
	}
	
	public PositionDTO(double x, double y, String city, String description) {
		super();
		this.x = x;
		this.y = y;
		this.city = city;
		this.description = description;
	}
	public PositionDTO() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "PositionDTO [id=" + id + ", x=" + x + ", y=" + y + ", city=" + city + ", description=" + description + "]";
	}
	
	
}
