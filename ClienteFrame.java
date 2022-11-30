import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ClienteFrame extends Frame {
    ArrayList<Pietanze> listaP = new ArrayList<>();
    ArrayList<Pietanze> listaB = new ArrayList<>();
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

        //panel.add(label);
        cBox.setFocusable(false);
        
        String s="Cazz";
        int p=50;

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1,2));
        
        
        JPanel panPietanze = new JPanel();
        
        Menu listaP = new Menu();
        
        /*int i;
        String nomi[];
        for(i=0;i<listaP.sP.size();i++){
            nomi[i]=listaP.sP.get(i);
        }*/
        

        
        JButton btnAdd = new JButton("+");
        JButton btnDec = new JButton("-");
        TextField text1 = new TextField(20);//nome pietanza
        text1.setEditable(false);
        text1.setText(listaP.sP.get(1).getNome()+"  "+listaP.sP.get(1).getPrezzoS());//prezzo pietanza

        //TextField nomeP[] = new TextField[listaP.sP.size()];



        int i;
        TextField t = new TextField(20);
        for(i=0;i<listaP.sP.size();i++) {
            t.setText(listaP.sP.get(i).getNome());
            t.setEditable(false);
            panPietanze.add(t);
        }

        /*for(i=0;i<3;i++) {
            panPietanze.add(nomeP[i]);
        }*/
        
        
        //btnAdd.addActionListener(e -> addingP(jl));
        
 
        
        panPietanze.add(text1);
        panPietanze.add(btnAdd);
        
        table = new JTable();
        panPietanze.add(btnDec);
        //panPietanze.add(jl);
        mainPanel.add(panPietanze);
        frame.getContentPane().add(mainPanel);
        

        
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
        Menu menu = new Menu();
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
