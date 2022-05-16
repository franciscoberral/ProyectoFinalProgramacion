package berral.francisco.Film_Manager.interfaces;

import java.time.LocalDate;

import berral.francisco.Film_Manager.model.DataObject.Cinema;
import berral.francisco.Film_Manager.model.DataObject.Production;


public interface IProyection {
	Cinema getC();
	void setC(Cinema c);
	Production getP();
	void setP(Production f);
	LocalDate getStartDate();
	void setStartDate(LocalDate startDate);
	LocalDate getFinishDate();
	void setFinishDate(LocalDate finishDate);
	String toString();
}
