import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class ClienteFrame extends Frame {
    int risposta;
    Vector<String> vectorS = new Vector<String>();
    Vector<Integer> vectorQ = new Vector<Integer>();
    JCheckBox cBox = new JCheckBox();
    Tavolo tav[];//tavoli
    Integer txtCount=0;
    JTextArea textArea = new JTextArea(30,30);
    
    Serviamo avviso = new Serviamo();
    Cuoco pizzaiolo = new Pizzayolo();
	Cuoco chef = new Chef();
	JComboBox<String> pizze = new JComboBox<>();
    JComboBox<String> primiPiatti = new JComboBox<>();
    JComboBox<String> bevande = new JComboBox<>();
    JComboBox<String> tavoli = new JComboBox<>();
    JLabel labelTav = new JLabel("Ordinazione per il tavolo n:");
    JButton btnOrdina = new JButton("Ordina");
    JButton btnServi = new JButton("Servi");
    JButton btnAdd = new JButton("+");
    JButton btnDec = new JButton("-");        
    JButton btnAdd1 = new JButton("+");
    JButton btnDec1 = new JButton("-");        
    JButton btnAdd2 = new JButton("+");
    JButton btnDec2 = new JButton("-");        
    JButton btnHome = new JButton("Home");
    JButton btnStato = new JButton("   ");
    Object selected;
    JPanel panel = new JPanel(new BorderLayout());
	JPanel panPietanze = new JPanel(new GridBagLayout());
    Menu menu = new Menu();
    
    
    public ClienteFrame(){
    	System.out.println("INIZIO...");
    	
		
		avviso.add(pizzaiolo);
		avviso.add(chef);
    	
        
        Border bordoInterno = BorderFactory.createTitledBorder("Menu");
		Border bordoEsterno = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border bordoFinale = BorderFactory.createCompoundBorder(bordoInterno, bordoEsterno);
	
		panPietanze.setBorder(bordoFinale);
		
    	
        frame.setTitle("Gestionale Ristorante-Cliente");
        label.setText("Ristorante Parthenope");
        label.setFont(new Font(null, Font.PLAIN,25));
        frame.getContentPane().add(label, BorderLayout.NORTH);

        btnCliente.setText("Conferma ordine!");
        //btnCliente.addActionListener(e -> confermaOrdine());
        btnCliente.setFocusable(false);
        

        cBox.setFocusable(false);
        
        
        
        int i;
        for (i=0;i<menu.sP.size();i++){//aggiunta del menu a tendina
            pizze.addItem(menu.sP.get(i).getNome());
        }
       
        
        for(int j=0;j<menu.sB.size();j++) {
        	bevande.addItem(menu.sB.get(j).getNome());
        }
        
        for(int j=0;j<menu.sPP.size();j++) {
        	primiPiatti.addItem(menu.sPP.get(j).getNome());
        }
        
        //CREAZIONE DEI TAVOLI
       
        	tav = new Tavolo[20];
        
	        for(i=0;i<20;i++) {
	        	tav[i]=new Tavolo();
	        }
        
	        Integer tempI; //var temporanee
	        String tempS;
	        for(i=0;i<20;i++) {
	        		tav[i].setNumTav(i+1);
	        		tempI = tav[i].getNumTav();
	        		tempS = tempI.toString();
	        		tavoli.addItem(tempS);
	        }
        
        
        
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JTextArea textAreaTavolo = new JTextArea(30,30);
        textAreaTavolo.setEditable(false);
        JScrollPane scrollTATav = new JScrollPane(textAreaTavolo);
        //scrollTATav
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> {
        								String tmpS;
        								Integer tmpI;
        								this.vectorQ.clear();
        								this.vectorS.clear();
        								tmpS=this.textArea.getText();
        								tmpI=tmpS.length();
        								this.textArea.replaceRange("", 0, tmpI);
        								});
 
        tavoli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                /* QUANDO VIENE CLICKATO IL JCOMBOBOX DEL TAVOLO MOSTRAMI IL TAVOLO */
                JComboBox comboBox = (JComboBox) event.getSource();

                selected = comboBox.getSelectedItem();
                File myObj = new File("tav"+selected.toString()+".txt");
            	if(myObj.exists()) {
            		Integer i=Integer.parseInt(selected.toString());
            		showOrder(i, myObj, textAreaTavolo);
            		//SE ESISTE MOSTRAMELO
            	} else {
            		//ALTRIMENTI SVUOTA LA TEXTAREA DEL TAVOLO
            		String tmpS;
					Integer tmpI;
					tmpS=textAreaTavolo.getText();
					tmpI=tmpS.length();
            		textAreaTavolo.replaceRange("", 0, tmpI);
            	}
                

            }
        });
        //conversione
        String indexToInt =(String) tavoli.getSelectedItem();
        int index = Integer.parseInt(indexToInt) - 1;
     	//BOTTONE ORDINAZIONE
        btnOrdina.addActionListener(e -> ordiniamo(vectorS, vectorQ, tav[index]));
        /*btnOrdina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdinaActionPerformed(evt);
            }
        });*/
        
        //BOTTONE SERVI
        btnServi.addActionListener(e -> {aggiornaTav(tav[index], textAreaTavolo);  btnStato.doClick();});

        
        //Pizze
        btnAdd.addActionListener(e -> addOrdine((String) pizze.getSelectedItem(), textArea, vectorS, vectorQ));
        btnDec.addActionListener(e -> decOrdine((String) pizze.getSelectedItem(), textArea, vectorS, vectorQ));
        //Bevande
        btnAdd1.addActionListener(e -> addOrdine((String) bevande.getSelectedItem(), textArea, vectorS, vectorQ));
        btnDec1.addActionListener(e -> decOrdine((String) bevande.getSelectedItem(), textArea, vectorS, vectorQ));
        //Primi piatti
        btnAdd2.addActionListener(e -> addOrdine((String) primiPiatti.getSelectedItem(), textArea, vectorS, vectorQ));
        btnDec2.addActionListener(e -> decOrdine((String) primiPiatti.getSelectedItem(), textArea, vectorS, vectorQ));
        //Home
        btnHome.addActionListener(e -> {frame.dispose(); new MainFrame();});
        //btn stato ordine
        btnStato.setFocusable(false);
        btnStato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (selected==null) {
					tavoli.setSelectedIndex(0);
				}
				if(tavoli.getSelectedItem()!=null) {
					Integer i=Integer.parseInt(tavoli.getSelectedItem().toString());
					State ordRic = new OrdineRicevuto();
					State ordCons = new OrdineConsegnato();
					
					if(tav[i-1].getStatusOrdine().getClass()==ordRic.getClass()) {//se lo stato e' ordine ricevuto:
						btnStato.setBackground(Color.orange);
					}
					else if(tav[i-1].getStatusOrdine().getClass()==ordCons.getClass()) {//se lo stato e' ordine consegnato:
						btnStato.setBackground(Color.green);
					} else if(tav[i-1].getStatusOrdine().getClass()==null) btnStato.setBackground(Color.gray);
					
				}
			}
        	
        });
        
        frame.add(scrollPane, BorderLayout.LINE_END);
        
        //LAYOUT PANNELLO PIETANZE
        panel.add(panPietanze,BorderLayout.PAGE_START); //quasi effimero
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        /*Menu pizze*/
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        
        panPietanze.add(pizze,gbc);    
        
        /*Bottoni Pizza*/
        gbc.gridx = 1;
        gbc.gridy = 0;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
           
        panPietanze.add(btnAdd,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        
        panPietanze.add(btnDec,gbc);
        
        /*Menu Bevande*/
        gbc.gridx = 0;
        gbc.gridy = 1;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
       
        
        panPietanze.add(bevande,gbc);
        
        /*Bottoni bevande*/
        gbc.gridx = 1;
        gbc.gridy = 1;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        panPietanze.add(btnAdd1,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        panPietanze.add(btnDec1,gbc);
        
        /*Menu primi piatti*/
        gbc.gridx = 0;
        gbc.gridy = 2;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        
        panPietanze.add(primiPiatti,gbc);    
        
        /*Bottoni Primi piatti*/
        gbc.gridx = 1;
        gbc.gridy = 2;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
           
        panPietanze.add(btnAdd2,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        panPietanze.add(btnDec2,gbc);
        
        /*Label scegli tavolo*/
        gbc.gridx = 0;
        gbc.gridy = 3;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        panPietanze.add(labelTav,gbc);
        
        /*Jcombobox tavoli*/
        gbc.gridx = 1;
        gbc.gridy = 3;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        panPietanze.add(tavoli,gbc);
        
        /*Stato del tavolo*/
        gbc.gridx = 2;
        gbc.gridy = 3;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        panPietanze.add(btnStato,gbc);
        
        /*Bottoni ordina e servi*/
        gbc.gridx = 0;
        gbc.gridy = 4;
        
        gbc.weightx = 0.02;
        gbc.weighty = 0.02;
        
        panPietanze.add(btnOrdina,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        
        gbc.weightx = 0.02;
        gbc.weighty = 0.02;
        
        panPietanze.add(btnServi,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        
        gbc.weightx = 0.02;
        gbc.weighty = 0.02;
        
        panPietanze.add(btnClear,gbc);
        
        /*TextArea tavolo*/
        gbc.gridx = 0;
        gbc.gridy = 5;
        
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        
        panPietanze.add(scrollTATav, gbc);

        /*Bottone Home*/
        gbc.gridx = 1;
        gbc.gridy = 6;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        panPietanze.add(btnHome,gbc);
        
        frame.getContentPane().add(panPietanze);        
    }

 
	public void addOrdine(String scelta, JTextArea textArea, Vector<String> listaS, Vector<Integer> listaQ){
    	boolean bool;
        int i, n, lenScelta, indice;
        String scontrino, temp;
        scontrino = textArea.getText();//trasformazione textArea in testo per trovare indice
        indice = scontrino.indexOf(scelta);//indice dove si trova la pizza
        bool = listaS.contains(scelta);//valore bool se contiene o meno la pizza nel testo
        if (!bool){//se non la contiene aggiungila
        	//System.out.println("indice="+indice);
            listaS.add(scelta);
            listaQ.add(1);
            textArea.append(scelta+" Qt: 1  \n");//aggiungi scelta senza quantit�
        } else if(indice>=0){//se esiste la stessa pietanza aggiungila con la quantit�
        	//System.out.println("bool="+bool);
        	//System.out.println("indice dentro="+indice);
            for(i=0;i<listaS.size();i++){
                    n=listaQ.get(i)+1;
                    listaQ.set(i, n);
                    if(listaQ.get(i)>9){
                        temp = scelta+" Qt: "+listaQ.get(i)+"\n";
                        lenScelta = temp.length() + indice;
                    } else {
                        temp = scelta+" Qt: "+listaQ.get(i)+"\n";
                        lenScelta = temp.length() + indice;
                    }
                    textArea.replaceRange(temp, indice, lenScelta);//sostituisci la pietanza on quella corretta           
                }
                
            }
           
        }


    public void decOrdine(String scelta, JTextArea textArea, Vector<String> listaS, Vector<Integer> listaQ){
    	 int indice, lenScelta, i, n=0;
         String scontrino, temp;
         Boolean bool;
         scontrino = textArea.getText();//stesse cose dell'add
         indice = scontrino.indexOf(scelta);
         bool = listaS.contains(scelta);//valore bool se contiene o meno la pizza nel testo
         if (!bool){//se non la contiene aggiungila
             listaS.add(scelta);
             listaQ.add(-1);
             textArea.append(scelta+" Qt: -1 \n");//aggiungi scelta senza quantit�
             
         } else
         if(indice>=0){

             for(i=0;i<listaS.size();i++){
                 if(scelta==listaS.get(i)&&(listaQ.get(i)>1||listaQ.get(i)<=-1)){
                     n=listaQ.get(i)-1;
                     listaQ.set(i, n);
                     temp = scelta+" Qt: "+listaQ.get(i)+"\n";//inserisce la qnt giusta
                     lenScelta = temp.length()+indice;
                     textArea.replaceRange(temp, indice, lenScelta);//inserisce all'interno del text area l'aggiornamento
                 
         	    	
                 } else if(scelta==listaS.get(i)&&listaQ.get(i)==1){//quando la qt � 0 allora cancellla
                     temp = scelta+" Qt: n  \n";
                     lenScelta = temp.length()+indice;
                     textArea.replaceRange("", indice, lenScelta);//sostituisci con una stringa vuota
                     listaQ.remove(i);//elimina la pietanza dalle scelte
                     listaS.remove(i);//elimina anche quindi la relati quantit�
                     
                 }
             }
        } 

    }
    

    
    public void ordiniamo(Vector<String> scelte, Vector<Integer> qnt, Tavolo numTav){
    	avviso.aggiungiOrdine(scelte, qnt, numTav);//Devi passare il tavolo non il numtavolo
    	btnStato.doClick();
    	
    	Integer numeroT = numTav.getNumTav();//numero tavolo +1
    	
    	try {
  	      File myObj = new File("tav"+numeroT+".txt");
  	      if (myObj.createNewFile()) {
  	    	  System.out.println("File created: \n" + myObj.getName());
  	    	  numeroT--;//tav0 è in realtà tav1
  	    	  this.tav[numeroT].setOccupato();
  	    	  tav[numeroT].prendiOrd(scelte, qnt, myObj);
  	      } else {
  	    	  System.out.println("File already exists.\n");
  	    	  numeroT--;//tav0 è in realtà tav1
  	    	  this.tav[numeroT].setOccupato();
  	    	  tav[numeroT].prendiOrd(scelte, qnt, myObj);
  	      }
  	    } catch (IOException e) {
  	      System.out.println("An error occurred.");
  	      e.printStackTrace();
  	    }
    	
    	
    }
    
    public void aggiornaTav(Tavolo tav, JTextArea txt) {
    	int cnt=0;
    	Integer numTav = tav.getNumTav();
    	if(((Pizzayolo) this.pizzaiolo).infornaPizze(tav).getStatusOrdine()==new OrdineConsegnato()) cnt++;
		if(((Chef) this.chef).cucina(tav).getStatusOrdine()==new OrdineConsegnato()) {
			cnt++;
		}
		if(cnt==2) {
			tav.setStatusOrdine(new OrdineConsegnato());
		}
		Scanner myReader;
    	String tmpCounter;
		try {
	  	      File file = new File("tav"+numTav+".txt");
	  	      if (file.exists()) {
	  	    	myReader = new Scanner(file);
				String temp, temptxt;
		    	temptxt = txt.getText();
		    	if(!temptxt.isEmpty()) {
		    		txt.replaceRange("", 0, temptxt.length());
		    	}
		    	txt.append("Il tavolo "+numTav+" ha ordinato:\n");
		    	while(myReader.hasNextLine()) {
		    		temp = myReader.nextLine();
		    		txt.append(temp+"\n");
		    	}
		    	tmpCounter=txt.getText();
		    	this.txtCount = tmpCounter.length();
		    	myReader.close();
	  	      }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Scanner non trovato");
			}
    }
   
    void aggiornaTextA(JTextArea textArea, String stringa, int indice, Vector<Integer> vInt){
        String temp;
        int lenScelta;
        temp = stringa+" Qt: "+vInt.get(indice)+"\n";
        lenScelta = temp.length();
        textArea.replaceRange(temp, indice, lenScelta);
    }
    
    private void showOrder(Integer i, File file, JTextArea txt){
    	//Aggiungiamo l'ordine al textArea...
    	Scanner myReader;
    	String tmpCounter;
		try {
			myReader = new Scanner(file);
			String temp, temptxt;
	    	temptxt = txt.getText();
	    	if(!temptxt.isEmpty()) {
	    		txt.replaceRange("", 0, temptxt.length());
	    	}
	    	txt.append("Il tavolo "+i+" ha ordinato:\n");
	    	while(myReader.hasNextLine()) {
	    		temp = myReader.nextLine();
	    		txt.append(temp+"\n");
	    	}
	    	tmpCounter=txt.getText();
	    	this.txtCount = tmpCounter.length();
	    	myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Scanner non trovato");
		}
    }
    
}


