package berral.francisco.Film_Manager.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import berral.francisco.Film_Manager.interfaces.IFilmDAO;
import berral.francisco.Film_Manager.model.DataObject.Film;
import berral.francisco.Film_Manager.utils.Connect;

/**
 * Clase "FilmDAO" que implementa la interfaz "IFilmDAO" y hereda de "ProductionDAO"
 * @author Francisco José Berral Zafra
 *
 */
public class FilmDAO extends ProductionDAO<Film> implements IFilmDAO {
	private static Connection myConnection = null;

	/**
	 * Método que permite insertar una película en la producción
	 * @param f Película a insertar
	 * @return Si la película es insertado o no
	 */
	@Override
	public boolean insert(Film f) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "INSERT INTO Production (ID_F, Title, Type, Duration, Year, Rating, Episodes, Seasons) VALUES (?,?,?,?,?,?,'0','0')";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, f.getID_F());
			sentence.setString(2, f.getTitle());
			sentence.setString(3, f.getType());
			sentence.setInt(4, f.getDuration());
			sentence.setInt(5, f.getYear());
			sentence.setString(6, f.getRating());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Método que permite actualizar una película de la producción
	 * @param f Película a actualizar
	 * @return Si la película es actualizada o no
	 */
	@Override
	public boolean update(Film f) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "UPDATE Production SET Title=?, Type=?, Duration=?, Year=?, Rating=? WHERE ID_F=?";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setString(1, f.getTitle());
			sentence.setString(2, f.getType());
			sentence.setInt(3, f.getDuration());
			sentence.setInt(4, f.getYear());
			sentence.setString(5, f.getRating());
			sentence.setInt(6, f.getID_F());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
