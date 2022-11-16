import java.util.*;
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
        public int statusOrdine;
        private double totDaPagare;
        /*private ArraList<Pietanze> carrello;*/
        public Tavolo(){
            /*costruttore*/
            statusOrdine=0;/*significa che non esiste ancora
                                        un ordine*/
            totDaPagare=0;
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
    
}
