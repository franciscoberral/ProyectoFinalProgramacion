package berral.francisco.Film_Manager.model.DataObject;

import berral.francisco.Film_Manager.interfaces.ICinema;

public class Cinema implements ICinema {
	private Integer ID_C;
	private String Name;
	private String Address;
	private String Location;
	private Integer Rooms;
	private Integer Capacity;
	
	public Cinema() {
		this.ID_C = null;
		this.Name = "";
		this.Address = "";
		this.Location = "";
		this.Rooms = null;
		this.Capacity = null;
	}

	public Cinema(Integer iD_C, String name, String address, String location, Integer rooms, Integer capacity) {
		this.ID_C = iD_C;
		this.Name = name;
		this.Address = address;
		this.Location = location;
		this.Rooms = rooms;
		this.Capacity = capacity;
	}

	public Integer getID_C() {
		return ID_C;
	}

	public void setID_C(Integer iD_C) {
		ID_C = iD_C;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public Integer getRooms() {
		return Rooms;
	}

	public void setRooms(Integer rooms) {
		Rooms = rooms;
	}

	public Integer getCapacity() {
		return Capacity;
	}

	public void setCapacity(Integer capacity) {
		Capacity = capacity;
	}

	@Override
	public String toString() {
		return "Cinema [ID_C=" + ID_C + ", Name=" + Name + ", Address=" + Address + ", Location=" + Location
				+ ", Rooms=" + Rooms + ", Capacity=" + Capacity + "]";
	}
}
