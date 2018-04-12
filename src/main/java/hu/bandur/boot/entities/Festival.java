package hu.bandur.boot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="FESTIVALS")
public class Festival {
<<<<<<< HEAD
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
=======
	
	private Festival() {
		super();
	}

	@OneToOne
	private Position position;
>>>>>>> 33f7f8f21c8e1f4ec6997fed5deee1ab71089041
	@Column(name = "BEGINDATE")
	private Date beginDate;
	@Column(name = "ENDDATE")
	private Date endDate;
	private String description;
	private String name;
	@OneToOne
	private Position position;
	@OneToMany(mappedBy="festival")
	private List<FestivalStyle> styles;
<<<<<<< HEAD
	@JsonIgnore
=======

>>>>>>> 33f7f8f21c8e1f4ec6997fed5deee1ab71089041
	@OneToMany(mappedBy = "festival")
	private List<Concert> concertList;

	private Festival() { }

	public Festival(Position place, Date beginDate, Date endDate, String description, String name) {
		this.position = place;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.description = description;
		this.name = name;
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

<<<<<<< HEAD
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
=======
	public List<FestivalStyle> getStyles() {
		return styles;
	}

	public void setStyles(List<FestivalStyle> styles) {
		this.styles = styles;
>>>>>>> 33f7f8f21c8e1f4ec6997fed5deee1ab71089041
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<FestivalStyle> getStyles() {
		return styles;
	}

	public void setStyles(List<FestivalStyle> styles) {
		this.styles = styles;
	}

	public List<Concert> getConcertList() {
		return concertList;
	}

	public void setConcertList(List<Concert> concertList) {
		this.concertList = concertList;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Festival{" +
				"id=" + id +
				", beginDate=" + beginDate +
				", endDate=" + endDate +
				", description='" + description + '\'' +
				", name='" + name + '\'' +
				", position=" + position +
				", styles=" + styles +
				", concertList=" + concertList +
				'}';
=======
		return "Festival [name=" + name + ", place=" + position + ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", description=" + description + ", ID=" + ID + ", styles=" + styles + "]";
>>>>>>> 33f7f8f21c8e1f4ec6997fed5deee1ab71089041
	}
}
