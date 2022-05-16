package berral.francisco.Film_Manager.interfaces;

import java.util.List;

import berral.francisco.Film_Manager.model.DataObject.Production;

public interface IProductionDAO<T> {
	boolean insert(T obj);
	boolean delete(Production p);
	boolean update(T obj);
	Production get(Integer id);
	Production get(String title);
	List<Production> getAll();
	List<Production> getAllFilms();
	List<Production> getAllSeries();
}
