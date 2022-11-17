import java.util.*;
public class Prenotazione extends AdminTools{
    private static int idPrenotazione;
    private double orarioP;
    /*COSTRUTTORE*/ 
    public Prenotazione(int idPrenotazione, double orarioP){
    idPrenotazione++;
    /*orarioP=orario che chiama*/;
    }
    public class InSala{
        
        private int numPersone;
        public void aggiungiPrenotazione(Tavolo numT){
            boolean status;
            status=numT.getStatus();
            if(status=true){
                /*display che non si puo prenotare in questo tavolo*/
                  }
            else
                numT.setOccupato();
                /*il tavolo era libero quindi diventa occupato cioe
                prenotato*/
            }
        public void eliminaPrenotazione(Tavolo numT){
                 numT.setNonOccupato();
                 numT.eliminaOra();
                 /*eliminazione prenotazione/libera tavolo */
            }
        public void cambiaOrario(Tavolo numT, double h){
             numT.setOra(h);
             /*input tavolo e l'ora usare questo metodo anche
             per modificare l'orario eventulamente gia inserito*/
             }
         }
    
    public class AsportoRitiro extends Ordine{
        public int statusOrdine;
        public static int orderCount;
        private double totDaPagare;
        /*private lista<E> carrello; necessito di creare il menu per questa funzione*/
        public AsportoRitiro(){
            /*costruttore*/
            orderCount++;
            statusOrdine=0;/*significa che non esiste ancora un ordine*/
            totDaPagare=0;                            
            }
        /*Lista di cosa ha preso*/
        
    }
    /*Da vedere in base al numero di persone che si devono sedere */
    public void aggiungiPrenotazione(ArrayList<Tavolo> lista, int n, String nominativo, double h){
        boolean bool;
        bool=lista.get(0).getStatus();
        int i=1;
        while(bool=true && lista.get(i).getMaxPersone()>n && i<lista.size()){
            i++;
            bool=lista.get(i).getStatus();
        }
        if(bool=true){
            System.out.println("Non ci sono tavoli disponibili!");
        }
        else{
            lista.get(i).setOccupato();
            lista.get(i).setNominativo(nominativo);
            lista.get(i).setOra(h);
            }

    }
    public void eliminaPrenotazione(Tavolo numT){
        numT.eliminaOra();
        numT.setNominativo("");
        numT.setNonOccupato();
    }


    }