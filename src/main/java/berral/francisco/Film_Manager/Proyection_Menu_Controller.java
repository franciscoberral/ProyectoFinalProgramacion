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
import berral.francisco.Film_Manager.utils.Log;
import berral.francisco.Film_Manager.utils.Message;
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
import javafx.scene.input.MouseEvent;

/**
 * Controlador "Proyection_Menu_Controller" que implementa "Initializable"
 * @author Francisco José Berral Zafra
 *
 */
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
	
	/**
	 * Cambia a la Vista "Main"
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void switchToMain() throws IOException {
		App.setRoot("main_menu_view");
	}
	
	/**
	 * Método asignado al botón "ADD" que permite añadir una proyección
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void addProyection() throws IOException {
		Cinema c = comCinema.getSelectionModel().getSelectedItem(); 
		Production p = comProd.getSelectionModel().getSelectedItem();
		LocalDate sD = dateStart.getValue();
		LocalDate fD = dateFinish.getValue();
		
		if(comCinema.getSelectionModel().getSelectedItem() != null && comProd.getSelectionModel().getSelectedItem() != null && dateStart.getValue() != null && dateFinish.getValue() != null) {
			Proyection pr = pDAO.get(c.getID_C(), p.getID_F(), sD);
		
			if(pr == null) {
				if(fD.isAfter(sD)) {
					Proyection pro = new Proyection(c, p, sD, fD);
					pDAO.insert(pro);
					initialize(null, null);
					Message.alert("SUCCESS", "OPERATION SUCCESSFULLY", "PROYECTION HAS BEEN ADDED");
					Log.info("PROYECTION HAS BEEN ADDED");
				}else {
					Message.error("ERROR", "ERROR WHEN ENTERING PROYECTION", "THE END DATE MUST BE LATER THAN THE START DATE");
					Log.severe("THE END DATE MUST BE LATER THAN THE START DATE");
				}
			}else {
				Message.error("ERROR", "ERROR WHEN ENTERING PROYECTION", "PROYECTION ALREADY EXISTS");
				Log.severe("PROYECTION ALREADY EXISTS");
			}
		}else {
			Message.error("ERROR", "ERROR WHEN ENTERING PROYECTION", "ALL FIELDS ARE REQUIRED");
			Log.severe("ALL FIELDS ARE REQUIRED");
		}
	}
	
	/**
	 * Método asignado al botón "DELETE" que permite eliminar una proyección
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void deleteProyection() throws IOException {
		Cinema c = comCinema.getSelectionModel().getSelectedItem(); 
		Production p = comProd.getSelectionModel().getSelectedItem();
		LocalDate sD = dateStart.getValue();
		
		if(comCinema.getSelectionModel().getSelectedItem() != null && comProd.getSelectionModel().getSelectedItem() != null && dateStart.getValue() != null) {
			Proyection pr = pDAO.get(c.getID_C(), p.getID_F(), sD);
			if(pr != null) {
				pDAO.delete(pr);
				initialize(null, null);
				Message.alert("SUCCESS", "OPERATION SUCCESSFULLY", "PROYECTION HAS BEEN DELETED");
				Log.info("PROYECTION HAS BEEN DELETED");
			}else {
				Message.error("ERROR", "ERROR WHEN ENTERING PROYECTION", "PROYECTION NOT FOUND");
				Log.severe("PROYECTION NOT FOUND");
			}
		}else {
			Message.error("ERROR", "ERROR WHEN ENTERING PROYECTION", "FIELDS ID_C, ID_F AND STARTDATE FROM PROYECTION ARE REQUIRED");
			Log.severe("FIELDS ID_C, ID_F AND STARTDATE FROM PROYECTION ARE REQUIRED");
		}
	}

	/**
	 * Método asignado al botón "UPDATE" que permite actualizar una proyección
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void modifyProyection() throws IOException {
		Cinema c = comCinema.getSelectionModel().getSelectedItem(); 
		Production p = comProd.getSelectionModel().getSelectedItem();
		LocalDate sD = dateStart.getValue();
		LocalDate fD = dateFinish.getValue();
		
		if(comCinema.getSelectionModel().getSelectedItem() != null && comProd.getSelectionModel().getSelectedItem() != null && dateStart.getValue() != null) {
			Proyection pr = pDAO.get(c.getID_C(), p.getID_F(), sD);
			if(pr != null) {
				if(fD.isAfter(sD)) {
					pr.setC(c);
					pr.setP(p);
					pr.setStartDate(sD);
					pr.setFinishDate(fD);
					pDAO.update(pr);
					initialize(null, null);
					Message.alert("SUCCESS", "OPERATION SUCCESSFULLY", "PROYECTION HAS BEEN MODIFIED");
					Log.info("PROYECTION HAS BEEN MODIFIED");
				}else {
					Message.error("ERROR", "ERROR WHEN ENTERING PROYECTION", "THE END DATE MUST BE LATER THAN THE START DATE");
					Log.severe("THE END DATE MUST BE LATER THAN THE START DATE");
				}
			}else {
				Message.error("ERROR", "ERROR WHEN ENTERING PROYECTION", "PROYECTION NOT FOUND");
				Log.severe("PROYECTION NOT FOUND");
			}
		}else {
			Message.error("ERROR", "ERROR WHEN ENTERING PROYECTION", "FIELDS ID_C, ID_F AND STARTDATE FROM PROYECTION ARE REQUIRED");	
			Log.severe("FIELDS ID_C, ID_F AND STARTDATE FROM PROYECTION ARE REQUIRED");
		}
	}
	
	@FXML
	private void onEdit() {
		if(proyectionTable.getSelectionModel().getSelectedItem() != null) {
			Proyection p = proyectionTable.getSelectionModel().getSelectedItem();
			Cinema c = cDAO.get(p.getC().getID_C());
			comCinema.setValue(c);
			Production pr = ProductionDAO.get(p.getP().getID_F());
			comProd.setValue(pr);
			dateStart.setValue(p.getStartDate());
			dateFinish.setValue(p.getFinishDate());
		}
	}

	/**
	 * Método que permite setear en las celdas de la tabla los valores de los ComboBoxs y de los DatePickers
	 */
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
		
		proyectionTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 1) {
				onEdit();
			}
		});
	}
}
