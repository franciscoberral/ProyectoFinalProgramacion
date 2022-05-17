package berral.francisco.Film_Manager;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import berral.francisco.Film_Manager.model.DAO.FilmDAO;
import berral.francisco.Film_Manager.model.DAO.ProductionDAO;
import berral.francisco.Film_Manager.model.DataObject.Film;
import berral.francisco.Film_Manager.model.DataObject.Production;
import berral.francisco.Film_Manager.utils.Log;
import berral.francisco.Film_Manager.utils.Message;
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

/**
 * Controlador "Film_Menu_Controller" que implementa "Initializable"
 * @author Francisco José Berral Zafra
 *
 */
public class Film_Menu_Controller implements Initializable {
	
	FilmDAO fDAO = new FilmDAO();
	
	@FXML
	private TextField ID;
	
	@FXML
	private TextField Title;
	
	@FXML
	private TextField Type;
	
	@FXML
	private TextField Duration;
	
	@FXML
	private TextField Year;
	
	@FXML
	private TextField Rating;
	
	@FXML
	private TextField filterField;
	
	@FXML
	private TableView<Production> filmTable;
	
	@FXML
	private TableColumn<Production, Integer> idCol;
	
	@FXML
	private TableColumn<Production, String> titleCol;
	
	@FXML
	private TableColumn<Production, String> typeCol;
	
	@FXML
	private TableColumn<Production, Integer> durationCol;
	
	@FXML
	private TableColumn<Production, Integer> yearCol;
	
	@FXML
	private TableColumn<Production, String> ratingCol;
	
	/**
	 * Cambia a la Vista "Main"
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void switchToMain() throws IOException {
		App.setRoot("main_menu_view");
	}
	
	/**
	 * Método que limpia el registro de los TextFields
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void clear() throws IOException {
		ID.clear();
		Title.clear();
		Type.clear();
		Duration.clear();
		Year.clear();
		Rating.clear();
	}
	
	/**
	 * Método asignado al botón "ADD" que permite añadir una película
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void addFilm() throws IOException {
		try {
			ID.getText().matches("^[1-9]\\d*$");
			Duration.getText().matches("^[1-9]\\d*$");
			Year.getText().matches("^[1-9]\\d*$");
			Integer id = Integer.parseInt(ID.getText());
			String title = Title.getText();
			String type = Type.getText();
			Integer duration = Integer.parseInt(Duration.getText());
			Integer year = Integer.parseInt(Year.getText());
			String rating = Rating.getText();
				
			Production p = ProductionDAO.get(id);
			
			if(p == null) {
				p = ProductionDAO.get(title);
				if(p == null) {
					if(Title.getText() != "") {
						if(id>0 && duration>0 && year>0) {
							Film newF = new Film(id, title, type, duration, year, rating);
							fDAO.insert(newF);
							ID.clear();
							Title.clear();
							Type.clear();
							Duration.clear();
							Year.clear();
							Rating.clear();
							initialize(null, null);
							Message.alert("SUCCESS", "OPERATION SUCCESSFULLY", "FILM HAS BEEN ADDED");
							Log.info("FILM HAS BEEN ADDED");
						}else {
							Message.error("ERROR", "ERROR WHEN ENTERING CINEMA", "ONLY POSITIVE NUMBERS GREATER THAN 0 ARE ALLOWED");
							Log.severe("ONLY POSITIVE NUMBERS GREATER THAN 0 ARE ALLOWED");
						}
					}else {
						Message.error("ERROR", "ERROR WHEN ENTERING FILM", "TITLE FIELD IS REQUIRED");
						Log.severe("TITLE FIELD IS REQUIRED");
					}
				}else {
					Message.error("ERROR", "ERROR WHEN ENTERING FILM", "THE FILM TITLE ALREADY EXISTS");
					Log.severe("THE FILM TITLE ALREADY EXISTS");
				}
			}else {
				Message.error("ERROR", "ERROR WHEN ENTERING FILM", "THE PRODUCTION ID ALREADY EXISTS");	
				Log.severe("THE PRODUCTION ID ALREADY EXISTS");
			}
		}catch(NumberFormatException e) {
			Message.error("ERROR", "ERROR WHEN ENTERING FILM", "THE FIELDS ID, DURATION AND YEAR FROM FILM MUST BE AN INTEGER");
			Log.severe("THE FIELDS ID, DURATION AND YEAR FROM FILM MUST BE AN INTEGER");
		}
	}
	
	/**
	 * Método asignado al botón "DELETE" que permite eliminar una película
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void deleteFilm() throws IOException {
		try {
			ID.getText().matches("^[1-9]\\d*$");
			Integer id = Integer.parseInt(ID.getText());
		
			Production p = ProductionDAO.get(id);
			
			if(p != null) {
				ProductionDAO.delete(p);
				ID.clear();
				Title.clear();
				Type.clear();
				Duration.clear();
				Year.clear();
				Rating.clear();
				initialize(null, null);
				Message.alert("SUCCESS", "OPERATION SUCCESSFULLY", "FILM HAS BEEN DELETED");
				Log.info("FILM HAS BEEN DELETED");
			}else {
				Message.error("ERROR", "ERROR WHEN ENTERING FILM", "FILM NOT FOUND");
				Log.severe("FILM NOT FOUND");
			}
		}catch(NumberFormatException e) {
				Message.error("ERROR", "ERROR WHEN ENTERING FILM", "THE FIELD FILM ID MUST BE AN INTEGER");
				Log.severe("THE FIELD FILM ID MUST BE AN INTEGER");
		}
	}
	
	/**
	 * Método asignado al botón "UPDATE" que permite actualizar una película
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void modifyFilm() throws IOException {
		try {
			ID.getText().matches("^[1-9]\\d*$");
			Duration.getText().matches("^[1-9]\\d*$");
			Year.getText().matches("^[1-9]\\d*$");
			Integer id = Integer.parseInt(ID.getText());
			String title = Title.getText();
			String type = Type.getText();
			Integer duration = Integer.parseInt(Duration.getText());
			Integer year = Integer.parseInt(Year.getText());
			String rating = Rating.getText();
			
			Production p = ProductionDAO.get(id);
			if(p != null) {
				if(Title.getText() != "") {
					if(duration>0 && year>0) {
						p.setTitle(title);
						p.setType(type);;
						p.setDuration(duration);
						p.setYear(year);;
						p.setRating(rating);
							
						Film f = new Film (id, title, type, duration, year, rating);
						fDAO.update(f);
						ID.clear();
						Title.clear();
						Type.clear();
						Duration.clear();
						Year.clear();
						Rating.clear();
						initialize(null, null);
						Message.alert("SUCCESS", "OPERATION SUCCESSFULLY", "FILM HAS BEEN MODIFIED");
						Log.info("FILM HAS BEEN MODIFIED");
					}else {
						Message.error("ERROR", "ERROR WHEN ENTERING CINEMA", "ONLY POSITIVE NUMBERS GREATER THAN 0 ARE ALLOWED");
						Log.severe("ONLY POSITIVE NUMBERS GREATER THAN 0 ARE ALLOWED");
					}
				}else {
					Message.error("ERROR", "ERROR WHEN ENTERING FILM", "TITLE FIELD IS REQUIRED");
					Log.severe("TITLE FIELD IS REQUIRED");
				}
			}else {
				Message.error("ERROR", "ERROR WHEN ENTERING FILM", "FILM NOT FOUND");
				Log.severe("FILM NOT FOUND");
			}
		}catch(NumberFormatException e) {
			Message.error("ERROR", "ERROR WHEN ENTERING FILM", "THE FIELDS ID, DURATION AND YEAR FROM FILM MUST BE AN INTEGER");
			Log.severe("THE FIELDS ID, DURATION AND YEAR FROM FILM MUST BE AN INTEGER");
		}
	}
	
	/**
	 * Método que permite setear a los TextFields los valores de las celdas de la tabla
	 */
	@FXML
	private void onEdit() {
		if(filmTable.getSelectionModel().getSelectedItem() != null) {
			Production selected = filmTable.getSelectionModel().getSelectedItem();
			ID.setText(String.valueOf(selected.getID_F()));
			Title.setText(selected.getTitle());
			Type.setText(selected.getType());
			Duration.setText(String.valueOf(selected.getDuration()));
			Year.setText(String.valueOf(selected.getYear()));
			Rating.setText(selected.getRating());
		}
	}

