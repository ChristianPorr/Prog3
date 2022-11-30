/*Pattern State*/

public abstract class State {
	protected Ordine ordine;
	
	public State(Ordine ordine2) {
		// TODO Auto-generated constructor stub
	}

	public void Ordine(Ordine ordine) {
		this.ordine = ordine;
	}
	
	/*Questi 3 metodi sono bottoni da implementare*/
	
	public abstract String ordineRicevuto(); 
	public abstract String ordineInLavorazione();
	public abstract String ordineConsegnato();
	
}
