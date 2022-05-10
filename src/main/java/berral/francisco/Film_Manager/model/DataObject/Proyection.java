package berral.francisco.Film_Manager.model.DataObject;

import berral.francisco.Film_Manager.interfaces.IProyection;

public class Proyection implements IProyection {
	private Cinema c;
	private Film f;
	
	public Proyection() {
		this.c = null;
		this.f = null;
	}
	
	public Proyection(Cinema c, Film f) {
		this.c = c;
		this.f = f;
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

	@Override
	public String toString() {
		return "Proyection [c=" + c + ", f=" + f + "]";
	}
}
