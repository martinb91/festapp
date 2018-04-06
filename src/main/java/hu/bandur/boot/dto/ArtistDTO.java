package hu.bandur.boot.dto;

import java.util.List;

public class ArtistDTO {

	private String name;
	private String description;
	private int id;
	private List<String> styles;

	private ArtistDTO() {

		
	}

	public ArtistDTO(String name, String description, int id, List<String> styles) {
		this.name = name;
		this.description = description;
		this.id = id;
		this.styles = styles;
	}

	public List<String> getStyles() {
		return styles;
	}

	public void setStyles(List<String> styles) {
		this.styles = styles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

}
