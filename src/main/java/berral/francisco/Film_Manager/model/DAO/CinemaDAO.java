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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CinemaDAO implements ICinemaDAO{
	Connection myConnection = null;

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

	public boolean delete(Integer id) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "DELETE FROM Cinema WHERE ID_C = '" +id+ "'";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

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
	
	public Cinema get(Integer id) {
		Cinema c = null;
		myConnection = Connect.getConnect();
		String query = "SELECT ID_C, Name, Address, Location, Rooms, Capacity FROM Cinema WHERE ID_C=?";
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, id);
			ResultSet rs = sentence.executeQuery();
			c = new Cinema();
			rs.next();
			c.setID_C(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setAddress(rs.getString(3));
			c.setLocation(rs.getString(4));
			c.setRooms(rs.getInt(5));
			c.setCapacity(rs.getInt(6));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}

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
	
	public ObservableList<Cinema> getCinemas() {
		ObservableList<Cinema> obs = FXCollections.observableArrayList();
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
				obs.add(aux);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return obs;
	}
}
