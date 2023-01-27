import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class Tavolo{ 
    private int var; /*variabile per il random */
    /*private static int numTavoloStatic=0;*/
    private Integer numTavolo;
    private boolean occupato;
    private ArrayList<Ordine> ordini  = new ArrayList<Ordine>();
    private ArrayList<String> ordineS = new ArrayList<String>();
    private ArrayList<Integer> ordineQ = new ArrayList<Integer>();
    private Ordine statusOrdine;
    private double totDaPagare;
    /*private ArraList<Pietanze> carrello;*/
        public Tavolo(){
            /*costruttore*/
            this.statusOrdine=new Ordine();
            }
    public boolean getStatus(){
        return this.occupato;
    }
    public void setOccupato(){//set variabile booleana
        this.occupato=true;
    }
    public void setNonOccupato(){
        this.occupato=false;
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
    public void prendiOrd(Vector<String> scelte, Vector<Integer> qnt, File txtOw, Ordine ord) {
    	int i, j;
    	Menu menu = new Menu();
    	Boolean esiste=false;
    	ArrayList<Integer> indiciAgg = new ArrayList<Integer>();
    	ArrayList<Integer> indiciNew = new ArrayList<Integer>();
    	
    	ordini.add(ord);
    	ord.showP();
    	
    	for(i=0;i<scelte.size();i++) {
    		for(j=0;j<ordineS.size();j++) {
    			if(ordineS.get(j)==scelte.get(i)) {//controllo se esistono gli elementi all'interno della lista
    				esiste = true;
    				//System.out.println("esiste");
    				indiciAgg.add(i);
    				//se esistono salvo dentro un vettore di indici gli indici dove esistono
    			} else {
    				esiste=false;
    			}
    		}
    		
    		if(!esiste) {
    			//System.out.println("aggiunto nuovo elemento, situato in pos "+i);
    			indiciNew.add(i);
    		}
    	}
    		for(i=0;i<indiciAgg.size();i++) {
    			//vado a prendere l'indice di quello che esiste e sommare le quantità degli elementi uguali
    			ordineQ.set(indiciAgg.get(i), qnt.get(indiciAgg.get(i))+ordineQ.get(indiciAgg.get(i)) );//aggiornamento
    			//System.out.println("ho aggiornato "+ordineS.get(indiciAgg.get(i))+"con la quantità totale di "+ordineQ.get(indiciAgg.get(i)) );
    		}
    		for(i=0;i<indiciNew.size();i++) {
    			//vado ad aggiungere gli elementi nuovi
    			ordineS.add(scelte.get(indiciNew.get(i)));
    			ordineQ.add(qnt.get(indiciNew.get(i)));
    			//System.out.println("ho aggiunto "+scelte.get(indiciNew.get(i)) );
    		}
    		//System.out.println("di seguito la lista dei prodotti:");
    	for(i=0;i<ordineS.size();i++) {
    		if(ordineQ.get(i)<=0) {
    			ordineQ.remove(i);
    			ordineS.remove(i);
    		}
    	}
    	/*
    	for(i=0;i<ordineS.size();i++) {
    		System.out.println(ordineS.get(i)+" quantita'="+ordineQ.get(i));
    	}
    	System.out.println(this.numTavolo);*/
    	totSpeso();
    	
    	try {
    	      FileWriter myWriter = new FileWriter(txtOw.getName(),false);
    	      
    	      for(i=0;i<this.ordineS.size();i++) {
    	    	  
    	    	  for(j=0;j<menu.sP.size();j++) {
    	    		  if(menu.sP.get(j).getNome()==ordineS.get(i)){
    	    			  myWriter.write(this.ordineS.get(i)+" x"+this.ordineQ.get(i)+" ("+menu.sP.get(j).getPrezzoS()+" euro) \n");
    	    		  }
    	    	  }
    	    	  for(j=0;j<menu.sB.size();j++) {
    	    		  if(menu.sB.get(j).getNome()==ordineS.get(i)){
    	    			  myWriter.write(this.ordineS.get(i)+" x"+this.ordineQ.get(i)+" ("+menu.sB.get(j).getPrezzoS()+" euro) \n");
    	    		  }
	    		  }
    	    	  for(j=0;j<menu.sPP.size();j++) {
    	    		  if(menu.sPP.get(j).getNome()==ordineS.get(i)){
    	    			  myWriter.write(this.ordineS.get(i)+" x"+this.ordineQ.get(i)+" ("+menu.sPP.get(j).getPrezzoS()+" euro) \n");
    	    		  }
	    		  }
    	    	
    	    	  }
    	      myWriter.write("Totale: "+this.totDaPagare+" euro");
    	      myWriter.close();
    	      System.out.println("Successfully wrote to the file.");
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    	
    }
    
    public void totSpeso() {
    	Menu menu = new Menu();
    	int i,j;
    	double sumtot=0;
    	
    	for(i=0;i<menu.sP.size();i++) {
    		for(j=0;j<ordineS.size();j++) {
    			if(menu.sP.get(i).getNome()==ordineS.get(j)) {
    				sumtot=sumtot+(menu.sP.get(i).getPrezzo()*ordineQ.get(j));
    			}
    		}
    	}
    	for(i=0;i<menu.sB.size();i++) {
    		for(j=0;j<ordineS.size();j++) {
    			if(menu.sB.get(i).getNome()==ordineS.get(j)) {
    				sumtot=sumtot+(menu.sB.get(i).getPrezzo()*ordineQ.get(j));
    			}
    		}
    	}
    	for(i=0;i<menu.sPP.size();i++) {
    		for(j=0;j<ordineS.size();j++) {
    			if(menu.sPP.get(i).getNome()==ordineS.get(j)) {
    				sumtot=sumtot+(menu.sPP.get(i).getPrezzo()*ordineQ.get(j));
    			}
    		}
    	}
    	this.totDaPagare=sumtot;
    }
    	
    }
