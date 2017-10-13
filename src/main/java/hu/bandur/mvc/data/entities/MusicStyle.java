package hu.bandur.mvc.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MUSICSTYLES")
public class MusicStyle {

	private String style;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//	@ManyToOne(optional = true)
//	@JoinColumn(name = "FK_ARTIST", referencedColumnName = "ID")
	private int fk_artist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_artist() {
		return fk_artist;
	}

	public void setFk_artist(int fk_artist) {
		this.fk_artist = fk_artist;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}


}
