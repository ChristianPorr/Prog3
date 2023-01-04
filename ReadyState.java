/*Pattern State*/
/*Si attiva quando si prende l'ordinazione di un tavolo*/
public class ReadyState extends State {

	public ReadyState(Ordine ordine) {
		super(ordine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ordineRicevuto() {
		ordine.setState(new DeliveredState(ordine));
		return ordine.Ricevuto();
	}

	@Override
	public String ordineConsegnato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ordineNullo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
