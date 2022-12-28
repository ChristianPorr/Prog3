import java.util.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class Tavolo extends Ordine{ 
    private final int min=2;/*num minimo di persone a tavolo */
    private final int max=16;/*num minimo di persone a tavolo */
    private int medium=((max-min)+1);
    private int var; /*variabile per il random */
    private static int numTavoloStatic;
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
    public void prendiOrd(Vector<String> scelte, Vector<Integer> qnt){
    	int i, j;
    	for(i=0;i<scelte.size();i++) {
    		//if(scelte.get(i).equals(ordineS)) {//se esiste già l'elemento scelto va a vedere dove sta e aggiorna
	    		for(j=0;j<ordineS.size();i++) {
	    			if(scelte.get(i)==ordineS.get(j)){//l'elemento già esisteva aggiorna la quantità
	    				if(ordineQ.get(j)+qnt.get(i)>0){
	    					System.out.println(ordineQ.get(j)+qnt.get(i));
	    					this.ordineQ.set(j, ordineQ.get(j)+qnt.get(i));
	    				} else {
	    					System.out.println("negativo");
	    					showMessageDialog(null,"La quantita' di un elemento non può essere negativa!",
	    							"Attenzione!", JOptionPane.WARNING_MESSAGE);
	    					//QUA DEVI CANCELLARE SE LA QUANTITA' E' 0
	    				}
	    				
	    			}	
	    		}
    		//} else { errore
    			//se è un elemento nuovo aggiungilo
    			if(qnt.get(i)>0) {
    				
    				this.ordineS.add(scelte.get(i));
        			this.ordineQ.add(qnt.get(i));
        			System.out.println(ordineS.get(i));
    			} else if(qnt.get(i)==0){
					showMessageDialog(null,"La quantita' di un elemento non può essere nulla!",
							"Attenzione!", JOptionPane.WARNING_MESSAGE);
					//QUA DEVI CANCELLARE SE LA QUANTITA' E' 0
					
				}
    			
    			
    		//}
    	}
    	
    	
		/*this.ordineS.set(i, scelte.get(i));
		this.ordineQ.set(i, qnt.get(i));*/
    	
    }
    
}
