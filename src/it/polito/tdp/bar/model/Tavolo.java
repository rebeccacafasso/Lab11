package it.polito.tdp.bar.model;

public class Tavolo {

	private int num_posti;
	private boolean isOccupato;
	
	

	public Tavolo(int num_posti) {
		super();
		this.num_posti = num_posti;
		this.isOccupato=false;
	}

	public int getNum_posti() {
		return num_posti;
	}

	public void setNum_posti(int num_posti) {
		this.num_posti = num_posti;
	}

	public boolean isOccupato() {
		return isOccupato;
	}

	public void setOccupato(boolean isOccupato) {
		this.isOccupato = isOccupato;
	}
	
	
	
	
	
	
}
