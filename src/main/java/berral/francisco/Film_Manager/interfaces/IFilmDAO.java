package berral.francisco.Film_Manager.interfaces;

import berral.francisco.Film_Manager.model.DataObject.Film;

/**
 * Interfaz "IFilmDAO" que declara los métodos de "FilmDAO"
 * @author Francisco José Berral Zafra
 *
 */
public interface IFilmDAO {
	boolean insert(Film f);
	boolean update(Film f);
}
