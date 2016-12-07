package by.htp.runner;

import by.htp.logic.imple.*;
import by.htp.logic.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



import by.htp.entity.*;
import by.htp.logic.imple.ConsoleAfishaVisitor;

public class Runner {
	
	private final static Logger Log = LogManager.getRootLogger();

	public static void main(String[] args) throws FileNotFoundException {
		
		String text = "Event [place=Pobeda, price=23.2, date=Wed Nov 23 21:53:05 MSK 2016, time=21.00, Title=Fizruk]Film [janre=COMEDY, rating=2.1]";
		String fileName = "C:/Users/User/Desktop/Afisha.txt";
		 
		
		 
		    //Запись в файл
		ConsoleAfishaVisitor.write(fileName, text);
		 
		
		
		
		

		Properties property = new Properties();
		try {
			property.load(new FileInputStream("resources/config.properties"));
			System.out.println(property.getProperty("name"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		

		try {
		ResourceBundle bundleRu = ResourceBundle.getBundle("config", new Locale("ru_RU") );
		ResourceBundle bundleEn = ResourceBundle.getBundle("config", Locale.ENGLISH);
		
			System.out.println(bundleRu.getString("file"));
			System.out.println(bundleEn.getString("name21"));
		} 
		catch (Exception e) {
			
			Log.error("Some error happens");
			Log.error("new event1 was created");
			Log.error("new event2 was created");
			Log.error("new event3 was created");
			
			
		}
		
		
		Event film = new Film(Janre.COMEDY, 2.1, "Pobeda", new BigDecimal(23.15),  new Date(), "21.00", "Fizruk");
		System.out.println(film);
		
		Event opera = new Opera(new Singer("Luciano"), "Bolshoi", new BigDecimal(23.9),  new Date(), "22.00", "Opfr");
		System.out.println(opera);
		
		Afisha afisha = new Afisha("");
		
		/*Event e = new Exhibition(new Singer("Luciano"), "Theater", new BigDecimal(23.9),  new Date(), "22.00", "Opfr");
		System.out.println(opera);
	    Event opera = new Opera("");
		Event exhibition = new Exhibition();
		*/
		
		AfishaVisitor visitor = new ConsoleAfishaVisitor();
		  visitor.loadAfisha(afisha);
		  visitor.loadAfisha(afisha, date);
		  visitor.loadAfisha(afisha, stDate, endDate);
		
	
		
	

	}

}

