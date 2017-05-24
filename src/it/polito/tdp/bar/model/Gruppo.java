package it.polito.tdp.bar.model;

public class Gruppo {
	
	private int num_persone;
	private int durata;
	private double tolleranza;
	
	public Gruppo(int num_persone, int durata, double tolleranza) {
		super();
		this.num_persone = num_persone;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}

	public int getNum_persone() {
		return num_persone;
	}

	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public double getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(double tolleranza) {
		this.tolleranza = tolleranza;
	}

	@Override
	public String toString() {
		return "Gruppo [num_persone=" + num_persone + ", durata=" + durata + ", tolleranza=" + tolleranza + "]";
	}
	
	

}
