import java.util.*;

public class Pizzayolo implements Cuoco{
	
	State ordRic;
	State ordCons;

	private ArrayList<String> listaPizze = new ArrayList<String>();
	
	private LinkedList<LinkedList<String>> TODO = new LinkedList<LinkedList<String>>();
	
	public Pizzayolo() {
		System.out.println("Pizzayolo creato!");
		Menu menu = new Menu();
		for(Pietanze element : menu.sP) {
			listaPizze.add(element.getNome());
		}
	}
	
	@Override
	public void updateTODO( Vector <String> lista, Vector<Integer> qnt, Tavolo tav) {
		String numT=Integer.toString(tav.getNumTav());
		Boolean esiste=false;
		//outerloop:
		System.out.println("Aggiunto al pizzaiolo la lista");
		LinkedList<String> inside = new LinkedList<String>();
		for(int i=0;i<lista.size();i++) {
			
			for(int j=0;j<listaPizze.size();j++) {
				
				if(lista.get(i)==listaPizze.get(j)) {//Aggiungi se contenuto nella lista delle pizze con la relativa quantitÃ 
					System.out.println("Ho aggiunto: "+lista.get(i));
					inside.add(lista.get(i)+" x"+qnt.get(i));
				}
			}
		}
		
		if(!inside.isEmpty()) {
			String bla="Tavolo n:"+numT;
			inside.addFirst(bla);
			System.out.println(inside);
			for(int i=0;i<TODO.size();i++) {
				
				if(bla==TODO.get(i).get(0)) {
						System.out.println("Comanda gia'  esistente, aggiornamento...");
						TODO.remove(i);
						TODO.add(inside);
						esiste=true;
				}
				
			}
			if(esiste==false) TODO.add(inside);//Se non esisteva allora aggiungilo
			ordRic = new OrdineRicevuto();
			tav.setStatusOrdine(ordRic);
		}
		
	}
	
	public Tavolo infornaPizze(Tavolo tav) {
		System.out.println("Il pizzaiolo sta infornando le pizze");
		//System.out.println(TODO);
		Boolean consegnato=false;
		ordCons = new OrdineConsegnato();
		for(int i=0;i<TODO.size();i++) {
			
			for(int j=0;j<TODO.get(i).size();j++) {
				if(j==0) {
					System.out.println("Sto completando il "+TODO.get(i).get(j));
					String temp=TODO.get(i).get(j).substring(9, 10);
					if(tav.getNumTav()==Integer.parseInt(temp)) {
						tav.setStatusOrdine(ordCons);
						consegnato=true;
					}
					j++;
				}
				
				try {
					System.out.println("Sto infornando: "+TODO.get(i).get(j));
					Thread.sleep(3000);
					System.out.println("fuori uno");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				}
			}
			
		}
		if(!consegnato) tav.setStatusOrdine(ordCons);//significa che non c'era ma comunque lo faccio valere come consegnato perche' altrimenti non accende il bottone
		return tav;
	}
	
	

}
