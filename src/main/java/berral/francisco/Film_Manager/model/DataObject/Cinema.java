package berral.francisco.Film_Manager.model.DataObject;

import berral.francisco.Film_Manager.interfaces.ICinema;

/**
 * Clase "Cinema" que implementa la interfaz "ICinema"
 * @author Francisco José Berral Zafra
 *
 */
public class Cinema implements ICinema {
	/**
	 * Atributos del cine
	 */
	private Integer ID_C;
	private String Name;
	private String Address;
	private String Location;
	private Integer Rooms;
	private Integer Capacity;
	
	/**
	 * Constructor por defecto del cine
	 */
	public Cinema() {
	
	}
	
	/**
	 * Constructor con parámetros del cine
	 * @param iD_C ID del cine
	 * @param name Nombre del cine
	 * @param address Dirección del cine
	 * @param location Ubicación del cine
	 * @param rooms Salas del cine
	 * @param capacity Aforo del cine
	 */
	public Cinema(Integer iD_C, String name, String address, String location, Integer rooms, Integer capacity) {
		this.ID_C = iD_C;
		this.Name = name;
		this.Address = address;
		this.Location = location;
		this.Rooms = rooms;
		this.Capacity = capacity;
	}

	/**
	 * Obtener la ID del cine
	 */
	public Integer getID_C() {
		return ID_C;
	}

	/**
	 * Setear la ID del cine
	 */
	public void setID_C(Integer iD_C) {
		ID_C = iD_C;
	}

	/**
	 * Obtener el nombre del cine
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * Setear el nombre del cine
	 */
	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * Obtener la dirección del cine
	 */
	public String getAddress() {
		return Address;
	}
	
	/**
	 * Setear la dirección del cine
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * Obtener la ubicación del cine
	 */
	public String getLocation() {
		return Location;
	}
	
	/**
	 * Setear la ubicación del cine
	 */
	public void setLocation(String location) {
		Location = location;
	}
	
	/**
	 * Obtener las salas del cine
	 */
	public Integer getRooms() {
		return Rooms;
	}

	/**
	 * Setear las salas del cine
	 */
	public void setRooms(Integer rooms) {
		Rooms = rooms;
	}

	/**
	 * Obtener el aforo del cine
	 */
	public Integer getCapacity() {
		return Capacity;
	}

	/**
	 * Setear el aforo del cine
	 */
	public void setCapacity(Integer capacity) {
		Capacity = capacity;
	}

	/**
	 * Muestra la información del cine
	 */
	@Override
	public String toString() {
		return Name;
	}
}
