package berral.francisco.Film_Manager.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import berral.francisco.Film_Manager.interfaces.IFilmDAO;
import berral.francisco.Film_Manager.model.DataObject.Film;
import berral.francisco.Film_Manager.utils.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FilmDAO implements IFilmDAO{
	Connection myConnection = null;

	public boolean insert(Film f) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "INSERT INTO Film (ID_F, Title, Type, Duration, Year, Rating) VALUES (?,?,?,?,?,?)";
		
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

	public boolean delete(Film f) {
		boolean result = false;
		Integer id = f.getID_F();
		myConnection = Connect.getConnect();
		String query = "DELETE FROM Film WHERE ID_F = '" +id+ "'";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean update(Film f) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "UPDATE Film SET Title=?, Type=?, Duration=?, Year=?, Rating=? WHERE ID_F=?";
		
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
	
	public Film get(Integer id) {
		Film f = null;
		myConnection = Connect.getConnect();
		String query = "SELECT ID_F, Title, Type, Duration, Year, Rating FROM Film WHERE ID_F=?";
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, id);
			ResultSet rs = sentence.executeQuery();
			f = new Film();
			rs.next();
			f.setID_F(rs.getInt(1));
			f.setTitle(rs.getString(2));
			f.setType(rs.getString(3));
			f.setDuration(rs.getInt(4));
			f.setYear(rs.getInt(5));
			f.setRating(rs.getString(6));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Film> getAll() {
		List<Film> list = new ArrayList<Film>();
		myConnection = Connect.getConnect();
		String query = "SELECT ID_F, Title, Type, Duration, Year, Rating FROM Film";
		
		try {
			Statement st = myConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Film aux = null;
			while(rs.next()) {
				aux = new Film();
				aux.setID_F(rs.getInt(1));
				aux.setTitle(rs.getString(2));
				aux.setType(rs.getString(3));
				aux.setDuration(rs.getInt(4));
				aux.setYear(rs.getInt(5));
				aux.setRating(rs.getString(6));
				list.add(aux);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ObservableList<Film> getFilms() {
		ObservableList<Film> obs = FXCollections.observableArrayList();
		myConnection = Connect.getConnect();
		String query = "SELECT ID_F, Title, Type, Duration, Year, Rating FROM Film";
		
		try {
			Statement st = myConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Film aux = null;
			while(rs.next()) {
				aux = new Film();
				aux.setID_F(rs.getInt(1));
				aux.setTitle(rs.getString(2));
				aux.setType(rs.getString(3));
				aux.setDuration(rs.getInt(4));
				aux.setYear(rs.getInt(5));
				aux.setRating(rs.getString(6));
				obs.add(aux);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return obs;
	}
}
