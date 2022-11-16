public class Cuoco implements Cucina{
    private final int maxOrd=50;
    public void ordinePresoInCarico(Tavolo numT){
        numT.statusOrdine=1;
    }
    public void ordineInLavorazione(Tavolo numT){
        numT.statusOrdine=2;
    }
    public void ordineCompletato(Tavolo numT){
       numT.statusOrdine=3;
    }
}
