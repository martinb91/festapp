package hu.bandur.boot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="MUSICSTYLES")
public class MusicStyle implements Serializable{

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String style;
	@JsonIgnore
	@ManyToOne
	private Artist artist;
	
	private MusicStyle() {
		
	}

    public MusicStyle(String style, Artist artist) {
		this.style = style;
		this.artist=artist;
    }

	@Override
	public String toString() {
		return "MusicStyle{" +
				"id=" + id +
				", style='" + style + '\'' +
				'}';
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}


}
