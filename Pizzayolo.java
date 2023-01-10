import java.util.*;

public class Pizzayolo implements Cuoco{

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
	public void updateTODO( Vector <String> lista, Vector<Integer> qnt, String tav) {
		Boolean esiste=false;
		//outerloop:
		System.out.println("Aggiunto al pizzaiolo la lista");
		LinkedList<String> inside = new LinkedList<String>();
		for(int i=0;i<lista.size();i++) {
			
			for(int j=0;j<listaPizze.size();j++) {
				
				if(lista.get(i)==listaPizze.get(j)) {//Aggiungi se contenuto nella lista delle pizze con la relativa quantità
					System.out.println("Ho aggiunto: "+lista.get(i));
					inside.add(lista.get(i)+" x"+qnt.get(i));
				}
			}
		}
		
		if(!inside.isEmpty()) {
			String bla="Tavolo n:"+tav;
			inside.addFirst(bla);
			System.out.println(inside);
			/*System.out.println("Il pizzaiolo dovrà servire il tavolo: "+tav);
			TODO.add(inside);*/
			for(int i=0;i<TODO.size();i++) {
				
				if(bla==TODO.get(i).get(0)) {
						System.out.println("Comanda gia'� esistente, aggiornamento...");
						TODO.remove(i);
						TODO.add(inside);
						esiste=true;
				}
				
			}
			if(esiste==false) TODO.add(inside);//Se non esisteva allora aggiungilo
		}
		
	}
	
	public void infornaPizze() {
		System.out.println("Il pizzaiolo sta infornando le pizze");
		//System.out.println(TODO);
		for(int i=0;i<TODO.size();i++) {
			
			for(int j=0;j<TODO.get(i).size();j++) {
				if(j==0) {
					System.out.println("Sto completando il "+TODO.get(i).get(j));
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
		
	}
	
	

}
