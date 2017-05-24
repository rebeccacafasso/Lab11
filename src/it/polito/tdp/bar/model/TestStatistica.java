package it.polito.tdp.bar.model;

public class TestStatistica {

	public static void main(String[] args) {
		
		Statistica s = new Statistica();
		
		int time = 0;
		for (int i=0; i<2000; i++){
			time +=(int)(1+ Math.random()*10);
			s.addGruppo(time);
		}
		s.run();
		System.out.println(s.getNumero_clienti_insoddisfatti());
		System.out.println(s.getNumero_clienti_soddisfatti());
		System.out.println(s.getNumero_totale_clienti());
	}

}
