package hu.bandur.boot.dto;

import java.util.Date;

public class ConcertDTO {

	private ArtistDTO artist;
	private FestivalDTO festival;
	private int id;
	private Date begin;

	public ConcertDTO(ArtistDTO artist, FestivalDTO festival, Date begin, int id) {

		this.artist = artist;
		this.festival = festival;
		this.begin = begin;
		this.id= id;
	}
	private ConcertDTO() {
	}

	public ArtistDTO getArtist() {
		return artist;
	}

	public void setArtist(ArtistDTO artist) {
		this.artist = artist;
	}

	public FestivalDTO getFestival() {
		return festival;
	}

	public void setFestival(FestivalDTO festival) {
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
