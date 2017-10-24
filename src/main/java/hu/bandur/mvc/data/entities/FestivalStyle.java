package hu.bandur.mvc.data.entities;

import javax.persistence.Entity;

@Entity
public class FestivalStyle {

	private String style;
	private int id;

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
