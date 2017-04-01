package hu.bandur.mvc.data.entities;

import java.util.Date;

public class Festival {
	private String festivalName;
	private String place;
	private Date beginDate;
	private Date endDate;
	private String description;
	private String festID;
	
	
	public String getFestivalName() {
		return festivalName;
	}
	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
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
	public String getFestID() {
		return festID;
	}
	public void setFestID(String festID) {
		this.festID = festID;
	}
	
	

}
