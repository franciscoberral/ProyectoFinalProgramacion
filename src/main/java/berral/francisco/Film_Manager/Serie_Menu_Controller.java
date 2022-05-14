package berral.francisco.Film_Manager;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import berral.francisco.Film_Manager.model.DAO.ProductionDAO;
import berral.francisco.Film_Manager.model.DAO.SerieDAO;
import berral.francisco.Film_Manager.model.DataObject.Production;
import berral.francisco.Film_Manager.model.DataObject.Serie;
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

public class Serie_Menu_Controller implements Initializable {
	
	SerieDAO sDAO = new SerieDAO();
	
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
	private TextField Episodes;
	
	@FXML
	private TextField Seasons;
	
	@FXML
	private TextField filterField;
	
	@FXML
	private TableView<Production> serieTable;
	
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
	
	@FXML
	private TableColumn<Production, Integer> episodesCol;
	
	@FXML
	private TableColumn<Production, Integer> seasonsCol;
	
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
	private void addSerie() {
		Integer id = Integer.parseInt(ID.getText());
		String title = Title.getText();
		String type = Type.getText();
		Integer duration = Integer.parseInt(Duration.getText());
		Integer year = Integer.parseInt(Year.getText());
		String rating = Rating.getText();
		Integer episodes = Integer.parseInt(Episodes.getText());
		Integer seasons = Integer.parseInt(Seasons.getText());
			
		Serie s = new Serie(id ,title, type, duration, year, rating, episodes, seasons);
			
		sDAO.insert(s);
		ID.clear();
		Title.clear();
		Type.clear();
		Duration.clear();
		Year.clear();
		Rating.clear();
		Episodes.clear();
		Seasons.clear();
		initialize(null, null);
	}
	
	@FXML
	private void deleteSerie() {
		Integer id = Integer.parseInt(ID.getText());
		String title = Title.getText();
		String type = Type.getText();
		Integer duration = Integer.parseInt(Duration.getText());
		Integer year = Integer.parseInt(Year.getText());
		String rating = Rating.getText();
		Integer episodes = Integer.parseInt(Episodes.getText());
		Integer seasons = Integer.parseInt(Seasons.getText());
		
		Production p = new Production(id ,title, type, duration, year, rating, episodes, seasons);
		ProductionDAO.delete(p);
		ID.clear();
		Title.clear();
		Type.clear();
		Duration.clear();
		Year.clear();
		Rating.clear();
		Episodes.clear();
		Seasons.clear();
		initialize(null, null);
	}
	
	@FXML
	private void modifySerie() {
		Integer id = Integer.parseInt(ID.getText());
		String title = Title.getText();
		String type = Type.getText();
		Integer duration = Integer.parseInt(Duration.getText());
		Integer year = Integer.parseInt(Year.getText());
		String rating = Rating.getText();
		Integer episodes = Integer.parseInt(Episodes.getText());
		Integer seasons = Integer.parseInt(Seasons.getText());
		
		Production p = ProductionDAO.get(id);
		if(p != null) {
			p.setTitle(title);
			p.setType(type);;
			p.setDuration(duration);
			p.setYear(year);;
			p.setRating(rating);
			p.setEpisodes(episodes);
			p.setSeasons(seasons);
			
			Serie s = new Serie (id, title, type, duration, year, rating, episodes, seasons);
			sDAO.update(s);
			ID.clear();
			Title.clear();
			Type.clear();
			Duration.clear();
			Year.clear();
			Rating.clear();
			Episodes.clear();
			Seasons.clear();
			initialize(null, null);
		}
	}
	
	@FXML
	private void onEdit() {
		if(serieTable.getSelectionModel().getSelectedItem() != null) {
			Production selected = serieTable.getSelectionModel().getSelectedItem();
			ID.setText(String.valueOf(selected.getID_F()));
			Title.setText(selected.getTitle());
			Type.setText(selected.getType());
			Duration.setText(String.valueOf(selected.getDuration()));
			Year.setText(String.valueOf(selected.getYear()));
			Rating.setText(selected.getRating());
			Episodes.setText(String.valueOf(selected.getEpisodes()));
			Seasons.setText(String.valueOf(selected.getSeasons()));
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Production> list = (List<Production>) ProductionDAO.getAllSeries();
		
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
		episodesCol.setCellValueFactory(production ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(production.getValue().getEpisodes());
			return o;
		});
		seasonsCol.setCellValueFactory(production ->{
			ObservableValue<Integer> o = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) o).setValue(production.getValue().getSeasons());
			return o;
		});
		
		serieTable.setItems(FXCollections.observableArrayList(list));
		
		FilteredList<Production> filList = new FilteredList<>(ob, b -> true);
		
		filterField.setOnKeyReleased(b -> {
			filterField.textProperty().addListener((observable, oldValue, newValue) -> {
				filList.setPredicate((Predicate<? super Production>) production -> {
					if(newValue.isEmpty() || newValue == null) {
						return true;
					}
					if (production.getTitle().contains(newValue)) {
						return true;
					}
					return false;
				});
				
				SortedList<Production> sorList = new SortedList<>(filList);
				sorList.comparatorProperty().bind(serieTable.comparatorProperty());
				
				serieTable.setItems(sorList);
			});
		});
		
		serieTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 1) {
				onEdit();
			}
		});
	}
}
