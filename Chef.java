import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Chef extends Frame implements Cuoco{


	private ArrayList<String> listaPrimiPiatti = new ArrayList<String>();
	private ArrayList<Ordine> listaOrdini = new ArrayList<Ordine>();
	JTextArea textArea = new JTextArea(10,20);
	
	private LinkedList<LinkedList<String>> TODO = new LinkedList<LinkedList<String>>();//Questo dovrebbe essere mostrato tramite biglietto alla cucina
	
	public Chef() {
		frame.setTitle("Gestionale Ristorante-Chef");
		panel = new JPanel(new FlowLayout());
		
		textArea.setEditable(false);
		//fare delle piccole cards con all'interno l'ordine. IDEA aggiungere ogni volta dei pannelli con il bottone ai lati del PANNELLO al centro la text area
		panel.add(textArea);
		
		frame.add(panel);
		
		System.out.println("Chef creato!");
		Menu menu = new Menu();
		for(Pietanze element : menu.sPP) {
			listaPrimiPiatti.add(element.getNome());
		}
	}
	
	@Override
	public void updateTODO(Tavolo tav, Ordine ordine) {
		//String numT=Integer.toString(tav.getNumTav());
		Ordine ordTmp = new Ordine(ordine.getNumTavolo());
		/*Prendo le pietanze che riesce a fare il Pizzaiolo (pizze) e le aggiungo in ordine tmp che poi verra aggiunto agli ordini
		 *del pizzaiolo e che verra mostrato nel pannello */
		 
		for(Pietanze elem : ordine.getPietanze()) {
			for(String nomePietanza : listaPrimiPiatti) {
				if(nomePietanza==elem.getNome()) {
					ordTmp.aggiungiPietanza(nomePietanza, elem.getQnt());
				}
			}
		}
		listaOrdini.add(ordTmp);
		tav.setStatusOrdine(new OrdineRicevuto());
		
			this.textArea.append("[ORDINE] Ho aggiunto il tavolo "+ordTmp.getNumTavolo()+"\n");
			for(Pietanze pietanza : ordTmp.getPietanze()) {
				this.textArea.append("[ORDINE] Pietanza: "+pietanza.getNome()+" qnt: "+pietanza.getQnt()+"\n");
			}
		
		
		//Questo sotto è quello vecchio
			
		/*
		Boolean esiste=false;
		//outerloop:
		System.out.println("Aggiunto allo chef la lista");
		LinkedList<String> inside = new LinkedList<String>();
		for(int i=0;i<lista.size();i++) {
			
			for(int j=0;j<listaPrimiPiatti.size();j++) {
				
				if(lista.get(i)==listaPrimiPiatti.get(j)) {//Aggiungi se contenuto nella lista delle pizze con la relativa quantitÃ 
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
						System.out.println("Comanda gia'  esistente, aggiornamento...");
						TODO.remove(i);
						TODO.add(inside);
						esiste=true;
				}
				
			}
			if(esiste==false) TODO.add(inside);//Se non esisteva allora aggiungilo
			tav.setStatusOrdine(new OrdineRicevuto());
			/*tavoli.add(tav);*/
	
		
	}
	
	public Tavolo cucina(Tavolo tav) {
		System.out.println("Lo Chef sta preparando gli ingredienti");
		/*Questo sara il bottone che toglie da listaOrdini l'ordine selezionato
		 * e dal frame il pannellino contenente la card dell'ordine ( frame.remove(PANNELLO_ORDINE_SCELTO) )
		 */
		Boolean consegnato=false;
		for(int i=0;i<TODO.size();i++) {
			
			for(int j=0;j<TODO.get(i).size();j++) {
				if(j==0) {
					System.out.println("Sto completando il "+TODO.get(i).get(j));
					String temp=TODO.get(i).get(j).substring(9, 10);
					if(tav.getNumTav()==Integer.parseInt(temp)) {
						tav.setStatusOrdine(new OrdineConsegnato());
						consegnato=true;
					}
					j++;
				}
				
				try {
					System.out.println("Sto sta cucinando: "+TODO.get(i).get(j));
					Thread.sleep(3000);
					System.out.println("fuori uno");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				}
			}
			
		}
		if(!consegnato) tav.setStatusOrdine(new OrdineConsegnato());//significa che non c'era ma comunque lo faccio valere come consegnato perche' altrimenti non accende il bottone
		return tav;
	}
	
	

}