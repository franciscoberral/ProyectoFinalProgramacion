package berral.francisco.Film_Manager;

import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import berral.francisco.Film_Manager.model.DAO.CinemaDAO;
import berral.francisco.Film_Manager.model.DataObject.Cinema;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
	private TextField filterField;
	
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
	private void deleteCinema() throws IOException {
		Integer id = Integer.parseInt(ID.getText());
		String name = Name.getText();
		String address = Address.getText();
		String location = Location.getText();
		Integer rooms = Integer.parseInt(Rooms.getText());
		Integer capacity = Integer.parseInt(Capacity.getText());
		
		Cinema c = new Cinema(id, name, address, location, rooms, capacity);
		
		cDAO.delete(c);
		ID.clear();
		Name.clear();
		Address.clear();
		Location.clear();
		Rooms.clear();
		Capacity.clear();
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
	
	@FXML
	private void onEdit() {
		if(cinemaTable.getSelectionModel().getSelectedItem() != null) {
			Cinema selected = cinemaTable.getSelectionModel().getSelectedItem();
			ID.setText(String.valueOf(selected.getID_C()));
			Name.setText(selected.getName());
			Address.setText(selected.getAddress());
			Location.setText(selected.getLocation());
			Rooms.setText(String.valueOf(selected.getRooms()));
			Capacity.setText(String.valueOf(selected.getCapacity()));
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Cinema> list = (List<Cinema>) cDAO.getAll();
		
		ObservableList<Cinema> ob = FXCollections.observableArrayList(list);
		
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
		
		FilteredList<Cinema> filList = new FilteredList<>(ob, b -> true);
		
		filterField.setOnKeyReleased(b -> {
			filterField.textProperty().addListener((observable, oldValue, newValue) -> {
				filList.setPredicate((Predicate<? super Cinema>) (Cinema cinema) -> {
					if(newValue == null || newValue.isEmpty()) {
						return true;
					}
					if (cinema.getName().contains(newValue)) {
						return true;
					}
					return false;
				});
			});
			
			SortedList<Cinema> sorList = new SortedList<>(filList);
			sorList.comparatorProperty().bind(cinemaTable.comparatorProperty());
			cinemaTable.setItems(sorList);
		});
		
		cinemaTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 1) {
				onEdit();
			}
		});
	}
}
