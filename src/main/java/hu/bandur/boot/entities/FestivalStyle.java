package hu.bandur.boot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FESTIVALSTYLES")
public class FestivalStyle {

	private String style;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonIgnore
	@ManyToOne
	private Festival festival;

	private FestivalStyle() {
		super();
	}

	public FestivalStyle(String style, Festival festival) {
		super();
		this.style = style;
		this.festival = festival;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getId() {
		return id;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FestivalStyle{" +
				"style='" + style + '\'' +
				", id=" + id +
				", festival=" + festival +
				'}';
	}
}
