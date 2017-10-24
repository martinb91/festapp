package hu.bandur.mvc.data.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FESTIVALS")
public class Festival {
	private String name;
	@OneToOne
	private Position place;
	private Date beginDate;
	private Date endDate;
	private String description;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int festID;
	@OneToMany
	private List<FestivalStyle> festStyleList;
	
	
	public String getFestivalName() {
		return name;
	}

	public void setFestivalName(String festivalName) {
		this.name = festivalName;
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
