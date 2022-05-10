package berral.francisco.Film_Manager;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import berral.francisco.Film_Manager.model.DAO.CinemaDAO;
import berral.francisco.Film_Manager.model.DAO.FilmDAO;
import berral.francisco.Film_Manager.model.DAO.ProyectionDAO;
import berral.francisco.Film_Manager.model.DataObject.Cinema;
import berral.francisco.Film_Manager.model.DataObject.Film;
import berral.francisco.Film_Manager.model.DataObject.Proyection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Proyection_Menu_Controller implements Initializable{
	
	CinemaDAO cDAO = new CinemaDAO();
	
	FilmDAO fDAO = new FilmDAO();
	
	ProyectionDAO pDAO = new ProyectionDAO();
	
	@FXML
	private ComboBox<Cinema> comCinema;
	
	@FXML
	private ComboBox<Film> comFilm;
	
	@FXML
	private TableView<Proyection> proyectionTable;
	
	@FXML
	private TableColumn<Proyection, String> nameCol;
	
	@FXML
	private TableColumn<Proyection, String> titleCol;
	
	@FXML
	private void switchToMain() throws IOException {
		App.setRoot("main_menu_view");
	}
	
	@FXML
	private void addProyection() {
		Cinema c = comCinema.getSelectionModel().getSelectedItem(); 
		Film f = comFilm.getSelectionModel().getSelectedItem();
		
		Proyection p = new Proyection(c, f);
		pDAO.insert(p);
		initialize(null, null);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Cinema> obsCinema = cDAO.getCinemas();
		comCinema.setItems(obsCinema);
		
		FilmDAO fDAO = new FilmDAO();
		ObservableList<Film> obsFilm = fDAO.getFilms();
		comFilm.setItems(obsFilm);
		
		List<Proyection> list = (List<Proyection>) pDAO.getAll();
		
		ObservableList<Proyection> obsPro = FXCollections.observableArrayList();
		
		for(Proyection p : list) {
			obsPro.add(p);
		}

		nameCol.setCellValueFactory(proyection ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(proyection.getValue().getC().getName());
			return s;
		});
		titleCol.setCellValueFactory(proyection ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(proyection.getValue().getF().getTitle());
			return s;
		});
		
		proyectionTable.setItems(FXCollections.observableArrayList(list));
	}
}