package berral.francisco.Film_Manager.utils;

import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Message {

	public static void alert(String title, String header, String content) throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
		
		Stage s = (Stage) alert.getDialogPane().getScene().getWindow();
		s.toFront();
	}
	
	public static void error() throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("aaaa");
		alert.setContentText("aaaaa");
		alert.show();
		
		Stage s = (Stage) alert.getDialogPane().getScene().getWindow();
		s.toFront();
	}
}
