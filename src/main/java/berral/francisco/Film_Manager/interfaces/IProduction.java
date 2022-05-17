package berral.francisco.Film_Manager.interfaces;

/**
 * Interfaz "IProduction" que declara los métodos de "Production"
 * @author Francisco José Berral Zafra
 *
 */
public interface IProduction {
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
	Integer getEpisodes();
	void setEpisodes(Integer episodes);
	Integer getSeasons();
	void setSeasons(Integer seasons);
	String toString();
}
