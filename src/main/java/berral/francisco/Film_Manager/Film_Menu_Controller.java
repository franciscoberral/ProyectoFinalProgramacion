package berral.francisco.Film_Manager;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import berral.francisco.Film_Manager.model.DAO.FilmDAO;
import berral.francisco.Film_Manager.model.DataObject.Film;
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
	private TableView<Film> filmTable;
	
	@FXML
	private TableColumn<Film, Integer> idCol;
	
	@FXML
	private TableColumn<Film, String> titleCol;
	
	@FXML
	private TableColumn<Film, String> typeCol;
	
	@FXML
	private TableColumn<Film, Integer> durationCol;
	
	@FXML
	private TableColumn<Film, Integer> yearCol;
	
	@FXML
	private TableColumn<Film, String> ratingCol;
	
	@FXML
	private void switchToMain() throws IOException {
		App.setRoot("main_menu_view");
	}
	
	@FXML
	private void clear() throws IOException {
		ID.clear();
		Title.clear();
		Type.clear();
		Duration.clear();
		Year.clear();
		Rating.clear();
	}
	
	@FXML
	private void addFilm() {
		Integer id = Integer.parseInt(ID.getText());
		String title = Title.getText();
		String type = Type.getText();
		Integer duration = Integer.parseInt(Duration.getText());
		Integer year = Integer.parseInt(Year.getText());
		String rating = Rating.getText();
		
		Film f = new Film(id ,title, type, duration, year, rating);
		
		fDAO.insert(f);
		ID.clear();
		Title.clear();
		Type.clear();
		Duration.clear();
		Year.clear();
		Rating.clear();
		initialize(null, null);
	}
	
	@FXML
	private void deleteFilm() {
		Integer id = Integer.parseInt(ID.getText());
		
		fDAO.delete(id);
		Title.clear();
		initialize(null, null);
	}
	
	@FXML
	private void modifyFilm() {
		Integer id = Integer.parseInt(ID.getText());
		String title = Title.getText();
		String type = Type.getText();
		Integer duration = Integer.parseInt(Duration.getText());
		Integer year = Integer.parseInt(Year.getText());
		String rating = Rating.getText();
		
		Film f = fDAO.get(id);
		if(f != null) {
			f.setTitle(title);
			f.setType(type);;
			f.setDuration(duration);
			f.setYear(year);;
			f.setRating(rating);
			fDAO.update(f);
			ID.clear();
			Title.clear();
			Type.clear();
			Duration.clear();
			Year.clear();
			Rating.clear();
			initialize(null, null);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Film> list = (List<Film>) fDAO.getAll();
		
		ObservableList<Film> ob = FXCollections.observableArrayList(list);
		
		for(Film f : list) {
			ob.add(f);
		}
		
		idCol.setCellValueFactory(film ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(film.getValue().getID_F());
			return o;
		});
		titleCol.setCellValueFactory(film ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(film.getValue().getTitle());
			return s;
		});
		typeCol.setCellValueFactory(film ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(film.getValue().getType());
			return s;
		});
		durationCol.setCellValueFactory(film ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(film.getValue().getDuration());
			return o;
		});
		yearCol.setCellValueFactory(film ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(film.getValue().getYear());
			return o;
		});
		ratingCol.setCellValueFactory(film ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(film.getValue().getRating());
			return s;
		});
		
		filmTable.setItems(FXCollections.observableArrayList(list));
	}
}
