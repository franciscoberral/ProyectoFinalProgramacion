package berral.francisco.Film_Manager.interfaces;

public interface ICinema {
	Integer getID_C();
	void setID_C(Integer iD_C);
	String getName();
	void setName(String name);
	String getAddress();
	void setAddress(String address);
	String getLocation();
	void setLocation(String location);
	Integer getRooms();
	void setRooms(Integer rooms);
	Integer getCapacity();
	void setCapacity(Integer capacity);
	String toString();
}
