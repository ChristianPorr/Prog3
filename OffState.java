/*Pattern State*/
/*Nessun ordine*/

public class OffState extends State {
	public OffState(Ordine ordine) {
		super(ordine);
	}
		
	@Override
	public String ordineRicevuto() {
		ordine.setState(new ReadyState(ordine));
		return ordine.Ricevuto();
	}

	@Override
	public String ordineInLavorazione() {
		ordine.setState(new ReadyState(ordine));
		return ordine.InLavorazione();
	}

	@Override
	public String ordineConsegnato() {
		return null;
	}
		
}


