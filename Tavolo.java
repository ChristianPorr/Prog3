import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class Tavolo extends Ordine{ 
    private final int min=2;/*num minimo di persone a tavolo */
    private final int max=16;/*num minimo di persone a tavolo */
    private int medium=((max-min)+1);
    private int var; /*variabile per il random */
    private static int numTavoloStatic=0;
    private int numTavolo;
    private boolean occupato;
    private double oraPrenotata;
    private String nominativo;
    private int maxPersone;
    private Vector<String> ordineS = new Vector<String>();
    private Vector<Integer> ordineQ = new Vector<Integer>();
    public int statusOrdine;
    private double totDaPagare;
    /*private ArraList<Pietanze> carrello;*/
        public Tavolo(){
            /*costruttore*/
            Random a_caso = new Random();
            var = a_caso.nextInt(medium)+min;
            maxPersone=var;
            numTavoloStatic++;
            numTavolo= numTavoloStatic;
            nominativo=("");
            }
    public boolean getStatus(){
        return this.occupato;
    }
    public void setOccupato(){
        this.occupato=true;
    }
    public void setNonOccupato(){
        this.occupato=false;
    }
    public double getOra(){
        return this.oraPrenotata;
    }
    public void eliminaOra(){
        this.oraPrenotata=0;
    }
    public void setOra(double h){
        this.oraPrenotata=h;
    }
    public int getNumTav(){
        return this.numTavolo;
    }
    public int getMaxPersone(){
        return this.maxPersone;
    }
    public void setNominativo(String nome){
        this.nominativo=nome;
    }
    public void prendiOrd(Vector<String> scelte, Vector<Integer> qnt, File txtOw) {
    	int i, j;
    	Menu menu = new Menu();
    	Boolean esiste=false;
    	Vector<Integer> indiciAgg = new Vector<Integer>();
    	Vector<Integer> indiciNew = new Vector<Integer>();
    	Vector<String> miss = new Vector<String>();
    	
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
    		int n;
    		n=ordineS.size();
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
    	//System.out.println("la somma totale e' = "+this.totDaPagare);
    	
    	try {
    	      FileWriter myWriter = new FileWriter(txtOw.getName(),false);
    	      
    	      for(i=0;i<this.ordineS.size();i++) {
    	    	  
    	    	  for(j=0;j<menu.sP.size();j++) {
    	    		  if(menu.sP.get(j).getNome()==ordineS.get(i)){
    	    			  myWriter.write(this.ordineS.get(i)+" x"+this.ordineQ.get(i)+" ("+menu.sP.get(j).getPrezzoS()+"€) \n");
    	    		  }
    	    	  }
    	    	  for(j=0;j<menu.sB.size();j++) {
    	    		  if(menu.sB.get(j).getNome()==ordineS.get(i)){
    	    			  myWriter.write(this.ordineS.get(i)+" x"+this.ordineQ.get(i)+" ("+menu.sB.get(j).getPrezzoS()+"€) \n");
    	    		  }
	    		  }
    	    	
    	    	  }
    	      myWriter.write("Totale: "+this.totDaPagare);
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
    	this.totDaPagare=sumtot;
    }
    	
    }
