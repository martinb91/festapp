package hu.bandur.mvc.data.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ARTISTS")
public class Artist implements Serializable{

	private String name;
	private String description;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToMany
	private List<MusicStyle> musicStyleList;
	
	public Artist() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public List<MusicStyle> getMusicStyleList() {
		return musicStyleList;
	}

	public void setMusicStyleList(List<MusicStyle> musicStyleList) {
		this.musicStyleList = musicStyleList;
	}
	
}
