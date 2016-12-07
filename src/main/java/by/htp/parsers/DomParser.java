package by.htp.parsers;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import by.htp.entity.Event;
import by.htp.entity.Exhibition;
import by.htp.entity.Film;
import by.htp.entity.Opera;

public class DomParser {

	public static void main(String[] args) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		Document document;
		Element afishaRoot; 

		NodeList eventsNode = null;

		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new InputSource("files/Afisha.xml"));

			afishaRoot = document.getDocumentElement(); //root element
			
			String att = afishaRoot.getAttribute("city");
			System.out.println(att);
			
			//document.getElementsByTagName("events");

			eventsNode = afishaRoot.getElementsByTagName("events");// get all events as Nodes (tags)
															
			for (int i = 0; i < eventsNode.getLength(); i++) {
				Element events = (Element) eventsNode.item(i); // get concrete event tag as Element from events tag Node

				NodeList allEvents = events.getChildNodes(); // get all event tags 

				for (int j = 0; j < allEvents.getLength(); j++) {
					Node eventNode = allEvents.item(j); // concrete event Node

					Element eventElement;

					if (eventNode.getNodeType() == 1) {
						eventElement = (Element) eventNode;
						Event eventEntity = buildEvent(eventElement, eventNode.getNodeName());
						System.out.println(eventEntity);
					}
				}
			}

		} catch (SAXException | ParserConfigurationException | ParseException | IOException e) {

		}

	}

	public static String getSingleElementContent(Element element, String tagName) {

		NodeList list = element.getElementsByTagName(tagName);
		Element el = (Element) list.item(0);

		String content = el.getTextContent().trim();
		return content;

	}

	public static Event buildEvent(Element element, String nodeName) throws ParseException {
		Event event = null;
		System.out.println("nodeName: " + nodeName);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		switch (nodeName) {
		case "film":
			Film film = new Film();
			film.setTitle(getSingleElementContent(element, "title"));
			film.setPlace(getSingleElementContent(element, "place"));
			film.setPrice(new BigDecimal(getSingleElementContent(element, "price")));
			film.setDate(df.parse(getSingleElementContent(element, "date")));
			film.setTime(getSingleElementContent(element, "time"));
			event = film;
			break;
		case "opera":
			Opera opera = new Opera();
			opera.setTitle(getSingleElementContent(element, "title"));
			opera.setPlace(getSingleElementContent(element, "place"));
			opera.setPrice(new BigDecimal(getSingleElementContent(element,"price")));
			opera.setDate(df.parse(getSingleElementContent(element, "date")));
			opera.setTime(getSingleElementContent(element, "time"));
			event = opera;
			break;
		case "exsibition":
			Exhibition exsibition = new Exhibition();
			exsibition.setTitle(getSingleElementContent(element, "title"));
			exsibition.setPlace(getSingleElementContent(element, "place"));
			exsibition.setPrice(new BigDecimal(getSingleElementContent(element,"price")));
			exsibition.setDate(df.parse(getSingleElementContent(element, "date")));
			exsibition.setTime(getSingleElementContent(element, "time"));
			event = exsibition;
			break;
		}
		return event;
	}

}
