package hu.bandur.boot.dto;

import hu.bandur.boot.entities.Festival;

import javax.persistence.*;


public class FestivalStyleDTO {

	private FestivalStyleDTO() {
		super();
	}

	public FestivalStyleDTO(String style, FestivalDTO festival) {
		super();
		this.style = style;
		this.festival = festival;
	}

	private String style;
	private int id;
	private FestivalDTO festival;

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FestivalStyleDTO [style=" + style + ", id=" + id + "]";
	}

}
