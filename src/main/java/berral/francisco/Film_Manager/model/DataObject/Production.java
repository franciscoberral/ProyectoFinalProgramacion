package berral.francisco.Film_Manager.model.DataObject;

import berral.francisco.Film_Manager.interfaces.IProduction;

/**
 * Clase "Production" que implementa la interfaz "IProduction"
 * @author Francisco José Berral Zafra
 *
 */

public class Production implements IProduction {
	/**
	 * Atributos de la producción
	 */
	private Integer ID_F;
	private String Title;
	private String Type;
	private Integer Duration;
	private Integer Year;
	private String Rating;
	private Integer Episodes;
	private Integer Seasons;
	
	/**
	 * Constructor por defecto
	 */
	public Production() {
	
	}

	/**
	 * Constructor sobrecargado con parámetros de la producción
	 * @param iD_F ID de la producción
	 * @param title Título de la producción
	 * @param type Tipo de producción
	 * @param duration Duración de la producción
	 * @param year Año de la producción
	 * @param rating Clasificación de la producción
	 */
	public Production(Integer iD_F, String title, String type, Integer duration, Integer year, String rating) {
		this.ID_F = iD_F;
		this.Title = title;
		this.Type = type;
		this.Duration = duration;
		this.Year = year;
		this.Rating = rating;
	}
	
	/**
	 * Constructor sobrecargado con parámetros de la producción
	 * @param iD_F ID de la producción
	 * @param title Título de la producción
	 * @param type Tipo de producción
	 * @param duration Duración de la producción
	 * @param year Año de la producción
	 * @param rating Clasificación de la producción
	 * @param episodes Episodios de la producción
	 * @param seasons Temporadas de la producción
	 */
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
	
	/**
	 * Obtener la ID de la producción
	 */
	public Integer getID_F() {
		return ID_F;
	}
	
	/**
	 * Setear la ID de la producción
	 */
	public void setID_F(Integer iD_F) {
		ID_F = iD_F;
	}

	/**
	 * Obtener el título de la producción
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * Setear el título de la producción
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * Obtener el tipo de producción
	 */
	public String getType() {
		return Type;
	}

	/**
	 * Setear el tipo de producción
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * Obtener la duración de la producción
	 */
	public Integer getDuration() {
		return Duration;
	}
	
	/**
	 * Setear la duración de la producción
	 */
	public void setDuration(Integer duration) {
		Duration = duration;
	}

	/**
	 * Obtener el año de producción
	 */
	public Integer getYear() {
		return Year;
	}

	/**
	 * Setear el año de producción
	 */
	public void setYear(Integer year) {
		Year = year;
	}

	/**
	 * Obtener la clasificación de la producción
	 */
	public String getRating() {
		return Rating;
	}

	/**
	 * Setear la clasificación de la producción
	 */
	public void setRating(String rating) {
		Rating = rating;
	}

	/**
	 * Obtener los episodios de la producción
	 */
	public Integer getEpisodes() {
		return Episodes;
	}

	/**
	 * Setear los episodios de la producción
	 */
	public void setEpisodes(Integer episodes) {
		Episodes = episodes;
	}

	/**
	 * Obtener las temporadas de la producción
	 */
	public Integer getSeasons() {
		return Seasons;
	}

	/**
	 * Obtener las temporadas de la producción
	 */
	public void setSeasons(Integer seasons) {
		Seasons = seasons;
	}

	/**
	 * Muestra la información de la producción
	 */
	@Override
	public String toString() {
		return Title ;
	}
}
