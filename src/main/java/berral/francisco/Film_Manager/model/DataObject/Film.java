package berral.francisco.Film_Manager.model.DataObject;

public class Film extends Production {
	
	public Film() {
		super();
	}

	public Film(Integer iD_F, String title, String type, Integer duration, Integer year, String rating) {
		super(iD_F, title, type, duration, year, rating);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
