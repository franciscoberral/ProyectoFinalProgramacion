package berral.francisco.Film_Manager.interfaces;

import berral.francisco.Film_Manager.model.DataObject.Cinema;
import berral.francisco.Film_Manager.model.DataObject.Film;

public interface IProyection {
	Cinema getC();
	void setC(Cinema c);
	Film getF();
	void setF(Film f);
	String toString();
}
