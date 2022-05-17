package berral.francisco.Film_Manager.model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import berral.francisco.Film_Manager.interfaces.IProyectionDAO;
import berral.francisco.Film_Manager.model.DataObject.Cinema;
import berral.francisco.Film_Manager.model.DataObject.Production;
import berral.francisco.Film_Manager.model.DataObject.Proyection;
import berral.francisco.Film_Manager.utils.Connect;

/**
 * Clase "ProyectionDAO" que implementa la interfaz "IProyectionDAO"
 * @author Francisco José Berral Zafra
 *
 */
public class ProyectionDAO implements IProyectionDAO {
	Connection myConnection = null;
	
	CinemaDAO cDAO = new CinemaDAO();
	
	/**
	 * Método que permite insertar una proyección en la BBDD
	 * @param p Proyección a insertar
	 * @return Si la proyección es insertada o no
	 */
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
	
	/**
	 * Método que permite eliminar una proyección en la BBDD
	 * @param p Proyección a borrar
	 * @return Si la proyección es borrada o no
	 */
	public boolean delete(Proyection p) {
		boolean result = false;
		myConnection = Connect.getConnect();
		String query = "DELETE FROM Proyection WHERE (ID_C=? AND ID_F=? AND StartDate=?)";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, p.getC().getID_C());
			sentence.setInt(2, p.getP().getID_F());
			sentence.setDate(3, Date.valueOf(p.getStartDate()));
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
		String query = "UPDATE Proyection SET FinishDate=? WHERE (ID_C=? AND ID_F=? AND StartDate=?)";
		
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setDate(1, Date.valueOf(p.getFinishDate()));
			sentence.setInt(2, p.getC().getID_C());
			sentence.setInt(3, p.getP().getID_F());
			sentence.setDate(4, Date.valueOf(p.getStartDate()));
			sentence.executeUpdate();
			result=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Método que obtener una proyección por la ID del cine, la ID de la producción y la fecha de inicio de la proyección
	 * @param iD_C ID del cine
	 * @param iD_F ID de la producción
	 * @param start Fecha de la proyección
	 * @return La proyección encontrada o null si no se ha encontrado
	 */
	public Proyection get(Integer iD_C, Integer iD_F, LocalDate start) {
		Proyection p = null;
		String query = "SELECT ID_C, ID_F, StartDate, FinishDate FROM Proyection WHERE (ID_C=? AND ID_F=? AND StartDate=?)";
		try {
			PreparedStatement sentence = myConnection.prepareStatement(query);
			sentence.setInt(1, iD_C);
			sentence.setInt(2, iD_F);
			sentence.setDate(3, Date.valueOf(start));
			ResultSet rs = sentence.executeQuery();
			if(rs.next()) {
				p = new Proyection();
				Cinema c = cDAO.get(rs.getInt(1));
				p.setC(c);
				Production pr = ProductionDAO.get(rs.getInt(2));
				p.setP(pr);
				p.setStartDate(rs.getDate(3).toLocalDate());
				p.setFinishDate(rs.getDate(4).toLocalDate());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Método para guardar todas las proyecciones en una lista
	 * @return Lista con las proyecciones añadidas
	 */
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
