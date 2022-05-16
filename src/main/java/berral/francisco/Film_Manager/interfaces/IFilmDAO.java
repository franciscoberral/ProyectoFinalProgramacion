package berral.francisco.Film_Manager.interfaces;

import berral.francisco.Film_Manager.model.DataObject.Film;

public interface IFilmDAO {
	boolean insert(Film f);
	boolean update(Film f);
}
