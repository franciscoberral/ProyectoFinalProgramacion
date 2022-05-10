package berral.francisco.Film_Manager.utils;

public class Utils {

	public static boolean isNumeric(String s) {
		boolean resultado;
		
		try {
			Integer.parseInt(s);
			resultado = true;
		}catch (NumberFormatException e) {
			resultado = false;
		}
		
		return resultado;
	}
}
