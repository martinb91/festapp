package hu.bandur.boot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="FESTIVALS")
public class Festival {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
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
	@JsonIgnore
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	}
}
