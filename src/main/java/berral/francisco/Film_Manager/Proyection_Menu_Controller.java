package berral.francisco.Film_Manager;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import berral.francisco.Film_Manager.model.DAO.CinemaDAO;
import berral.francisco.Film_Manager.model.DAO.ProductionDAO;
import berral.francisco.Film_Manager.model.DAO.ProyectionDAO;
import berral.francisco.Film_Manager.model.DataObject.Cinema;
import berral.francisco.Film_Manager.model.DataObject.Production;
import berral.francisco.Film_Manager.model.DataObject.Proyection;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Proyection_Menu_Controller implements Initializable{
	
	CinemaDAO cDAO = new CinemaDAO();
	
	ProyectionDAO pDAO = new ProyectionDAO();
	
	@FXML
	private ComboBox<Cinema> comCinema;
	
	@FXML
	private ComboBox<Production> comProd;
	
	@FXML
	private DatePicker dateStart;
	
	@FXML
	private DatePicker dateFinish;
	
	@FXML
	private TableView<Proyection> proyectionTable;
	
	@FXML
	private TableColumn<Proyection, String> nameCol;
	
	@FXML
	private TableColumn<Proyection, String> titleCol;
	
	@FXML
	private TableColumn<Proyection, LocalDate> startCol;
	
	@FXML 
	private TableColumn<Proyection, LocalDate> finishCol;
	
	@FXML
	private void switchToMain() throws IOException {
		App.setRoot("main_menu_view");
	}
	
	@FXML
	private void addProyection() {
		Cinema c = comCinema.getSelectionModel().getSelectedItem(); 
		Production p = comProd.getSelectionModel().getSelectedItem();
		LocalDate sD = dateStart.getValue();
		LocalDate fD = dateFinish.getValue();
		
		Proyection pr = new Proyection(c, p, sD, fD);
		pDAO.insert(pr);
		dateStart.getEditor().clear();
		dateFinish.getEditor().clear();
		initialize(null, null);
	}
	
	@FXML
	private void deleteProyection() throws IOException {
		Cinema c = comCinema.getSelectionModel().getSelectedItem(); 
		Production p = comProd.getSelectionModel().getSelectedItem();
		LocalDate sD = dateStart.getValue();
		LocalDate fD = dateFinish.getValue();
		
		Proyection pr = new Proyection(c, p, sD, fD);
		pDAO.delete(pr);
		dateStart.getEditor().clear();
		dateFinish.getEditor().clear();
		initialize(null, null);
	}

	@FXML
	private void modifyProyection() {
		Cinema c = comCinema.getSelectionModel().getSelectedItem(); 
		Production p = comProd.getSelectionModel().getSelectedItem();
		LocalDate sD = dateStart.getValue();
		LocalDate fD = dateFinish.getValue();
		
		Proyection pr = pDAO.get(c.getID_C(), p.getID_F());
		if(pr != null) {
			pr.setC(c);
			pr.setP(p);
			pr.setStartDate(sD);
			pr.setFinishDate(fD);
			pDAO.update(pr);
			dateStart.getEditor().clear();
			dateFinish.getEditor().clear();
			initialize(null, null);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Cinema> cinemaList = (List<Cinema>) cDAO.getAll();
		ObservableList<Cinema> obsCinema = FXCollections.observableArrayList(cinemaList);
		comCinema.setItems(obsCinema);
		
		List<Production> productionList = (List<Production>) ProductionDAO.getAllFilms();
		ObservableList<Production> obsProd = FXCollections.observableArrayList(productionList);
		comProd.setItems(obsProd);
		
		List<Proyection> proyectionList = (List<Proyection>) pDAO.getAll();
		ObservableList<Proyection> obsPro = FXCollections.observableArrayList(proyectionList);

		nameCol.setCellValueFactory(proyection ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(proyection.getValue().getC().getName());
			return s;
		});
		titleCol.setCellValueFactory(proyection ->{
			SimpleStringProperty s = new SimpleStringProperty();
			s.setValue(proyection.getValue().getP().getTitle());
			return s;
		});
		startCol.setCellValueFactory(proyection ->{
			ObservableValue<LocalDate> o = new SimpleObjectProperty<LocalDate>();
			((ObjectProperty<LocalDate>) o).setValue(proyection.getValue().getStartDate());
			return o;
		});
		finishCol.setCellValueFactory(proyection ->{
			ObservableValue<LocalDate> o = new SimpleObjectProperty<LocalDate>();
			((ObjectProperty<LocalDate>) o).setValue(proyection.getValue().getFinishDate());
			return o;
		});
		
		proyectionTable.setItems(FXCollections.observableArrayList(obsPro));
		System.out.println(obsPro);
	}
}
