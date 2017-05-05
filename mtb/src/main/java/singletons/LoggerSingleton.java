package singletons;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerSingleton {

	private static LoggerSingleton instance = null;

	Logger logger;  
    FileHandler fh;  
    SimpleFormatter formatter;
	
	protected LoggerSingleton() {
		try {
			logger = Logger.getLogger("MyLog"); 
			fh = new FileHandler("MyLogFile.log");  
			logger.addHandler(fh);
			formatter = new SimpleFormatter();  
			fh.setFormatter(formatter);  

			// the following statement is used to log any messages  
			logger.info("My first log");
		} catch (SecurityException e) {
			logger.info("Riknulo");
		} catch (IOException e) {
			logger.info("Riknulo");
		} 
	}

	public static LoggerSingleton getInstance() {
		if (instance == null) {
			instance = new LoggerSingleton();
		}
		return instance;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	

}
