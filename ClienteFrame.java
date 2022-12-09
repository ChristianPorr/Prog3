import java.util.*;
import javax.swing.*;
import java.awt.*;


public class ClienteFrame extends Frame {
    //ArrayList<Pietanze> listaP = new ArrayList<>();
    //ArrayList<Pietanze> listaB = new ArrayList<>();
    JCheckBox cBox = new JCheckBox();
    JPanel panel = new JPanel();
    int risposta;
    private JTable table;
    private JTable table_1;
    Vector<String> vectorS = new Vector<String>();
    Vector<Integer> vectorQ = new Vector<Integer>();

    public ClienteFrame(){
    	
    	JPanel panPietanze = new JPanel();//quasi effimero
        Menu menu = new Menu();
        JComboBox<String> prova = new JComboBox<>();
        JComboBox<String> prova1 = new JComboBox<>();
    	
        frame.setTitle("Gestionale Ristorante-Cliente");
        label.setText("Scegli le pizze e le bibite:");
        label.setFont(new Font(null, Font.PLAIN,25));
        frame.getContentPane().add(label, BorderLayout.NORTH);

        btnCliente.setText("Conferma ordine!");
        btnCliente.addActionListener(e -> confermaOrdine());
        btnCliente.setFocusable(false);
        frame.getContentPane().add(btnCliente, BorderLayout.SOUTH);

        cBox.setFocusable(false);

        int i;
        for (i=0;i<menu.sP.size();i++){//aggiunta del menu a tendina
            prova.addItem(menu.sP.get(i).getNome());
        }
       
        
        for(int j=0;j<menu.sB.size();j++) {
        	prova1.addItem(menu.sB.get(j).getNome());
        }

        JButton btnAdd = new JButton("+");
        JButton btnDec = new JButton("-");
        
        JButton btnAdd1 = new JButton("+");
        JButton btnDec1 = new JButton("-");

        JTextArea textArea = new JTextArea(30,30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        
       
        
        JTextArea textArea1 = new JTextArea(30,30);
        textArea1.setEditable(false);
        frame.add(textArea1); //da fixare
        
        
        //Pizze
        btnAdd.addActionListener(e -> addOrdine((String) prova.getSelectedItem(), textArea, prova.getSelectedIndex(), vectorS, vectorQ));
        btnDec.addActionListener(e -> decOrdine((String) prova.getSelectedItem(), textArea, prova.getSelectedIndex(), vectorS, vectorQ));
        //Bevande
        btnAdd1.addActionListener(e -> addOrdine((String) prova1.getSelectedItem(), textArea, prova1.getSelectedIndex(), vectorS, vectorQ));
        btnDec1.addActionListener(e -> decOrdine((String) prova1.getSelectedItem(), textArea, prova1.getSelectedIndex(), vectorS, vectorQ));

        frame.add(scrollPane, BorderLayout.LINE_END);
        
        //btnAdd.addActionListener(e -> addingP(jl));

        panPietanze.add(prova);
        panPietanze.add(prova1);
        panPietanze.add(btnAdd);
        panPietanze.add(btnDec);
        panPietanze.add(btnAdd1);
        panPietanze.add(btnDec1);

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
            textArea.append(scelta+" Qt: 1\n");//aggiungi scelta senza quantità
        } else if(indice>=0){//se esiste la stessa pietanza aggiungila con la quantità

            for(i=0;i<listaS.size();i++){
                if(scelta==listaS.get(i)){
                    n=listaQ.get(i)+1;
                    listaQ.set(i, n);
                    temp = scelta+" Qt: "+listaQ.get(i)+"\n";
                    if(listaQ.get(i)>9){
                        lenScelta = temp.length() + indice+1;
                    } else {
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
                 } else if(scelta==listaS.get(i)){//quando la qt è 0 allora cancellla
                     temp = scelta+" Qt: n\n";
                     lenScelta = temp.length()+indice;
                     textArea.replaceRange("", indice, lenScelta);//sostituisci con una stringa vuota
                     listaQ.remove(i);//elimina la pietanza dalle scelte
                     listaS.remove(i);//elimina anche quindi la relati quantità
                 }
             }
        }

    }

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
