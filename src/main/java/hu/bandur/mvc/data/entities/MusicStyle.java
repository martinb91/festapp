package hu.bandur.mvc.data.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MUSICSTYLES")
public class MusicStyle implements Serializable{

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String style;
	@ManyToOne
	private Artist artist;

	public int getId() {
		return id;
	}
	
	private MusicStyle() {
		
	}
	
	public MusicStyle(int a) {
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public Artist getFk_artist() {
		return artist;
	}

	public void setFk_artist(Artist artist) {
		this.artist = artist;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}


}
