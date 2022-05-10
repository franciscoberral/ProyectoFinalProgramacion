package berral.francisco.Film_Manager.interfaces;

public interface IFilm {
	Integer getID_F();
	void setID_F(Integer iD_F);
	String getTitle();
	void setTitle(String title);
	String getType();
	void setType(String type);
	Integer getDuration();
	void setDuration(Integer duration);
	Integer getYear();
	void setYear(Integer year);
	String getRating();
	void setRating(String rating);
	String toString();
}
