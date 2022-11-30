/*Pattern State*/
/*Ordine completato*/
public class DeliveredState extends State {

	public DeliveredState(Ordine ordine) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ordineConsegnato() {
		ordine.setState(new DeliveredState(ordine));
		return ordine.Consegnato();
	}

}
