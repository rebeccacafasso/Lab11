package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;






public class Statistica {
	
	private int NT=15;
	private int numero_totale_clienti;
	private int numero_clienti_soddisfatti;
	private int numero_clienti_insoddisfatti;
	private int DURATA_MIN= 60;
	private int DURATA_MAX= 120;
	
	private List <Tavolo> tavoli_disponibili;
	private int tav_disponibili;
	
	PriorityQueue<Event> queue ;
	
	public Statistica(){
		
		tavoli_disponibili = new ArrayList <Tavolo>();
		this.tav_disponibili=15;
		this.aggiungiTavoli();
		this.queue = new PriorityQueue<>() ;
		
	}
	
	public void aggiungiTavoli(){
		this.tavoli_disponibili.add(new Tavolo(10));
		this.tavoli_disponibili.add(new Tavolo(10));
		this.tavoli_disponibili.add(new Tavolo(8));
		this.tavoli_disponibili.add(new Tavolo(8));
		this.tavoli_disponibili.add(new Tavolo(8));
		this.tavoli_disponibili.add(new Tavolo(8));
		this.tavoli_disponibili.add(new Tavolo(6));
		this.tavoli_disponibili.add(new Tavolo(6));
		this.tavoli_disponibili.add(new Tavolo(6));
		this.tavoli_disponibili.add(new Tavolo(6));
		this.tavoli_disponibili.add(new Tavolo(4));
		this.tavoli_disponibili.add(new Tavolo(4));
		this.tavoli_disponibili.add(new Tavolo(4));
		this.tavoli_disponibili.add(new Tavolo(4));
		this.tavoli_disponibili.add(new Tavolo(4));
	
	}
	
	
	public int getNT() {
		return NT;
	}
	public int getNumero_totale_clienti() {
		return numero_totale_clienti;
	}
	public int getNumero_clienti_soddisfatti() {
		return numero_clienti_soddisfatti;
	}
	public int getNumero_clienti_insoddisfatti() {
		return numero_clienti_insoddisfatti;
	}
	
	
	
	public void addGruppo(int time){
		
		int num_p = (int) (1+Math.random()*10);
		int durata = (int)(60+ Math.random()*61);
		double tolleranza = Math.random();
		
		Gruppo g = new Gruppo(num_p, durata, tolleranza);
		queue.add(new Event(EventType.ARRIVO_GRUPPO_CLIENTI, time, g));
	}
	
	
	public void run(){
		while(!queue.isEmpty()) {
			Event e = queue.poll() ;
			Gruppo g = e.getGruppo();
			switch(e.getTipo()) {
			case ARRIVO_GRUPPO_CLIENTI:
				
				
				//tavolo non disponibile
				if (this.tav_disponibili==0){
					double ok = Math.random();
					if (ok > g.getTolleranza()){//clienti ins
						this.numero_clienti_insoddisfatti += g.getNum_persone();
						this.numero_totale_clienti += g.getNum_persone();
						
					}else{
						//clienti soddisfatti
						this.numero_clienti_soddisfatti += g.getNum_persone();
						this.numero_totale_clienti += g.getNum_persone();
						}
				}else{
			// tavolo disponibile
				// --- siete abbastanza?
					Tavolo t = this.trovaTavolo(g.getNum_persone());
					
				
					//--- se si
					
					if (t!=null){
						//occupa tavolo: genero evento di uscita, togliere il tav da disp
						e.setTavolo(t);
						e.getTavolo().setOccupato(true);
						this.tav_disponibili--;
						this.numero_clienti_soddisfatti += g.getNum_persone();
						this.numero_totale_clienti += g.getNum_persone();
						
						queue.add(new Event(EventType.USCITA_GRUPPO_CLIENTI, e.getTime()+g.getDurata(), g));
						
						
					}
						
					//---se no
					if (this.trovaTavolo(g.getNum_persone())==null){
						double ok = Math.random();
						if (ok > g.getTolleranza()){//clienti ins
							this.numero_clienti_insoddisfatti += g.getNum_persone();
							this.numero_totale_clienti += g.getNum_persone();
							
						}else{
							//clienti soddisfatti
							this.numero_clienti_soddisfatti += g.getNum_persone();
							this.numero_totale_clienti += g.getNum_persone();
							}
					}
						
						
						
						//faccio stessa cosa di bancone
						
					}
						
			break;
			case USCITA_GRUPPO_CLIENTI:
				
				 //si libera il tavolo specificato in e 
				//incremento i tav liberi
				//metto false il tavolo
				this.tav_disponibili++;
				e.getTavolo().setOccupato(false);
				
				
				
				
				break;
	}
	}
	
	}

	private Tavolo trovaTavolo(int num_persone) {
		int diffMin=10;
		int diff = 0;
		Tavolo trovato = null;
		for (Tavolo t: this.tavoli_disponibili){
			if (t.isOccupato()==false){
			diff = t.getNum_posti()-num_persone;
			if (diff<diffMin && diff>0 && diffMin < 0.5*t.getNum_posti() ){
				
				diffMin = diff;
				trovato = t;
			}
			}
		}
		return trovato;
		
	}
	
	
	

}
