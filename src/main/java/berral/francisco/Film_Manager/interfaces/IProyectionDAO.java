package berral.francisco.Film_Manager.interfaces;

import java.time.LocalDate;
import java.util.List;

import berral.francisco.Film_Manager.model.DataObject.Proyection;

public interface IProyectionDAO {
	boolean insert(Proyection p);
	boolean delete(Proyection p);
	boolean update(Proyection p);
	Proyection get(Integer iD_C, Integer iD_F, LocalDate start);
	List<Proyection> getAll();
}
