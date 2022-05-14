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

public abstract class ProductionDAO<T> {
	private static Connection myConnection = null;

	public abstract boolean insert(T obj);

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

	public abstract boolean update(T obj);
	
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
