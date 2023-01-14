import java.util.Formatter;

public class Pietanze{
	private Formatter fm = new Formatter();
    private String nome;
	private double prezzo;
	    
	    //COSTRUTTORE
	    public Pietanze(String nP,Double pP) {
			this.nome = nP; /*nP nome Pietanza*/
			this.prezzo = pP; /*pR prezzo pietanza*/
			fm.format("%.2f", prezzo);
	    }
	    
	    public String getNome() {
	    	return this.nome;
	    }
	    
	    public Double getPrezzo() {
	    	return this.prezzo;
	    }

		public String getPrezzoS() {
			return Double.toString(this.prezzo);
		}
	    
	    public String displayName() {
	    	String s = this.nome + "\n" + this.prezzo + "\n";	    
	    	return s;
	    }

		
}
