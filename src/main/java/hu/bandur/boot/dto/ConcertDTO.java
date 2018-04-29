package hu.bandur.boot.dto;

import java.util.Date;

public class ConcertDTO {

	private ArtistDTO artist;
	private FestivalDTO festival;
	private int id;
	private Date beginDate;

	public ConcertDTO(ArtistDTO artist, FestivalDTO festival, Date begin, int id) {

		this.artist = artist;
		this.festival = festival;
		this.beginDate = begin;
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Override
	public String toString() {
		return "ConcertDTO{" +
				"artist=" + artist +
				", festival=" + festival +
				", id=" + id +
				", beginDate=" + beginDate +
				'}';
	}
}
