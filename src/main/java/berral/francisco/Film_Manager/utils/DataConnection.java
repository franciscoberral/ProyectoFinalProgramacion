package berral.francisco.Film_Manager.utils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import berral.francisco.Film_Manager.interfaces.IDataConnection;

@XmlRootElement(name="Connection")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataConnection implements IDataConnection {
	private String Server;
	private String Database;
	private String Username;
	private String Password;
	
	public DataConnection() {
		this.Server = "";
		this.Database = "";
		this.Username = "";
		this.Password = "";
	}

	public DataConnection(String server, String database, String username, String password) {
		Server = server;
		Database = database;
		Username = username;
		Password = password;
	}

	public String getServer() {
		return Server;
	}

	public void setServer(String server) {
		Server = server;
	}

	public String getDatabase() {
		return Database;
	}

	public void setDatabase(String database) {
		Database = database;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "DataConnection [Server=" + Server + ", Database=" + Database + ", UserName=" + Username + ", Password="
				+ Password + "]";
	}
}
