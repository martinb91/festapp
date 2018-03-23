package hu.bandur.boot.dto;

import hu.bandur.boot.entities.FestivalStyle;
import hu.bandur.boot.entities.Position;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class FestivalDTO {
	
	private FestivalDTO() {
		super();
	}
	

	private PositionDTO position;
	private Date beginDate;
	private Date endDate;
	private String description;
	private String name;
	private int ID;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	private List<FestivalStyleDTO> festStyleList;
	
	
	public FestivalDTO(PositionDTO place, Date beginDate, Date endDate, String description, String name) {
		super();
		this.position = place;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.description = description;
		this.name = name;
	}

	public List<FestivalStyleDTO> getFestStyleList() {
		return festStyleList;
	}

	public void setFestStyleList(List<FestivalStyleDTO> festStyleList) {
		this.festStyleList = festStyleList;
	}

	public String getName() {
		return name;
	}

	public void setName(String festivalName) {
		this.name = festivalName;
	}

	public PositionDTO getPosition() {
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
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

	@Override
	public String toString() {
		return "FestivalDTO [name=" + name + ", place=" + position + ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", description=" + description + ", festID=" + ID + ", festStyleList=" + festStyleList + "]";
	}
}
