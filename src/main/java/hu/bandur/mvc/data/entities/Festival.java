package hu.bandur.mvc.data.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
	
	private Festival() {
		super();
	}
	
	
	@OneToOne
	private Position position;
	private Date beginDate;
	private Date endDate;
	private String description;
	private String name;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int festID;
	@OneToMany(mappedBy="festival")
	private List<FestivalStyle> festStyleList;
	
	
	public Festival(Position place, Date beginDate, Date endDate, String description, String name) {
		super();
		this.position = place;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.description = description;
		this.name = name;
	}

	public List<FestivalStyle> getFestStyleList() {
		return festStyleList;
	}

	public void setFestStyleList(List<FestivalStyle> festStyleList) {
		this.festStyleList = festStyleList;
	}

	public String getName() {
		return name;
	}

	public void setName(String festivalName) {
		this.name = festivalName;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
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
		return "Festival [name=" + name + ", place=" + position + ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", description=" + description + ", festID=" + festID + ", festStyleList=" + festStyleList + "]";
	}
}
