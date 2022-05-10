package berral.francisco.Film_Manager.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import berral.francisco.Film_Manager.interfaces.IConnect;

public class Connect implements IConnect {
	private static Connection con;
	private String file = "connection.xml";
	private static Connect _newInstance;
	
	private Connect() {
		DataConnection dc = load();
		
		try {
			load();
			con = DriverManager.getConnection(dc.getServer()+"/"+dc.getDatabase(),dc.getUsername(),dc.getPassword());
		}catch(SQLException e) {
			e.printStackTrace();
			con = null;
		}
	}
	
	public static Connection getConnect() {
		if(_newInstance == null) {
			_newInstance = new Connect();
		}
		return con;
	}
	
	public DataConnection load() {
		DataConnection dataCon = new DataConnection();
		JAXBContext context;
		
		try {
			context = JAXBContext.newInstance(DataConnection.class);
			Unmarshaller um = context.createUnmarshaller();
			DataConnection newDC = (DataConnection) um.unmarshal(new File(file));
			dataCon = newDC;
		}catch(JAXBException e){
			e.printStackTrace();
		}
		return dataCon;
	}
}
