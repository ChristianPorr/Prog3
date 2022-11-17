import java.util.*;
public abstract class Ordine{
  private int statusOrdine;
  private int indiciScelte[]; 
  private double totDaPagare;
  public Ordine(){
    statusOrdine=0;/*significa che non esiste ancora un ordine*/
    totDaPagare=0;
  }
  public void setStatusOrdine(int sOrdine) {
    this.statusOrdine = sOrdine;
  }
  public int getStatusOrdine() {
    return statusOrdine;
  }
  public double contoTot(int indiciP[], int indiciB[]){
    Menu conto = new Menu();
    return   conto.contoTot(conto.prendiContoBevande(indiciP),conto.prendiContoBevande(indiciB));
  }
  

}