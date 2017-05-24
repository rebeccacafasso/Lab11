package it.polito.tdp.bar.model;

public class Event implements Comparable<Event> {
	
	
	public enum EventType {
		ARRIVO_GRUPPO_CLIENTI,
		USCITA_GRUPPO_CLIENTI,
	}
	
	private EventType tipo;
	private int time; 
	private Gruppo gruppo;
	private Tavolo tavolo;
	
	
	public Event(EventType tipo, int time, Gruppo gruppo) {
		
		this.tipo = tipo;
		this.time = time;
		this.gruppo = gruppo;
		
	}

	@Override
	public int compareTo(Event other) {
		return this.time-other.time;
		
	}
	
	

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public EventType getTipo() {
		return tipo;
	}

	public void setTipo(EventType tipo) {
		this.tipo = tipo;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	@Override
	public String toString() {
		return "Event [tipo=" + tipo + ", time=" + time + ", gruppo=" + gruppo + "]";
	}



}