	/**
	 * Método que permite setear en las celdas de la tabla los valores de los TextFields y filtrar los valores por nombre
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Production> list = (List<Production>) ProductionDAO.getAllFilms();
		
		ObservableList<Production> ob = FXCollections.observableArrayList(list);
		
		idCol.setCellValueFactory(production ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(production.getValue().getID_F());
			return o;
		});
		titleCol.setCellValueFactory(production ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(production.getValue().getTitle());
			return s;
		});
		typeCol.setCellValueFactory(production ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(production.getValue().getType());
			return s;
		});
		durationCol.setCellValueFactory(production ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(production.getValue().getDuration());
			return o;
		});
		yearCol.setCellValueFactory(production ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(production.getValue().getYear());
			return o;
		});
		ratingCol.setCellValueFactory(production ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(production.getValue().getRating());
			return s;
		});
		
		filmTable.setItems(FXCollections.observableArrayList(ob));
		
		FilteredList<Production> filList = new FilteredList<>(ob, b -> true);
		
		filterField.setOnKeyReleased(b -> {
			filterField.textProperty().addListener((observable, oldValue, newValue) -> {
				filList.setPredicate((Predicate<? super Production>) production -> {
					if(newValue.isEmpty() || newValue == null) {
						return true;
					}
					if (production.getTitle().toLowerCase().contains(newValue.toLowerCase())) {
						return true;
					}
					return false;
				});
				
				SortedList<Production> sorList = new SortedList<>(filList);
				sorList.comparatorProperty().bind(filmTable.comparatorProperty());
				
				filmTable.setItems(sorList);
			});
		});
		
		filmTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 1) {
				onEdit();
			}
		});
	}
}
