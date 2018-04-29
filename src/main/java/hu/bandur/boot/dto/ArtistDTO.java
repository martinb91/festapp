package hu.bandur.boot.dto;

import java.io.Serializable;
import java.util.List;

public class ArtistDTO implements Serializable {

	private String name;
	private String description;
	private int id;
	private List<MusicStyleDTO> styles;
	private String picture;

	public ArtistDTO(String name, String description, int id, List<MusicStyleDTO> styles, String picture) {
		this.name = name;
		this.description = description;
		this.id = id;
		this.styles = styles;
		this.picture = picture;
	}

	public ArtistDTO(String name, String description, int id, List<MusicStyleDTO> styles) {
		this.name = name;
		this.description = description;
		this.id = id;
		this.styles = styles;
	}

	public ArtistDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<MusicStyleDTO> getStyles() {
		return styles;
	}

	public void setStyles(List<MusicStyleDTO> styles) {
		this.styles = styles;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "ArtistDTO{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", id=" + id +
//				", styles=" + styles +
				'}';
	}
}
