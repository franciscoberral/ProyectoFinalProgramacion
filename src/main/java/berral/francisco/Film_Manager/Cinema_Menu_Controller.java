package berral.francisco.Film_Manager;

import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import berral.francisco.Film_Manager.model.DAO.CinemaDAO;
import berral.francisco.Film_Manager.model.DataObject.Cinema;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Cinema_Menu_Controller implements Initializable{

	CinemaDAO cDAO = new CinemaDAO();
	
	@FXML
	private TextField ID;
	
	@FXML
	private TextField Name;
	
	@FXML
	private TextField Address;
	
	@FXML
	private TextField Location;
	
	@FXML
	private TextField Rooms;
	
	@FXML
	private TextField Capacity;
	
	@FXML
	private TableView<Cinema> cinemaTable;
	
	@FXML
	private TableColumn<Cinema, Integer> idCol;
	
	@FXML
	private TableColumn<Cinema, String> nameCol;
	
	@FXML
	private TableColumn<Cinema, String> addressCol;
	
	@FXML
	private TableColumn<Cinema, String> locationCol;
	
	@FXML
	private TableColumn<Cinema, Integer> roomsCol;
	
	@FXML
	private TableColumn<Cinema, Integer> capacityCol;
	
	@FXML
	private void switchToMain() throws IOException {
		App.setRoot("main_menu_view");
	}
	
	@FXML
	private void clear() throws IOException {
		ID.clear();
		Name.clear();
		Address.clear();
		Location.clear();
		Rooms.clear();
		Capacity.clear();
	}
	
	@FXML
	private void addCinema() {
		Integer id = Integer.parseInt(ID.getText());
		String name = Name.getText();
		String address = Address.getText();
		String location = Location.getText();
		Integer rooms = Integer.parseInt(Rooms.getText());
		Integer capacity = Integer.parseInt(Capacity.getText());
		
		Cinema c = new Cinema(id, name, address, location, rooms, capacity);
		
		cDAO.insert(c);
		ID.clear();
		Name.clear();
		Address.clear();
		Location.clear();
		Rooms.clear();
		Capacity.clear();
		initialize(null, null);
	}
	
	@FXML
	private void deleteCinema() {
		Integer id = Integer.parseInt(ID.getText());
		
		cDAO.delete(id);
		ID.clear();
		initialize(null, null);
	}
	
	@FXML
	private void modifyCinema() {
		Integer id = Integer.parseInt(ID.getText());
		String name = Name.getText();
		String address = Address.getText();
		String location = Location.getText();
		Integer rooms = Integer.parseInt(Rooms.getText());
		Integer capacity = Integer.parseInt(Capacity.getText());
		
		Cinema c = cDAO.get(id);
		if(c != null) {
			c.setName(name);
			c.setAddress(address);
			c.setLocation(location);
			c.setRooms(rooms);
			c.setCapacity(capacity);
			cDAO.update(c);
			ID.clear();
			Name.clear();
			Address.clear();
			Location.clear();
			Rooms.clear();
			Capacity.clear();
			initialize(null, null);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Cinema> list = (List<Cinema>) cDAO.getAll();
		
		ObservableList<Cinema> ob = FXCollections.observableArrayList(list);
		
		for(Cinema c : list) {
			ob.add(c);
		}
		
		idCol.setCellValueFactory(cinema ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(cinema.getValue().getID_C());
			return o;
		});
		nameCol.setCellValueFactory(cinema ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(cinema.getValue().getName());
			return s;
		});
		addressCol.setCellValueFactory(cinema ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(cinema.getValue().getAddress());
			return s;
		});
		locationCol.setCellValueFactory(cinema ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(cinema.getValue().getLocation());
			return s;
		});
		roomsCol.setCellValueFactory(cinema ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(cinema.getValue().getRooms());
			return o;
		});
		capacityCol.setCellValueFactory(cinema ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(cinema.getValue().getCapacity());
			return o;
		});
		
		cinemaTable.setItems(FXCollections.observableArrayList(list));
	}
}
