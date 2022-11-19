public class Pietanze{
    private String nome;
    private String[] ingredienti;
	private boolean scelto;
	private int quantita; 
	    /*private String[] ingredienti;*/
	    private double prezzo;
	    
	    //COSTRUTTORE
	    public Pietanze(String nP, Double pP) {
			this.nome = nP; /*nP nome Pietanza*/
			this.prezzo = pP; /*pR prezzo pietanza*/
			scelto= false;
	    }
	    
	    //METODO
	    public void aumentaPrezzo(double delta){
	        this.prezzo+=delta;
	    }
	    
	    //METODO
	    public void cambiaPrezzo(double delta){
	        this.prezzo=delta;
	    }
	    
	    public String getNome() {
	    	return this.nome;
	    }
	    
	    public Double getPrezzo() {
	    	return this.prezzo;
	    }
	    
	    public String toString() {
	    	String s = this.nome + "\n" + this.prezzo + "\n";	    
	    	return s;
	    }

		public void addQuantita(){
			this.quantita++;
		}

		public void decQuantita(){
			this.quantita--;
		}
}
