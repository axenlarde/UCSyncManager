
package utils;

import start.Principale;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

/*********************************************
 * Class used to initiate logging
 * 
 * @author RATEL Alexandre
 *********************************************/
public class initLogging
	{
	
	public static Logger init(String logFileName)
		{
		Logger logger = Logger.getLogger(Principale.class);
		PatternLayout myPattern = new PatternLayout("%d{dd/MM/yyyy - HH:mm:ss} - [%p] (%C:%L) - %m%n");
		
		//On param�tre l'appender qui va �crire dans un fichier
		RollingFileAppender myR = new RollingFileAppender();
		myR.setName("myFileAppender");
		myR.setFile(logFileName);
		myR.setMaxFileSize("1000KB");
		myR.setMaxBackupIndex(7);
		myR.setLayout(myPattern);
		myR.activateOptions();
		
		//On param�tre l'appender qui va �crire dans la console
		ConsoleAppender myC = new ConsoleAppender();
		myC.setLayout(myPattern);
		myC.activateOptions();
		
		//On ajoute les appender � notre logger
		BasicConfigurator.configure(myC);
		logger.addAppender(myR);
		
		return logger;
		}
	
	
	/*2013*//*RATEL Alexandre 8)*/
	}
