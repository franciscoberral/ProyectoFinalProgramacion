package berral.francisco.Film_Manager.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import berral.francisco.Film_Manager.interfaces.ICinemaDAO;
import berral.francisco.Film_Manager.model.DataObject.Cinema;
import berral.francisco.Film_Manager.utils.Connect;

/**
 * Clase "CinemaDAO" que implementa la interfaz "ICinemaDAO"
 * @author Francisco José Berral Zafra
 *
 */
public class CinemaDAO implements ICinemaDAO {
	Connection myConnection = null;

	/**
	 * Método que permite insertar un cine en la BBDD
	 * @param c Cine a insertar
	 * @return Si el cine es insertado o no
	 */
	public boolean insert(Cinema c) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "INSERT INTO Cinema (ID_C, Name, Address, Location, Rooms, Capacity) VALUES (?,?,?,?,?,?)";

		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, c.getID_C());
			sentence.setString(2, c.getName());
			sentence.setString(3, c.getAddress());
			sentence.setString(4, c.getLocation());
			sentence.setInt(5, c.getRooms());
			sentence.setInt(6, c.getCapacity());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Método que permite eliminar un cine en la BBDD
	 * @param c Cine a borrar
	 * @return Si el cine es borrado o no
	 */
	public boolean delete(Cinema c) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "DELETE FROM Cinema WHERE ID_C=?";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, c.getID_C());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Método que permite actualizar un cine en la BBDD
	 * @param c Cine a actualizar
	 * @return Si el cine es actualizado o no
	 */
	public boolean update(Cinema c) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "UPDATE Cinema SET Name=?, Address=?, Location=?, Rooms=?, Capacity=? WHERE ID_C=?";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setString(1, c.getName());
			sentence.setString(2, c.getAddress());
			sentence.setString(3, c.getLocation());
			sentence.setInt(4, c.getRooms());
			sentence.setInt(5, c.getCapacity());
			sentence.setInt(6, c.getID_C());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Método que obtener un cine por su ID
	 * @param id ID del cine a buscar
	 * @return El cine encontrado o null si no se ha encontrado
	 */
	public Cinema get(Integer id) {
		Cinema c = null;
		myConnection = Connect.getConnect();
		String query = "SELECT ID_C, Name, Address, Location, Rooms, Capacity FROM Cinema WHERE ID_C=?";
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, id);
			ResultSet rs = sentence.executeQuery();
			if(rs.next()) {
				c = new Cinema();
				c.setID_C(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setAddress(rs.getString(3));
				c.setLocation(rs.getString(4));
				c.setRooms(rs.getInt(5));
				c.setCapacity(rs.getInt(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * Método que obtener un cine por su nombre
	 * @param name Nombre del cine a buscar
	 * @return El cine encontrado o null si no se ha encontrado
	 */
	public Cinema get(String name) {
		Cinema c = null;
		myConnection = Connect.getConnect();
		String query = "SELECT ID_C, Name, Address, Location, Rooms, Capacity FROM Cinema WHERE Name=?";
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setString(1, name);
			ResultSet rs = sentence.executeQuery();
			if(rs.next()) {
				c = new Cinema();
				c.setID_C(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setAddress(rs.getString(3));
				c.setLocation(rs.getString(4));
				c.setRooms(rs.getInt(5));
				c.setCapacity(rs.getInt(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * Método para guardar todos los cines en una lista
	 * @return Lista con los cines añadidos
	 */
	public List<Cinema> getAll() {
		List<Cinema> list = new ArrayList<Cinema>();
		myConnection = Connect.getConnect();
		String query = "SELECT ID_C, Name, Address, Location, Rooms, Capacity FROM Cinema";
		
		try {
			Statement st = myConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Cinema aux = null;
			while(rs.next()) {
				aux = new Cinema();
				aux.setID_C(rs.getInt(1));
				aux.setName(rs.getString(2));
				aux.setAddress(rs.getString(3));
				aux.setLocation(rs.getString(4));
				aux.setRooms(rs.getInt(5));
				aux.setCapacity(rs.getInt(6));
				list.add(aux);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
