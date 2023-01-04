/*Pattern State*/
/*Si attiva quando non ci sono ordinazione da ricevere/completare*/

public class OffState extends State {
	public OffState(Ordine ordine) {
		super(ordine);
	}
	
	@Override
	public String ordineNullo() {
		ordine.setState(new DeliveredState(ordine));
		return ordine.Nessuno();
	}
		
	@Override
	public String ordineRicevuto() {
		return null;
	}

	@Override
	public String ordineConsegnato() {
		return null;
	}
		
}


