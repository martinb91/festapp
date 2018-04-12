package hu.bandur.boot.dto;

import java.util.Date;
import java.util.List;

public class FestivalDTO {
	private PositionDTO position;
	private Date beginDate;
	private Date endDate;
	private String description;
	private String name;
	private int id;
	private List<FestivalStyleDTO> styles;

	public FestivalDTO() { }

	public FestivalDTO(PositionDTO position, Date beginDate, Date endDate, String description, String name, int id, List<FestivalStyleDTO> styles) {
		this.position = position;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.description = description;
		this.name = name;
		this.id = id;
		this.styles = styles;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<FestivalStyleDTO> getStyles() {
		return styles;
	}

	public void setStyles(List<FestivalStyleDTO> styles) {
		this.styles = styles;
	}

	@Override
	public String toString() {
		return "FestivalDTO{" +
				"position=" + position +
				", beginDate=" + beginDate +
				", endDate=" + endDate +
				", description='" + description + '\'' +
				", name='" + name + '\'' +
				", id=" + id +
				", styles=" + styles +
				'}';
	}
}
