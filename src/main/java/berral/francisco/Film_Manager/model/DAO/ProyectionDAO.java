package berral.francisco.Film_Manager.model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import berral.francisco.Film_Manager.model.DataObject.Cinema;
import berral.francisco.Film_Manager.model.DataObject.Production;
import berral.francisco.Film_Manager.model.DataObject.Proyection;
import berral.francisco.Film_Manager.utils.Connect;

public class ProyectionDAO {
	Connection myConnection = null;
	
	CinemaDAO cDAO = new CinemaDAO();
	
	public boolean insert(Proyection p) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "INSERT INTO Proyection (ID_C, ID_F, StartDate, FinishDate) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, p.getC().getID_C());
			sentence.setInt(2, p.getP().getID_F());
			sentence.setDate(3, Date.valueOf(p.getStartDate()));
			sentence.setDate(4, Date.valueOf(p.getFinishDate()));
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean delete(Proyection p) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "DELETE FROM Proyection WHERE (ID_C=? AND ID_F=?)";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, p.getC().getID_C());
			sentence.setInt(2, p.getP().getID_F());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean update(Proyection p) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "UPDATE Proyection SET StartDate=?, FinishDate=? WHERE ID_C=? AND ID_F=?";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setDate(1, Date.valueOf(p.getStartDate()));
			sentence.setDate(2, Date.valueOf(p.getFinishDate()));
			sentence.setInt(3, p.getC().getID_C());
			sentence.setInt(4, p.getP().getID_F());
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Proyection get(Integer iD_C, Integer iD_F) {
		Proyection p = null;
		String query = "SELECT ID_C, ID_F, StartDate, FinishDate FROM Proyection WHERE ID_C=? AND ID_F=?";
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, iD_C);
			sentence.setInt(2, iD_F);
			ResultSet rs = sentence.executeQuery();
			p = new Proyection();
			rs.next();
			Cinema c = cDAO.get(rs.getInt(1));
			p.setC(c);
			Production pr = ProductionDAO.get(rs.getInt(2));
			p.setP(pr);
			p.setStartDate(rs.getDate(3).toLocalDate());
			p.setFinishDate(rs.getDate(4).toLocalDate());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public List<Proyection> getAll() {
		List<Proyection> list = new ArrayList<Proyection>();
		myConnection = Connect.getConnect();
		String query = "SELECT ID_C, ID_F, StartDate, FinishDate FROM Proyection";
		
		try {
			Statement st = myConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
			Proyection aux = null;
			while(rs.next()) {
				aux = new Proyection();
				Cinema c = cDAO.get(rs.getInt(1));
				aux.setC(c);
				Production p = ProductionDAO.get(rs.getInt(2));
				aux.setP(p);
				aux.setStartDate(rs.getDate(3).toLocalDate());
				aux.setFinishDate(rs.getDate(4).toLocalDate());
				list.add(aux);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
