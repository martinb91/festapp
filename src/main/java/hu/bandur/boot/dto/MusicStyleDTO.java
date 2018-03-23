package hu.bandur.boot.dto;

import hu.bandur.boot.entities.Artist;

import java.io.Serializable;

public class MusicStyleDTO implements Serializable{

	private int id;
	private String style;
	private Artist artist;

	public MusicStyleDTO() {

	}

	public MusicStyleDTO( String style, Artist artist){
		this.style = style;
		this.artist = artist;
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
