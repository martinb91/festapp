package hu.bandur.boot.dto;

public class FestivalStyleDTO {
	private String style;
	private int id;

	public FestivalStyleDTO() {
		super();
	}

	public FestivalStyleDTO(String style, int id) {
		this.style = style;
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FestivalStyleDTO{" +
				"style='" + style + '\'' +
				", id=" + id +
				'}';
	}
}
