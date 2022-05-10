package berral.francisco.Film_Manager.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import berral.francisco.Film_Manager.model.DataObject.Cinema;
import berral.francisco.Film_Manager.model.DataObject.Film;
import berral.francisco.Film_Manager.model.DataObject.Proyection;
import berral.francisco.Film_Manager.utils.Connect;

public class ProyectionDAO {
	Connection myConnection = null;
	
	CinemaDAO cDAO= new CinemaDAO();
	FilmDAO fDAO = new FilmDAO();
	
	public boolean insert(Proyection p) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "INSERT INTO Proyection (ID_C, ID_F) VALUES (?,?)";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, p.getC().getID_C());
			sentence.setInt(2, p.getF().getID_F());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Proyection> getAll() {
		List<Proyection> list = new ArrayList<Proyection>();
		myConnection = Connect.getConnect();
		String query = "SELECT ID_C, ID_F FROM Proyection";
		
		try {
			Statement st = myConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Proyection aux = null;
			while(rs.next()) {
				aux = new Proyection();
				Cinema c = cDAO.get(rs.getInt(1));
				aux.setC(c);
				Film f = fDAO.get(rs.getInt(2));
				aux.setF(f);
				list.add(aux);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
