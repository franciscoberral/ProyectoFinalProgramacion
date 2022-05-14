package berral.francisco.Film_Manager.model.DataObject;

public class Serie extends Production{

	public Serie() {
		super();
	}
	
	public Serie(Integer iD_F, String title, String type, Integer duration, Integer year, String rating, Integer episodes, Integer seasons) {
		super(iD_F, title, type, duration, year, rating, episodes, seasons);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
}
