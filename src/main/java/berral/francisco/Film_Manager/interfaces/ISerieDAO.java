package berral.francisco.Film_Manager.interfaces;

import berral.francisco.Film_Manager.model.DataObject.Serie;

/**
 * Interfaz "ISerieDAO" que declara los métodos de "SerieDAO"
 * @author Francisco José Berral Zafra
 *
 */
public interface ISerieDAO {
	boolean insert(Serie s);
	boolean update(Serie s);
}
