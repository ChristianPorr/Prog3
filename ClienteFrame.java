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

        JTextArea textArea = new JTextArea(30,10);
        textArea.setEditable(false);

        frame.add(textArea, BorderLayout.LINE_END);


        
        //btnAdd.addActionListener(e -> addingP(jl));

        panPietanze.add(prova);
        panPietanze.add(btnAdd);
        panPietanze.add(btnDec);

        frame.getContentPane().add(panPietanze);
        

        
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

    public void showMenu(){
        MenuG menu = new MenuG();
        int i;
		for(i=0;i<menu.sP.size();i++){
            
        }
    }

    public void addingP(JList jl){
        int index;
        index=jl.getSelectedIndex();
        System.out.print("sta premuto questo"+index);
    }

}
