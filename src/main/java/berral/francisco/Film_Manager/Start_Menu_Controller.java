package berral.francisco.Film_Manager;

import java.io.IOException;

import javafx.fxml.FXML;

/**
 * Controlador "Start_Menu_Controller"
 * @author Francisco José Berral Zafra
 *
 */
public class Start_Menu_Controller {
	
	/**
	 * Cambia a la Vista "Main"
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void switchToMain() throws IOException {
		App.setRoot("main_menu_view");
	}
	
	/**
	 * Cierra el programa
	 * @throws IOException Lanza excepción en caso de error
	 */
	@FXML
	private void quit() throws IOException {
		System.exit(0);
	}
}
