import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;


public class ClienteFrame extends Frame {
    int risposta;
    Vector<String> vectorS = new Vector<String>();
    Vector<Integer> vectorQ = new Vector<Integer>();
    LinkedList<Ordinazione> codaOrdinazioni = new LinkedList<Ordinazione>();
    Ordinazione ord;
    JCheckBox cBox = new JCheckBox();
    Tavolo tav[] = new Tavolo[20];//tavoli
    
    
    public ClienteFrame(){
    	JPanel panel = new JPanel(new BorderLayout());
    	JPanel panPietanze = new JPanel(new GridBagLayout());
        Menu menu = new Menu();
        JComboBox<String> pizze = new JComboBox<>();
        JComboBox<String> bevande = new JComboBox<>();
        JComboBox<String> tavoli = new JComboBox<>();
        JLabel labelTav = new JLabel("Ordinazione per il tavolo n:");
        JButton btnOrdina = new JButton("Ordina");
        JButton btnServi = new JButton("Servi");

        JButton btnAdd = new JButton("+");
        JButton btnDec = new JButton("-");
        
        JButton btnAdd1 = new JButton("+");
        JButton btnDec1 = new JButton("-");
        
        
        
        Border bordoInterno = BorderFactory.createTitledBorder("Menu");
		Border bordoEsterno = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border bordoFinale = BorderFactory.createCompoundBorder(bordoInterno, bordoEsterno);
	
		panPietanze.setBorder(bordoFinale);
    	
        frame.setTitle("Gestionale Ristorante-Cliente");
        label.setText("Scegli le pizze e le bibite:");
        label.setFont(new Font(null, Font.PLAIN,25));
        frame.getContentPane().add(label, BorderLayout.NORTH);

        btnCliente.setText("Conferma ordine!");
        //btnCliente.addActionListener(e -> confermaOrdine());
        btnCliente.setFocusable(false);
        frame.getContentPane().add(btnCliente, BorderLayout.SOUTH);

        cBox.setFocusable(false);
        
        
        //BOTTONE ORDINAZIONE
        btnOrdina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdinaActionPerformed(evt);
            }
        });
        
        //BOTTONE SERVI
        btnServi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiActionPerformed(evt);
            }
        });

        int i;
        for (i=0;i<menu.sP.size();i++){//aggiunta del menu a tendina
            pizze.addItem(menu.sP.get(i).getNome());
        }
       
        
        for(int j=0;j<menu.sB.size();j++) {
        	bevande.addItem(menu.sB.get(j).getNome());
        }
        //CREAZIONE DEI TAVOLI
        for(i=0;i<20;i++) {
        	tav[i]=new Tavolo();
        }
   
        
        Integer tempI;//var temporanee
        String tempS;
        for(i=0;i<20;i++) {
        	tempI = tav[i].getNumTav();
        	tempS = tempI.toString();
        	tavoli.addItem(tempS);
        }
        
        
        
        JTextArea textArea = new JTextArea(30,30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
 
        
        
        //Pizze
        btnAdd.addActionListener(e -> addOrdine((String) pizze.getSelectedItem(), textArea, pizze.getSelectedIndex(), vectorS, vectorQ));
        btnDec.addActionListener(e -> decOrdine((String) pizze.getSelectedItem(), textArea, pizze.getSelectedIndex(), vectorS, vectorQ));
        //Bevande
        btnAdd1.addActionListener(e -> addOrdine((String) bevande.getSelectedItem(), textArea, bevande.getSelectedIndex(), vectorS, vectorQ));
        btnDec1.addActionListener(e -> decOrdine((String) bevande.getSelectedItem(), textArea, bevande.getSelectedIndex(), vectorS, vectorQ));

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
        
      //label scegli tavolo
        gbc.gridx = 0;
        gbc.gridy = 2;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        panPietanze.add(labelTav,gbc);
        
      //jcombobox tavoli
        gbc.gridx = 1;
        gbc.gridy = 2;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        panPietanze.add(tavoli,gbc);
        
        /*Bottoni ordina e servi*/
        gbc.gridx = 0;
        gbc.gridy = 3;
        
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        panPietanze.add(btnOrdina,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        panPietanze.add(btnServi,gbc);

        frame.getContentPane().add(panPietanze);        
    }

 
	public void addOrdine(String scelta, JTextArea textArea, Integer index, Vector<String> listaS, Vector<Integer> listaQ){
    	boolean bool;
        int i, n, lenScelta, indice;
        String scontrino, temp;
        scontrino = textArea.getText();//trasformazione textArea in testo per trovare indice
        indice = scontrino.indexOf(scelta);//indice dove si trova la pizza
        bool = listaS.contains(scelta);//valore bool se contiene o meno la pizza nel testo
        if (!bool){//se non la contiene aggiungila
            listaS.add(scelta);
            listaQ.add(1);
            textArea.append(scelta+" Qt: 1\n");//aggiungi scelta senza quantit�
        } else if(indice>=0){//se esiste la stessa pietanza aggiungila con la quantit�

            for(i=0;i<listaS.size();i++){
                if(scelta==listaS.get(i)){
                    n=listaQ.get(i)+1;
                    listaQ.set(i, n);
                    if(listaQ.get(i)>9){
                        temp = scelta+" Qt: "+listaQ.get(i)+"\n";
                        lenScelta = temp.length() + indice + 1;
                    } else {
                        temp = scelta+" Qt: "+listaQ.get(i)+"\n";
                        lenScelta = temp.length() + indice;
                    }
                    textArea.replaceRange(temp, indice, lenScelta);//sostituisci la pietanza on quella corretta
                }
            }
        }

    }
    
    

    public void decOrdine(String scelta, JTextArea textArea, Integer index, Vector<String> listaS, Vector<Integer> listaQ){
    	 int indice, lenScelta, i, n=0;
         String scontrino, temp;
         scontrino = textArea.getText();//stesse cose dell'add
         indice = scontrino.indexOf(scelta);
         if(indice>=0){

             for(i=0;i<listaS.size();i++){
                 if(scelta==listaS.get(i)&&listaQ.get(i)>1){
                     n=listaQ.get(i)-1;
                     listaQ.set(i, n);
                     temp = scelta+" Qt: "+listaQ.get(i)+"\n";//inserisce la qnt giusta
                     lenScelta = temp.length()+indice;
                     textArea.replaceRange(temp, indice, lenScelta);//inserisce all'interno del text area l'aggiornamento
                 } else if(scelta==listaS.get(i)){//quando la qt � 0 allora cancellla
                     temp = scelta+" Qt: n\n";
                     lenScelta = temp.length()+indice;
                     textArea.replaceRange("", indice, lenScelta);//sostituisci con una stringa vuota
                     listaQ.remove(i);//elimina la pietanza dalle scelte
                     listaS.remove(i);//elimina anche quindi la relati quantit�
                 }
             }
        }

    }
    


    private void btnOrdinaActionPerformed(ActionEvent evt) {
    	
    	
    }
    
    
    protected void btnServiActionPerformed(ActionEvent evt) {
    	 /*if (codaOrdinazioni.isEmpty()) 
             textArea.append("Non ci sono ordini da evadere\n");
         else {
             ord = codaOrdinazioni.poll();
             textArea.append("Soddisfatto ordine:\n");
             textArea.append(ord.visualizza() + "\n");
         }
         txtComande.setText("Comande:" + codaOrdinazioni.size() + "\n");
	*/}


    void aggiornaTextA(JTextArea textArea, String stringa, int indice, Vector<Integer> vInt){
        String temp;
        int lenScelta;
        temp = stringa+" Qt: "+vInt.get(indice)+"\n";
        lenScelta = temp.length();
        textArea.replaceRange(temp, indice, lenScelta);
    }

    public void confermaOrdine(){
        String[] answ = {"Si","No"};
        int scelta;//0 si, 1 no
        scelta = JOptionPane.showOptionDialog(null,
                                     "Sei sicuro delle tue scelte?",
                                      "Invio ordine...",
                                       JOptionPane.YES_NO_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE,
                                         null,
                                          answ,
                                           0);
        
        System.out.println(scelta);
        this.risposta=scelta;
    }


}
