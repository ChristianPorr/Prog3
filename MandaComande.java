import java.util.*;

public class MandaComande {
	
	ArrayList<Cassa> casse = new ArrayList<Cassa>();
	
	public void add(Cassa c) {
		casse.add(c);
	}
	public void remove(Cassa c) {
		casse.remove(c);
	}
	public void allertaComanda(Tavolo tav) {
		for(Cassa cassiere : casse) {
			cassiere.aggiungiComanda(tav);
		}
	}
	
}
