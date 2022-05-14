package berral.francisco.Film_Manager.model.DataObject;

import java.time.LocalDate;

public class Proyection{
	private Cinema c;
	private Production p;
	private LocalDate StartDate;
	private LocalDate FinishDate;
	
	public Proyection() {
		
	}
	
	public Proyection(Cinema c, Production p, LocalDate startDate, LocalDate finishDate) {
		this.c = c;
		this.p = p;
		this.StartDate = startDate;
		this.FinishDate = finishDate;
	}

	public Cinema getC() {
		return c;
	}

	public void setC(Cinema c) {
		this.c = c;
	}

	public Production getP() {
		return p;
	}

	public void setP(Production p) {
		this.p = p;
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
		return "Proyection [c=" + c + ", p=" + p + ", StartDate=" + StartDate + ", FinishDate=" + FinishDate + "]";
	}
}
