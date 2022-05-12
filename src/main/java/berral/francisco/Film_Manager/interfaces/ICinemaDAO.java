package berral.francisco.Film_Manager.interfaces;

import java.util.List;

import berral.francisco.Film_Manager.model.DataObject.Cinema;

public interface ICinemaDAO {
	boolean insert(Cinema c);
	boolean delete(Cinema c);
	boolean update(Cinema c);
	Cinema get(Integer id);
	List<Cinema> getAll();
}
