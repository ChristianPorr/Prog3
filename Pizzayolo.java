public class Pizzayolo implements Cucina{
    public void ordinePresoInCarico(Tavolo numT){
        numT.setStatusOrdine(1);
    }
    public void ordineInLavorazione(Tavolo numT){
        numT.setStatusOrdine(2);
    }
    public void ordineCompletato(Tavolo numT){
        numT.setStatusOrdine(3);
    }
    
    public void ordinePresoInCarico(Prenotazione.AsportoRitiro numO){
        numO.setStatusOrdine(1);
    }
    public void ordineInLavorazione(Prenotazione.AsportoRitiro numO){
        numO.setStatusOrdine(2);
    }
    public void ordineCompletato(Prenotazione.AsportoRitiro numO){
        numO.setStatusOrdine(3);
    }
}