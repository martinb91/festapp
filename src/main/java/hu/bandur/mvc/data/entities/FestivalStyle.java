package hu.bandur.mvc.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FESTIVALSTYLES")
public class FestivalStyle {

	private String style;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//	@ManyToOne
//	private Festival festival;

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
