package berral.francisco.Film_Manager.model.DataObject;

import java.time.LocalDate;

import berral.francisco.Film_Manager.interfaces.IProyection;

public class Proyection implements IProyection {
	private Cinema c;
	private Film f;
	private LocalDate StartDate;
	private LocalDate FinishDate;
	
	public Proyection() {
		this.c = null;
		this.f = null;
		this.StartDate = null;
		this.FinishDate = null;
	}
	
	public Proyection(Cinema c, Film f, LocalDate startDate, LocalDate finishDate) {
		this.c = c;
		this.f = f;
		this.StartDate = startDate;
		this.FinishDate = finishDate;
	}

	public Cinema getC() {
		return c;
	}

	public void setC(Cinema c) {
		this.c = c;
	}

	public Film getF() {
		return f;
	}

	public void setF(Film f) {
		this.f = f;
	}

	public LocalDate getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}

	public LocalDate getFinishDate() {
		return FinishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		FinishDate = finishDate;
	}

	@Override
	public String toString() {
		return "Proyection [c=" + c + ", f=" + f + ", StartDate=" + StartDate + ", FinishDate=" + FinishDate + "]";
	}
	
}
