package berral.francisco.Film_Manager.utils;

import java.io.IOException;

import berral.francisco.Film_Manager.interfaces.IMessage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Message implements IMessage {

	public static void alert(String title, String header, String content) throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
		
		Stage s = (Stage) alert.getDialogPane().getScene().getWindow();
		s.toFront();
	}
	
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
