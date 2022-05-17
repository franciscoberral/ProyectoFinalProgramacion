package berral.francisco.Film_Manager.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Clase "Log"
 * @author Francisco José Berral Zafra
 *
 */
public class Log {
	/**
	 * Método para mostrar registro informativo
	 * @param s Cadena informativa
	 */
	public static void info(String s) {
		try {
			InputStream configFile = Log.class.getResourceAsStream("loggin.properties");
			LogManager.getLogManager().readConfiguration(configFile);
		} catch (SecurityException | IOException | NullPointerException e) {
			System.out.println("Logging system not initialized");
		}
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		logger.info(s);
	}
	
	/**
	 * Método para mostrar registro de error
	 * @param s Cadena del error
	 */
	public static void severe(String s) {
		try {
			InputStream configFile = Log.class.getResourceAsStream("loggin.properties");
			LogManager.getLogManager().readConfiguration(configFile);
		} catch (SecurityException | IOException | NullPointerException e) {
			System.out.println("Logging system not initialized");
		}
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		logger.severe(s);
	}
}
