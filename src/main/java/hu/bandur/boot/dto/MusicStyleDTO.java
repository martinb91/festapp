package hu.bandur.boot.dto;

import java.io.Serializable;

public class MusicStyleDTO implements Serializable{

	private int id;
	private String style;

	public MusicStyleDTO(){}

	public MusicStyleDTO(int id, String style) {
		this.id = id;
		this.style = style;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public String toString() {
		return "MusicStyleDTO{" +
				"id=" + id +
				", style='" + style + '\'' +
				'}';
	}
}
