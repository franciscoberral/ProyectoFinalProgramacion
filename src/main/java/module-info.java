module berral.francisco.Film_Manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.sql;
	requires javafx.base;

    opens berral.francisco.Film_Manager to javafx.fxml;
    opens berral.francisco.Film_Manager.utils to java.xml.bind;
    exports berral.francisco.Film_Manager;
}
