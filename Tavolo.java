import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class Tavolo{
    
	   // private HashMap<String, Integer> posByName = new HashMap<String, Integer>();//FlyWeight
	    private Integer numTavolo;
	    private boolean chiusuraTavolo = false;
	    private ArrayList<Ordine> ordini  = new ArrayList<Ordine>();
	    private Ordine statusOrdine;
	    private Double tot;
	    /*private ArraList<Pietanze> carrello;*/
	        public Tavolo(){
	            /*costruttore*/
	            this.statusOrdine=new Ordine();
	            this.tot=0.0;
	            }
	    public Double getTot() {
	    	return tot;
	    }
	    public boolean getChiusura(){
	        return this.chiusuraTavolo;
	    }
	    public void setChiusura(){//set variabile booleana
	        this.chiusuraTavolo=true;
	        this.resocontoOrdini();
	    }
	    public void setNonChiuso(){
	        this.chiusuraTavolo=false;
	    }
	    public int getNumTav(){
	        return this.numTavolo;
	    }
	    public void setStatusOrdine(State stato) {
	    	this.statusOrdine.setState(stato);
	    }
	    public State getStatusOrdine() {
	    	return this.statusOrdine.getState();
	    }
	    public void setNumTav(int numT) {
	    	this.numTavolo=numT;
	    }
	    public Ordine getOrdineFinale() {
	    	return this.statusOrdine;
	    }
	    public void addOrdine(Ordine newOrder) {
	    	this.ordini.add(newOrder);
	    }
	    public ArrayList<Ordine> getOrdine() {
	    	return ordini;
	    }
	    
	    public void resocontoOrdini() {
	    	for(Ordine ord : ordini) { //PER OGNI ORDINE PRESENTE NELLA LISTA ORDINI
	    		
	    		for(Pietanze pietanzaInOrdine : ord.getPietanze()) { //PER OGNI PIETANZA PRESENTE ALL'INTERNO DELL'ORDINE
	    			
	    			statusOrdine.checkPietanza(pietanzaInOrdine, pietanzaInOrdine.getQnt()); /*CONTROLLA SE LA PIETANZA IN ESAME
	    																					E' PRESENTE NELL'ORDINE TOTALE DEL TAVOLO.*/
	    			
	    			/*il nome della pietanza sarà la chiave per vedere se esiste. getPosizione sara' in una nuova classe  dove ci sara'
	    			 * un HashMap<NomePietanza, posizione> final che si chiama posByName che all'interno di getPosizione
	    			 *  int posizione = posByName.get(nomeP) (passato in input). se posizione è null allora prendi HashMap.size() e dagli
	    			 *  come posizione il size posByName.put(nomeP,posizione) altrimenti se gia esiste dagli quella posizione
	    			 * 
	    			tmp = this.posByName.get(pietanzaInOrdine.getNome());
	    			
	    			if(tmp == null) {
	    				tmp = posByName.size();
	    				posByName.put(pietanzaInOrdine.getNome(), tmp);
	    				statusOrdine.aggiungiPietanza(pietanzaInOrdine.getNome(), pietanzaInOrdine.getQnt());
	    			} else {
	    				statusOrdine.ge
	    			}*/
	    			
	    		}
	    		
	    	}
	    	
	    	this.contoTotale();
	    	
	    }
	    
	    private void contoTotale() {
	    	Menu menu = new Menu();
	    	int i,j;
	    	double sumtot=0;
	    	
	 
	    	for(i=0;i<menu.sP.size();i++) {
	    		for(j=0;j<this.statusOrdine.getPietanze().size();j++) {
	    			if(menu.sP.get(i).getNome()==this.statusOrdine.getPietanze().get(j).getNome()) {
	    				sumtot=sumtot+(menu.sP.get(i).getPrezzo()*this.statusOrdine.getPietanze().get(j).getQnt());
	    			}
	    		}
	    	}
	    	for(i=0;i<menu.sB.size();i++) {
	    		for(j=0;j<this.statusOrdine.getPietanze().size();j++) {
	    			if(menu.sB.get(i).getNome()==this.statusOrdine.getPietanze().get(j).getNome()) {
	    				sumtot=sumtot+(menu.sB.get(i).getPrezzo()*this.statusOrdine.getPietanze().get(j).getQnt());
	    			}
	    		}
	    	}
	    	for(i=0;i<menu.sPP.size();i++) {
	    		for(j=0;j<this.statusOrdine.getPietanze().size();j++) {
	    			if(menu.sPP.get(i).getNome()==this.statusOrdine.getPietanze().get(j).getNome()) {
	    				sumtot=sumtot+(menu.sPP.get(i).getPrezzo()*this.statusOrdine.getPietanze().get(j).getQnt());
	    			}
	    		}
	    	}
	    	this.tot=sumtot;
	    }
	    
	    	
	    }