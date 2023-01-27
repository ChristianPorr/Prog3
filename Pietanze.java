import java.util.Formatter;

public class Pietanze implements Cloneable{
	private Formatter fm = new Formatter();
    private String nome;
	private double prezzo;
	private Integer qnt;
	    
	    //COSTRUTTORE
	    public Pietanze(String nP,Double pP) {
			this.nome = nP; /*nP nome Pietanza*/
			this.prezzo = pP; /*pR prezzo pietanza*/
			fm.format("%.2f", prezzo);
			qnt=0;
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
		public void setQnt(Integer n) {
				this.qnt=n;
		}
	    public Integer getQnt() {
	    	return this.qnt;
	    }
	    public String displayName() {
	    	String s = this.nome + "\n" + this.prezzo + "\n";	    
	    	return s;
	    }
	    
	    public Pietanze makeCopy(Integer q) {
	    	System.out.println("Sto copiando "+this.nome);
	    	Pietanze copy = null;
	    	try {
				copy = (Pietanze) super.clone();
				copy.setQnt(q);
			} catch (CloneNotSupportedException e) {
				System.out.println("Non sono riuscito a copiare "+this.nome);
				e.printStackTrace();
			}
	    	return copy;
	    }
		
}
