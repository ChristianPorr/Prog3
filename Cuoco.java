/*OBSERVER PATTERN*/
import java.util.Vector;

public interface Cuoco {
	void updateTODO(Vector<String> ordine , Vector<Integer> qnt, Tavolo tav, Ordine ord);
}
