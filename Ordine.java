/*Pattern State*/


public class Ordine{
  private State state;
  
  public Ordine() {
	  state = new OffState(this); /*Nessun'ordine in carico*/
  }
  
  public void setState(State state) {
	  this.state = state;
  }
  
  public String Ricevuto() {
	  return "Ordine ricevuto";
  }
  
  public String InLavorazione() {
	  return "Ordine in lavorazione";
  }
  
  public String Completato() {
	  return "Ordine completato";
  }
  
  public String Consegnato() {
	  return "Ordine consegnato";
  }

}