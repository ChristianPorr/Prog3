import javax.swing.JFrame;
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

    public ClienteFrame(){
        frame.setTitle("Gestionale Ristorante-Cliente");
        label.setText("Scegli le pietanze e le bibite:");
        label.setFont(new Font(null, Font.PLAIN,25));
        frame.add(label, BorderLayout.NORTH);

        btnCliente.setText("Conferma ordine!");
        btnCliente.addActionListener(e -> confermaOrdine());
        btnCliente.setFocusable(false);
        frame.add(btnCliente, BorderLayout.SOUTH);

        //panel.add(label);
        cBox.setFocusable(false);
        
        String s="Cazzo";
        int p=50;

        JButton btnPr = new JButton();

        JPanel panP = new JPanel();
        JPanel panB = new JPanel();
        JPanel panT = new JPanel();

        JLabel lab1 = new JLabel();
        lab1.setText("lab1");
        JLabel lab2 = new JLabel();
        lab1.setText("lab2");
        JLabel lab3 = new JLabel();
        lab1.setText("lab3");

        panP.add(lab1);
        panB.add(lab2);
        panT.add(lab3);
        
        frame.add(panP, BorderLayout.WEST);
        //frame.add(panB, BorderLayout.CENTER);
        frame.add(panT, BorderLayout.EAST);

        //frame.add(btnPr);
        //frame.add(btn);
        

        
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
}
