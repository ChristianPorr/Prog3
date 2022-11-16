import java.lang.reflect.Array;
import java.util.*;
public abstract class Ordine{
  private int statusOrdine;
  private int indiciScelte[]; 
  private double totDaPagare;
  public double contoTot(int indiciP[], int indiciB[]){
    Menu conto = new Menu();
    return   conto.contoTot(conto.prendiContoBevande(indiciP),conto.prendiContoBevande(indiciB));
  }
  

}