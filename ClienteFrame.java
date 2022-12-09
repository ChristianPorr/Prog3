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
        frame.setTitle("Gestionale Ristorante-Cliente");
        label.setText("Scegli le pietanze e le bibite:");
        label.setFont(new Font(null, Font.PLAIN,25));
        frame.getContentPane().add(label, BorderLayout.NORTH);

        btnCliente.setText("Conferma ordine!");
        btnCliente.addActionListener(e -> confermaOrdine());
        btnCliente.setFocusable(false);
        frame.getContentPane().add(btnCliente, BorderLayout.SOUTH);

        cBox.setFocusable(false);
        
        JPanel panPietanze = new JPanel();//quasi effimero


        MenuG menu = new MenuG();

        JComboBox prova = new JComboBox();

        int i;
        for (i=0;i<menu.sP.size();i++){//aggiunta del menu a tendina
            prova.addItem(menu.sP.get(i).getNome());
        }

        JButton btnAdd = new JButton("+");
        JButton btnDec = new JButton("-");

        JTextArea textArea = new JTextArea(30,12);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        btnAdd.addActionListener(e -> addOrdine((String) prova.getSelectedItem(), textArea, prova.getSelectedIndex(), vectorS, vectorQ));
        btnDec.addActionListener(e -> decOrdine((String) prova.getSelectedItem(), textArea, prova.getSelectedIndex(), vectorS, vectorQ));

        frame.add(scrollPane, BorderLayout.LINE_END);


        
        //btnAdd.addActionListener(e -> addingP(jl));

        panPietanze.add(prova);
        panPietanze.add(btnAdd);
        panPietanze.add(btnDec);

        frame.getContentPane().add(panPietanze);
        

        
    }

    public void addOrdine(String scelta, JTextArea textArea, Integer index, Vector<String> listaS, Vector<Integer> listaQ){
        boolean bool;
        int i, n, ii=0, lenScelta, indice;
        String scontrino, temp;
        scontrino = textArea.getText();
        indice = scontrino.indexOf(scelta);
        bool = listaS.contains(scelta);
        if (!bool){
            listaS.add(scelta);
            listaQ.add(1);
            textArea.append(scelta+" Qt: 1\n");//aggiungi scelta senza quantità
        } else if(indice>=0){//se esiste la stessa pietanza

            for(i=0;i<listaS.size();i++){
                if(scelta==listaS.get(i)){
                    n=listaQ.get(i)+1;
                    listaQ.set(i, n);
                    ii=i;
                }
            }

            temp = scelta+" Qt: "+listaQ.get(ii)+"\n";
            lenScelta = temp.length();
            textArea.replaceRange(temp, indice, lenScelta);

        }

    }

    public void decOrdine(String scelta, JTextArea textArea, Integer index, Vector<String> listaS, Vector<Integer> listaQ){
        int indice, lenScelta, i, ii=0, n=0;
        String scontrino, temp;
        scontrino = textArea.getText();
        indice = scontrino.indexOf(scelta);
        if(indice>=0){

            for(i=0;i<listaS.size();i++){
                if(scelta==listaS.get(i)&&listaQ.get(i)>0){
                    n=listaQ.get(i)-1;
                    listaQ.set(i, n);
                    ii=i;
                } else if(scelta==listaS.get(i)&&listaQ.get(i)==0){
                    aggiornaTextA(textArea, "", ii, listaQ);
                }
            }

            temp = scelta+" Qt: "+listaQ.get(ii);
            lenScelta = temp.length();
            textArea.replaceRange(temp, indice, lenScelta);

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
