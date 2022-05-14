package berral.francisco.Film_Manager.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import berral.francisco.Film_Manager.model.DataObject.Serie;
import berral.francisco.Film_Manager.utils.Connect;

public class SerieDAO extends ProductionDAO<Serie> {
	private static Connection myConnection = null;

	@Override
	public boolean insert(Serie s) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "INSERT INTO Production (ID_F, Title, Type, Duration, Year, Rating, Episodes, Seasons) VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, s.getID_F());
			sentence.setString(2, s.getTitle());
			sentence.setString(3, s.getType());
			sentence.setInt(4, s.getDuration());
			sentence.setInt(5, s.getYear());
			sentence.setString(6, s.getRating());
			sentence.setInt(7, s.getEpisodes());
			sentence.setInt(8, s.getSeasons());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean update(Serie s) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "UPDATE Production SET Title=?, Type=?, Duration=?, Year=?, Rating=?, Episodes=?, Seasons=? WHERE ID_F=?";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setString(1, s.getTitle());
			sentence.setString(2, s.getType());
			sentence.setInt(3, s.getDuration());
			sentence.setInt(4, s.getYear());
			sentence.setString(5, s.getRating());
			sentence.setInt(6, s.getEpisodes());
			sentence.setInt(7, s.getSeasons());
			sentence.setInt(8, s.getID_F());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
