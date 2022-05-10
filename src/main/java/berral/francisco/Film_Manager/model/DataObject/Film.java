package berral.francisco.Film_Manager.model.DataObject;

import berral.francisco.Film_Manager.interfaces.IFilm;

public class Film implements IFilm {
	private Integer ID_F;
	private String Title;
	private String Type;
	private Integer Duration;
	private Integer Year;
	private String Rating;
	
	public Film() {
		this.ID_F = null;
		this.Title = "";
		this.Type = "";
		this.Duration = null;
		this.Year = null;
		this.Rating = "";
	}

	public Film(Integer iD_F, String title, String type, Integer duration, Integer year, String rating) {
		this.ID_F = iD_F;
		this.Title = title;
		this.Type = type;
		this.Duration = duration;
		this.Year = year;
		this.Rating = rating;
	}
	
	public Integer getID_F() {
		return ID_F;
	}

	public void setID_F(Integer iD_F) {
		ID_F = iD_F;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Integer getDuration() {
		return Duration;
	}

	public void setDuration(Integer duration) {
		Duration = duration;
	}

	public Integer getYear() {
		return Year;
	}

	public void setYear(Integer year) {
		Year = year;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	@Override
	public String toString() {
		return "Film [ID_F=" + ID_F + ", Title=" + Title + ", Type=" + Type + ", Duration=" + Duration + ", Year="
				+ Year + ", Rating=" + Rating + "]";
	}
}
