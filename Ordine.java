/*Pattern State*/
/**/

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
  
  public String Consegnato() {
	  return "Ordine consegnato";
  }
  
  public String Nessuno() {
	  return "Non ci sono ordini";
  }

}