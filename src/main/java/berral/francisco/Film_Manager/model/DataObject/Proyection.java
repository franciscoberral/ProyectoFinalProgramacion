package berral.francisco.Film_Manager.model.DataObject;

import java.time.LocalDate;

import berral.francisco.Film_Manager.interfaces.IProyection;

/**
 * Clase "Proyection" que implementa la interfaz "IProyection"
 * @author Francisco José Berral Zafra
 *
 */
public class Proyection implements IProyection {
	/**
	 * Atributos de la proyección
	 */
	private Cinema c;
	private Production p;
	private LocalDate StartDate;
	private LocalDate FinishDate;
	
	/**
	 * Constructor por defecto de la proyección
	 */
	public Proyection() {
		
	}
	
	/**
	 * Constructor con parámetros de la proyección
	 * @param c Cine donde se realiza la proyección
	 * @param p Producción que se proyecta
	 * @param startDate Fecha de inicio de la proyección
	 * @param finishDate Fecha de finalización de la proyección
	 */
	public Proyection(Cinema c, Production p, LocalDate startDate, LocalDate finishDate) {
		this.c = c;
		this.p = p;
		this.StartDate = startDate;
		this.FinishDate = finishDate;
	}
	
	/**
	 * Obtener el cine
	 */
	public Cinema getC() {
		return c;
	}

	/**
	 * Setear el cine
	 */
	public void setC(Cinema c) {
		this.c = c;
	}

	/**
	 * Obtener la producción
	 */
	public Production getP() {
		return p;
	}

	/**
	 * Setear la producción
	 */
	public void setP(Production p) {
		this.p = p;
	}

	/**
	 * Obtener la fecha de inicio de la proyección
	 */
	public LocalDate getStartDate() {
		return StartDate;
	}

	/**
	 * Setear la fecha de inicio de la proyección
	 */
	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}

	/**
	 * Obtener la fecha de finalización de la proyección
	 */
	public LocalDate getFinishDate() {
		return FinishDate;
	}

	/**
	 * Setear la fecha de finalización de la proyección
	 */
	public void setFinishDate(LocalDate finishDate) {
		FinishDate = finishDate;
	}

	/**
	 * Muestra la información de la proyección
	 */
	@Override
	public String toString() {
		return "Proyection [c=" + c + ", p=" + p + ", StartDate=" + StartDate + ", FinishDate=" + FinishDate + "]";
	}
}
