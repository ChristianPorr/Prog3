import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		System.out.println("Di quanti tavoli hai a disposizione?\n");
		int x =obj.nextInt();
		ArrayList<Tavolo> tavoli = new ArrayList<Tavolo>();
		for(int i=0;i<x-1;i++){
			tavoli.add(new Tavolo());
		}
		System.out.println("Il numero del tavolo e':" + tavoli.get(0).getNumTav());
			/*mostra menu */
		
		/*tavoli.get(0).contoTot(null, null);*/
			
	}

}
