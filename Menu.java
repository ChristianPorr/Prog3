import java.util.*;
public class Menu implements IteratoreContainer{
    ArrayList<Pietanze> sP = new ArrayList<Pietanze>();
    ArrayList<Pietanze> sB = new ArrayList<Pietanze>();
    ArrayList<Pietanze> sPP = new ArrayList<Pietanze>();
	
	public Menu(){
		this.sP.add(new Pietanze("Margherita", 4.50));
		this.sP.add(new Pietanze("Marinara", 4.00));
		this.sP.add(new Pietanze("Diavola", 5.00));
		this.sP.add(new Pietanze("Bufalina", 6.00));
		this.sP.add(new Pietanze("Crocchè", 6.50));
		this.sP.add(new Pietanze("Primavera", 4.00));
		
		this.sB.add(new Pietanze("Vino bianco", 3.00));
		this.sB.add(new Pietanze("Acqua Frizzante", 1.00));
		this.sB.add(new Pietanze("Acqua Naturale", 0.50));
		this.sB.add(new Pietanze("Birra", 2.50));
		this.sB.add(new Pietanze("Fanta", 1.50));
		this.sB.add(new Pietanze("Coca Cola", 1.50));
		
		this.sPP.add(new Pietanze("Spaghetti con le vongole",15.50));
		this.sPP.add(new Pietanze("Risotto carnaroli",12.50));
		this.sPP.add(new Pietanze("Pasta ai pomodorini",10.00));
		this.sPP.add(new Pietanze("Tagliatelle di nonna Pina",100.00));
		}
	
	@Override
	public IteratoreMenu getIterator(){
		return new NameIterator();
	}
	
	public class NameIterator implements IteratoreMenu {
		int i=0,j=0,k=0;
		
		@Override
		public boolean hasNextP() {
			if(i < sP.size()) {
				return true;
			}
			return false;
		}
		
		@Override
		public boolean hasNextB() {
			if(j < sB.size()){
				return true;
			}
			return false;
		}
		
		
		@Override
		public boolean hasNextPP() {
			if(k < sPP.size()){
				return true;
			}
			return false;
		}
		
		@Override
		public Object nextP() {
			if(this.hasNextP()) {
				return sP.get(i++).getNome();
			}
			return null;
		}
		
		@Override 
		public Object nextB() {
			if(this.hasNextB()) {
				return sB.get(j++).getNome();
			}
			return null;
		}
		
		@Override 
		public Object nextPP() {
			if(this.hasNextPP()) {
				return sPP.get(k++).getNome();
			}
			return null;
		}
		
      }
	
    public double prendiContoPietanze(int indici[]){
    int i;
    double sumtot;
    sumtot=0;
    for(i=0;i<indici.length;i++){
        sumtot+=this.sP.get(indici[i]).getPrezzo();
        }
        return sumtot;
    }
    
    public double prendiContoBevande(int indici[]){
        int i;
        double sumtot;
        sumtot=0;
        for(i=0;i<indici.length;i++){
            sumtot+=this.sB.get(indici[i]).getPrezzo();
            }
            return sumtot;
        }
    
    public double prendiContoPrimi(int indici[]) {
    	int i;
    	double sumtot; 
    	sumtot = 0;
    	for(i=0;i<indici.length;i++) {
    		sumtot+=this.sPP.get(indici[i]).getPrezzo();
    	}
    	return sumtot;
    	
    }
    
    public double contoTot(double cP, double cB, double cPP){
            return cP+cB+cPP;
    }
    
    

}
