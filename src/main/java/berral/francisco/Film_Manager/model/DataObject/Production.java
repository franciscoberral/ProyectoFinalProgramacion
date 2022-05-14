package berral.francisco.Film_Manager.model.DataObject;

public class Production {
	private Integer ID_F;
	private String Title;
	private String Type;
	private Integer Duration;
	private Integer Year;
	private String Rating;
	private Integer Episodes;
	private Integer Seasons;
	
	public Production() {
	
	}

	public Production(Integer iD_F, String title, String type, Integer duration, Integer year, String rating) {
		this.ID_F = iD_F;
		this.Title = title;
		this.Type = type;
		this.Duration = duration;
		this.Year = year;
		this.Rating = rating;
	}
	
	public Production(Integer iD_F, String title, String type, Integer duration, Integer year, String rating, Integer episodes, Integer seasons) {
		this.ID_F = iD_F;
		this.Title = title;
		this.Type = type;
		this.Duration = duration;
		this.Year = year;
		this.Rating = rating;
		this.Episodes = episodes;
		this.Seasons = seasons;
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

	public Integer getEpisodes() {
		return Episodes;
	}

	public void setEpisodes(Integer episodes) {
		Episodes = episodes;
	}

	public Integer getSeasons() {
		return Seasons;
	}

	public void setSeasons(Integer seasons) {
		Seasons = seasons;
	}

	@Override
	public String toString() {
		return Title ;
	}
}
