package hu.bandur.mvc.data.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Festival {
	private String festivalName;
	private Position place;
	private Date beginDate;
	private Date endDate;
	private String description;
	private int festID;

	public String getFestivalName() {
		return festivalName;
	}

	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}

	public Position getPlace() {
		return place;
	}

	public void setPlace(Position place) {
		this.place = place;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFestID() {
		return festID;
	}

	public void setFestID(int festID) {
		this.festID = festID;
	}

}
