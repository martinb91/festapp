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
	@Column(name = "BEGINDATE")
	private Date beginDate;

	public Concert(Artist artist, Festival festival, Date beginDate) {

		this.artist = artist;
		this.festival = festival;
		this.beginDate = beginDate;
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Override
	public String toString() {
		return "Concert{" +
				"artist=" + artist +
				", festival=" + festival +
				", id=" + id +
				", beginDate=" + beginDate +
				'}';
	}
}
