
public class Ordinazione {
	private Pietanze pizza;
    private Pietanze bevanda;
    private int quantita1;
    private int quantita2;
    
    public Ordinazione(Pietanze p,Pietanze b, int qta1, int qta2) {
    	this.pizza = p;
    	this.bevanda = b;
    	this.quantita1 = qta1;
    	this.quantita2 = qta2;
    }
    
    public Pietanze getPrimo() {
        return pizza;
    }
    
    public Pietanze getSecondo() {
        return bevanda;
    }
    
    public String visualizza() {
        String s = " - PIZZA: " + pizza.displayName() + 
                   " - SECONDO: " + bevanda.displayName() +
                   " - TOTALE: " + calcolaTotale();
        return s;
    }


    public double calcolaTotale(){   
        double totale = (pizza.getPrezzo() * quantita1) + (bevanda.getPrezzo() * quantita2);
        return totale;  
    }  
}
