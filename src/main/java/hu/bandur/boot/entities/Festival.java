package hu.bandur.boot.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="FESTIVALS")
public class Festival {
	
	private Festival() {
		super();
	}

	@OneToOne
	private Position position;
	@Column(name = "BEGINDATE")
	private Date beginDate;
	@Column(name = "ENDDATE")
	private Date endDate;
	private String description;
	private String name;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;
	@OneToMany(mappedBy="festival")
	private List<FestivalStyle> styles;

	@OneToMany(mappedBy = "festival")
	private List<Concert> concertList;
	
	public Festival(Position place, Date beginDate, Date endDate, String description, String name) {
		super();
		this.position = place;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.description = description;
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public List<FestivalStyle> getStyles() {
		return styles;
	}

	public void setStyles(List<FestivalStyle> styles) {
		this.styles = styles;
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
				+ ", description=" + description + ", ID=" + ID + ", styles=" + styles + "]";
	}
}
