package berral.francisco.Film_Manager.model.DataObject;

import berral.francisco.Film_Manager.interfaces.ISerie;

/**
 * Clase "Serie" que implementa la interfaz "ISerie" y hereda de "Producción"
 * @author Francisco José Berral Zafra
 *
 */
public class Serie extends Production implements ISerie {
	/**
	 * Constructor por defecto de serie
	 */
	public Serie() {
		super();
	}
	
	/**
	 * Constructor con parámetros de la serie heredados de producción
	 * @param iD_F ID de la serie
	 * @param title Título de la serie
	 * @param type Tipo de serie
	 * @param duration Duración de la serie
	 * @param year Año de producción de la serie
	 * @param rating Clasificación de la serie
	 * @param episodes Episodios de la serie
	 * @param seasons Temporadas de la serie
	 */
	public Serie(Integer iD_F, String title, String type, Integer duration, Integer year, String rating, Integer episodes, Integer seasons) {
		super(iD_F, title, type, duration, year, rating, episodes, seasons);
	}

	/**
	 * Muestra la información de la serie
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	
}
