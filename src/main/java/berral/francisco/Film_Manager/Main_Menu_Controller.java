package berral.francisco.Film_Manager;

import java.io.IOException;
import javafx.fxml.FXML;

public class Main_Menu_Controller {

	@FXML
	private void switchToCinemas() throws IOException {
		App.setRoot("cinema_menu_view");
	}
	
	@FXML
	private void switchToFilms() throws IOException {
		App.setRoot("film_menu_view");
	}
	
	@FXML
	private void switchToSeries() throws IOException {
		App.setRoot("serie_menu_view");
	}

	@FXML
	private void switchToProyections() throws IOException {
		App.setRoot("proyection_menu_view");
	}
	
	@FXML
	private void switchToStart() throws IOException {
		App.setRoot("start_menu_view");
	}
}
