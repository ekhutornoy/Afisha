package by.htp.entity;

import java.util.HashSet;
import java.util.Set;

public class Afisha extends Event {
	
	private Set<Event> events;
	private String city;
	
	
	public Afisha(String city) {
		super();
		events = new HashSet<Event>();
		this.city = city;
	}

	@Override
	public String toString() {
		return "Afisha [events=" + events + "]";
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	public boolean addEvent(Event event){
		if (event != null){
		return events.add(event);
		}
		return false;
	}
	
	Set<Event> viewEvents(){
		
		return events;
	
    }
}
