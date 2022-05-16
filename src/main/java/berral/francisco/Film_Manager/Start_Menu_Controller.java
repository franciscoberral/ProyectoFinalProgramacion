package berral.francisco.Film_Manager;

import java.io.IOException;

import javafx.fxml.FXML;

public class Start_Menu_Controller {
	
	@FXML
	private void switchToMain() throws IOException {
		App.setRoot("main_menu_view");
	}
	
	@FXML
	private void quit() throws IOException {
		System.exit(0);
	}
}
