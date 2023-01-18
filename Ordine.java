
public class Ordine implements State {
	private State stato;
	public Ordine() {
		this.stato=new NoState();
	}
	
	public void setState(State state) {
		this.stato=state;
	}
	
	public State getState() {
		return this.stato;
	}
	@Override
	public void avanzaStato() {
		this.stato.avanzaStato();
		System.out.println("stato avanzato");
	}
}
