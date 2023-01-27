import java.util.ArrayList;

public class Ordine {
	private State stato;
	private static Menu menu = new Menu();
	private static Integer numeroOrdineTotale = 0;
	private Integer numTavolo;
	private Integer numeroOrdine;
	private ArrayList<Pietanze> piatti = new ArrayList<Pietanze>();
	public Ordine() {
	}
	public Ordine(Integer numT) {
		this.stato=new NoState();
		this.numeroOrdine=++this.numeroOrdineTotale;
		this.numTavolo=numT;
	}
	
	public void setState(State state) {
		this.stato=state;
	}
	
	public State getState() {
		return this.stato;
	}
	
	public Integer getNumOrd() {
		return numeroOrdine;
	}
	public Integer getNumTavolo() {
		return numTavolo;
	}
	public void aggiungiPietanza(String nomeP, Integer qnt) {
		for(Pietanze element : menu.allMenu) {
			if(element.getNome().equals(nomeP)&&qnt!=0) {//se la quantita' e' 0 non lo puoi aggiungere
				piatti.add(element.makeCopy(qnt));
			}
		}
	}
	public ArrayList<Pietanze> getPietanze(){
		return piatti;
	}
	public void showP() {
		for(Pietanze el : piatti) {
			System.out.println(el.getNome()+" dentro a show\n");
		}
	}
}
