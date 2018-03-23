package hu.bandur.boot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POSITIONS")
public class Position {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	public Position(double x, double y, String city, String description) {
		super();
		this.x = x;
		this.y = y;
		this.city = city;
		this.description = description;
	}
	public Position() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "PositionDTO [id=" + id + ", x=" + x + ", y=" + y + ", city=" + city + ", description=" + description + "]";
	}
	
	
}
