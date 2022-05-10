package berral.francisco.Film_Manager.interfaces;

import java.util.List;

import berral.francisco.Film_Manager.model.DataObject.Film;

public interface IFilmDAO {
	boolean insert(Film f);
	boolean delete(Integer id);
	boolean update(Film f);
	Film get(Integer id);
	List<Film> getAll();
}
