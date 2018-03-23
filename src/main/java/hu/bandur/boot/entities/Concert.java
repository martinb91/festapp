package hu.bandur.boot.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CONCERTS")
public class Concert {
	
	@ManyToOne
	private Artist artist;
	@ManyToOne
	private Festival festival;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date begin;

	public Concert(Artist artist, Festival festival, Date begin) {

		this.artist = artist;
		this.festival = festival;
		this.begin = begin;
	}
	private Concert() {
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

}
