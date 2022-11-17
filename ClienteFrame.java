import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ClienteFrame extends Frame {
    
    public ClienteFrame(){
        frame.setTitle("Gestionale Ristorante-Cliente");
        //int risposta;
        //btnCliente.addActionListener(e -> risposta=JOptionPane.showConfirmDialog(null,"sei sicuro della tua scelta?", "Conferma ordine", JOptionPane.YES_NO_OPTION));
        //btnCliente.setFocusable(false);
        label.setText("WEWEEE");
        label.setFont(new Font(null, Font.PLAIN,25));
		
        
        frame.add(label);


    }
}
