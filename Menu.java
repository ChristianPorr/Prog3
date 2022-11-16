import java.util.*;
public class Menu {
    ArrayList<Pietanze> sP = new ArrayList<Pietanze>();
	ArrayList<Pietanze> sB = new ArrayList<Pietanze>();
	
	public Menu(){
		this.sP.add(new Pietanze("Margherita", 4.50));
		this.sP.add(new Pietanze("Marinara", 4.00));
		this.sP.add(new Pietanze("Diavola", 5.00));
		this.sP.add(new Pietanze("Bufalina", 6.50));
		
		this.sB.add(new Pietanze("Vino bianco", 3.00));
		this.sB.add(new Pietanze("Acqua Frizzante", 1.00));
		this.sB.add(new Pietanze("Acqua Naturale", 0.50));
		this.sB.add(new Pietanze("Birra", 2.50));
	}
	
	public String toString() {
		String s = this.sP + " " + this.sB + " ";
		return s;
	}

    public void mostraPietanzaNome(){
        int i;
        for(i=0;i<sP.size();i++){
            System.out.println(this.sP.get(i).getNome().toString());
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
    
    public double contoTot(double cP, double cB){
            return cP+cB;
    }
    

}
