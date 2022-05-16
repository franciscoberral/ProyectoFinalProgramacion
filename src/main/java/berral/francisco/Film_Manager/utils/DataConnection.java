package berral.francisco.Film_Manager.utils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import berral.francisco.Film_Manager.interfaces.IDataConnection;

/**
 * Clase "Conexión de Datos" que implementa la interfaz "IDataConnection"
 * @author Francisco José Berral Zafra
 *
 */
@XmlRootElement(name="Connection")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataConnection implements IDataConnection {
	/**
	 * Atributos de la conexión
	 */
	private String Server;
	private String Database;
	private String Username;
	private String Password;
	
	/**
	 * Constructor por defecto de la conexión
	 */
	public DataConnection() {
	
	}
	
	/**
	 * Constructor con parámetros de la conexión
	 * @param server Nombre del servidor
	 * @param database Nombre de la BBDD
	 * @param username Nombre del usuario
	 * @param password Contraseña
	 */
	public DataConnection(String server, String database, String username, String password) {
		Server = server;
		Database = database;
		Username = username;
		Password = password;
	}

	/**
	 * Obtener el nombre del servidor
	 */
	public String getServer() {
		return Server;
	}
	
	/**
	 * Setear el nombre del servidor
	 */
	public void setServer(String server) {
		Server = server;
	}

	/**
	 * Obtener el nombre de la BBDD
	 */
	public String getDatabase() {
		return Database;
	}

	/**
	 * Setear el nombre de la BBDD
	 */
	public void setDatabase(String database) {
		Database = database;
	}

	/**
	 * Obtener el nombre del usuario
	 */
	public String getUsername() {
		return Username;
	}

	/**
	 * Setear el nombre del usuario
	 */
	public void setUsername(String username) {
		Username = username;
	}

	/**
	 * Obtener la contraseña
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * Setear la contraseña
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * Muestra la información de la conexión
	 */
	@Override
	public String toString() {
		return "DataConnection [Server=" + Server + ", Database=" + Database + ", UserName=" + Username + ", Password="
				+ Password + "]";
	}
}
