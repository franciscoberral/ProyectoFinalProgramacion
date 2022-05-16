package berral.francisco.Film_Manager.utils;

import java.io.IOException;

import berral.francisco.Film_Manager.interfaces.IMessage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Clase "Mensaje" que implementa la interfaz "IMessage"
 * @author Francisco José Berral Zafra
 *
 */
public class Message implements IMessage {
	/**
	 * Método para mostrar la ventana de alerta
	 * @param title Título de la alerta
	 * @param header Cabecera de la alerta
	 * @param content Contenido de la alerta
	 * @throws IOException Lanza excepción en caso de que exista 
	 */
	public static void alert(String title, String header, String content) throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
		
		Stage s = (Stage) alert.getDialogPane().getScene().getWindow();
		s.toFront();
	}
	
	/**
	 * Método para mostrar la ventana de error
	 * @param title Título del error
	 * @param header Cabecera del error
	 * @param content Contenido del error
	 * @throws IOException Lanza excepción en caso de que exista 
	 */
	public static void error(String title, String header, String content) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
		
		Stage s = (Stage) alert.getDialogPane().getScene().getWindow();
		s.toFront();
	}
}
