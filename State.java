/*Pattern State*/
/*Classe astratta che specifica i 3 metodi che dovranno estendere le classi State e ne aggiorna lo stato attuale in base all'ordine*/
public abstract class State {
	protected Ordine ordine;
	
	public State(Ordine ordine) {
		// TODO Auto-generated constructor stub
	}

	public void Ordine(Ordine ordine) {
		this.ordine = ordine;
	}
	
	/*Questi 3 metodi sono bottoni da implementare*/
	
	public abstract String ordineNullo();
	public abstract String ordineRicevuto();
	public abstract String ordineConsegnato();
	
}
