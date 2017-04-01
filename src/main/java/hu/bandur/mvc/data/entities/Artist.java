package hu.bandur.mvc.data.entities;

import java.util.List;

public class Artist {

	private String name;
	private String description;
	private int id;
	private List<MusicStyle> musicStyleList;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<MusicStyle> getMusicStyleList() {
		return musicStyleList;
	}

	public void setMusicStyleList(List<MusicStyle> musicStyleList) {
		this.musicStyleList = musicStyleList;
	}
	
}
