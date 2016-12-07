package by.htp.dao.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.entity.Event;
import by.htp.entity.Exhibition;
import by.htp.entity.Film;
import by.htp.entity.Opera;

public class AfishaXMLHandler extends DefaultHandler {

	private String value;
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
	
		super.characters(ch, start, length);
	}

	public void endDocument() throws SAXException {
		System.out.println("endDocument");

	}

	public void endElement(String uri, String LocalName, String qName) throws SAXException {
		System.out.println(qName);

	}

	public void startDocument() throws SAXException {
		System.out.println("startDocument");

	}

	public void startElement(String uri, String LocalName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Document");
		attributes.getValue(qName);
		Event event;
		
		if (qName.equals("event")){
			String type = attributes.getValue(qName);
			switch (type){
			case "film":
				event = new Film();
				break;
			case "opera":
				event = new Opera();
			    break;
			case "exhibition":
				event = new Exhibition();
				break;
			
			}
			Event event = new Event();
		}

	}

}

