package hu.bandur.boot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ARTISTS")
public class Artist {

	private String name;
	private String description;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy = "artist")
	private List<MusicStyle> styles;

	@Override
	public String toString() {
		return "Artist{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", id=" + id +
				", styles=" + styles +
				", concertList=" + concertList +
				'}';
	}

	@JsonIgnore
	@OneToMany(mappedBy = "artist")
	private List<Concert> concertList;

	public List<Concert> getConcertList() {
		return concertList;
	}

	public void setConcertList(List<Concert> concertList) {
		this.concertList = concertList;
	}

	private Artist() {
		
	}

	public Artist(String name, String description) {
		this.name = name;
		this.description = description;
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


	public List<MusicStyle> getStyles() {
		return styles;
	}

	public void setStyles(List<MusicStyle> styles) {
		this.styles = styles;
	}
	
}
