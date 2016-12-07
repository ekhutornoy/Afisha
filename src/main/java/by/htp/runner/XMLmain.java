package by.htp.runner;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.dao.xml.AfishaXMLHandler;

public class XMLmain {
	
	public static void main(String[] args) throws SAXException, IOException {
	
		XMLReader reader;
		reader = XMLReaderFactory.createXMLReader();
		
		InputSource source = new InputSource("files/Afisha.xml");
		
		AfishaXMLHandler handler = new AfishaXMLHandler();
		reader.setContentHandler(handler);
		reader.parse(source);
		
		
		
		
	}

}
