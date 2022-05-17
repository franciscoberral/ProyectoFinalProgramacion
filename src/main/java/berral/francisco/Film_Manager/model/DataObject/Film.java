package berral.francisco.Film_Manager.model.DataObject;

import berral.francisco.Film_Manager.interfaces.IFilm;

/**
 * Clase "Cinema" que implementa la interfaz "IFilm" y hereda de "Production"
 * @author Francisco José Berral Zafra
 *
 */
public class Film extends Production implements IFilm {
	/**
	 * Constructor por defecto de película
	 */
	public Film() {
		super();
	}

	/**
	 * Constructor con parámetros de la película heredados de producción
	 * @param iD_F ID de la película
	 * @param title Título de la película
	 * @param type Tipo de película
	 * @param duration Duración de la película
	 * @param year Año de producción de la película
	 * @param rating Clasificación de la película
	 */
	public Film(Integer iD_F, String title, String type, Integer duration, Integer year, String rating) {
		super(iD_F, title, type, duration, year, rating);
	}

	/**
	 * Muestra la información de la película
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
