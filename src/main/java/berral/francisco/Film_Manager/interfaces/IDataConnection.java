package berral.francisco.Film_Manager.interfaces;

/**
 * Interfaz "IDataConnection" que declara los métodos de "DataConnection"
 * @author Francisco José Berral Zafra
 *
 */
public interface IDataConnection {
	String getServer();
	void setServer(String server);
	String getDatabase();
	void setDatabase(String database);
	String getUsername();
	void setUsername(String username);
	String getPassword();
	void setPassword(String password);
	String toString();
}
