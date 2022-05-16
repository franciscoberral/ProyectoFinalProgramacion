package berral.francisco.Film_Manager.interfaces;

import berral.francisco.Film_Manager.model.DataObject.Serie;

public interface ISerieDAO {
	boolean insert(Serie s);
	boolean update(Serie s);
}
