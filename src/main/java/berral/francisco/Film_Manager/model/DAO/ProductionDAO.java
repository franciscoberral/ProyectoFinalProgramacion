package berral.francisco.Film_Manager.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import berral.francisco.Film_Manager.model.DataObject.Film;
import berral.francisco.Film_Manager.model.DataObject.Production;
import berral.francisco.Film_Manager.utils.Connect;

/**
 * Clase "ProductionDAO" que implementa la interfaz "ICinemaDAO" y hace uso de genéricos
 * @author Francisco José Berral Zafra
 *
 */
public abstract class ProductionDAO<T> {
	private static Connection myConnection = null;

	/**
	 * Método abstracto que permite insertar un objeto genérico de una clase hija en la BBDD
	 * @param obj Objeto de tipo genérico a insertar
	 * @return Si la producción es insertada o no
	 */
	public abstract boolean insert(T obj);

	/**
	 * Método que permite eliminar una producción de la BBDD
	 * @param p Producción a eliminar
	 * @return Si la producción es borrada o no
	 */
	public static boolean delete(Production p) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "DELETE FROM Production WHERE ID_F=?";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, p.getID_F());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Método abstracto que permite actualizar un objeto genérico de una clase hija en la BBDD
	 * @param obj Objeto de tipo genérico a actualizar
	 * @return Si la producción es actualizada o no
	 */
	public abstract boolean update(T obj);
	
	/**
	 * Método que obtener una producción por su ID
	 * @param id ID de la producción a buscar
	 * @return La producción encontrada o null si no se ha encontrado
	 */
	public static Production get(Integer id) {
		Production p = null;
		myConnection = Connect.getConnect();
		String query = "SELECT ID_F, Title, Type, Duration, Year, Rating, Episodes, Seasons FROM Production WHERE ID_F=?";
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, id);
			ResultSet rs = sentence.executeQuery();
			if(rs.next()) {
				p = new Production();
				p.setID_F(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setType(rs.getString(3));
				p.setDuration(rs.getInt(4));
				p.setYear(rs.getInt(5));
				p.setRating(rs.getString(6));
				p.setEpisodes(rs.getInt(7));
				p.setSeasons(rs.getInt(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * Método que obtener una producción por su título
	 * @param title Título de la producción a buscar
	 * @return La producción encontrada o null si no se ha encontrado
	 */
	public static Production get(String title) {
		Production p = null;
		myConnection = Connect.getConnect();
		String query = "SELECT ID_F, Title, Type, Duration, Year, Rating, Episodes, Seasons FROM Production WHERE Title=?";
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setString(1, title);
			ResultSet rs = sentence.executeQuery();
			if(rs.next()) {
				p = new Production();
				p.setID_F(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setType(rs.getString(3));
				p.setDuration(rs.getInt(4));
				p.setYear(rs.getInt(5));
				p.setRating(rs.getString(6));
				p.setEpisodes(rs.getInt(7));
				p.setSeasons(rs.getInt(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Método para guardar todas las producciones en una lista
	 * @return Lista con las producciones añadidas
	 */
	public static List<Production> getAll() {
		List<Production> list = new ArrayList<Production>();
		myConnection = Connect.getConnect();
		String query = "SELECT ID_F, Title, Type, Duration, Year, Rating, Episodes, Seasons FROM Production";
		
		try {
			Statement st = myConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Production aux = null;
			while(rs.next()) {
				aux = new Film();
				aux.setID_F(rs.getInt(1));
				aux.setTitle(rs.getString(2));
				aux.setType(rs.getString(3));
				aux.setDuration(rs.getInt(4));
				aux.setYear(rs.getInt(5));
				aux.setRating(rs.getString(6));
				aux.setEpisodes(rs.getInt(7));
				aux.setSeasons(rs.getInt(8));
				list.add(aux);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Método para guardar todas las películas en una lista
	 * @return Lista con las películas añadidas
	 */
	public static List<Production> getAllFilms() {
		List<Production> list = new ArrayList<Production>();
		myConnection = Connect.getConnect();
		String query = "SELECT ID_F, Title, Type, Duration, Year, Rating, Episodes, Seasons FROM Production WHERE Seasons = 0";
		
		try {
			Statement st = myConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Production aux = null;
			while(rs.next()) {
				aux = new Film();
				aux.setID_F(rs.getInt(1));
				aux.setTitle(rs.getString(2));
				aux.setType(rs.getString(3));
				aux.setDuration(rs.getInt(4));
				aux.setYear(rs.getInt(5));
				aux.setRating(rs.getString(6));
				aux.setEpisodes(rs.getInt(7));
				aux.setSeasons(rs.getInt(8));
				list.add(aux);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Método para guardar todas las series en una lista
	 * @return Lista con las series añadidas
	 */
	public static List<Production> getAllSeries() {
		List<Production> list = new ArrayList<Production>();
		myConnection = Connect.getConnect();
		String query = "SELECT ID_F, Title, Type, Duration, Year, Rating, Episodes, Seasons FROM Production WHERE Seasons > 0";
		
		try {
			Statement st = myConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Production aux = null;
			while(rs.next()) {
				aux = new Film();
				aux.setID_F(rs.getInt(1));
				aux.setTitle(rs.getString(2));
				aux.setType(rs.getString(3));
				aux.setDuration(rs.getInt(4));
				aux.setYear(rs.getInt(5));
				aux.setRating(rs.getString(6));
				aux.setEpisodes(rs.getInt(7));
				aux.setSeasons(rs.getInt(8));
				list.add(aux);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
