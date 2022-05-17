package berral.francisco.Film_Manager.interfaces;

import java.util.List;

import berral.francisco.Film_Manager.model.DataObject.Cinema;

/**
 * Interfaz "ICinemaDAO" que declara los métodos de "CinemaDAO"
 * @author Francisco José Berral Zafra
 *
 */
public interface ICinemaDAO {
	boolean insert(Cinema c);
	boolean delete(Cinema c);
	boolean update(Cinema c);
	Cinema get(Integer id);
	Cinema get(String name);
	List<Cinema> getAll();
}
