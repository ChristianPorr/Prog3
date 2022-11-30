/*Pattern State*/
/*Ordine preso in carico*/
public class ReadyState extends State {

	public ReadyState(Ordine ordine) {
		super(ordine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ordineRicevuto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ordineInLavorazione() {
		ordine.setState(new DeliveredState(ordine));
		return ordine.Completato();
	}

	@Override
	public String ordineConsegnato() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
