import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionListener;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends Frame{
    JButton btnCassa, btnCameriere, btnCliente; 
    
    MainFrame(){

    	
        btnCassa = new JButton();
        btnCameriere = new JButton();
        btnCliente = new JButton();

        
        btnCassa.setText("Cassa");
        btnCliente.setText("Cliente");
        btnCassa.addActionListener(e -> {frame.dispose(); new CassaFrame();});
        btnCassa.setFocusable(false);
        btnCliente.setFocusable(false);
        btnCliente.addActionListener(e -> {frame.dispose(); new ClienteFrame();});
        
		frame.setTitle("Gestionale Ristorante");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,600);
		frame.setIconImage(img.getImage());
        frame.add(btnCassa);
        frame.add(btnCliente);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));//LEADING E' TUTTO A SINISTRA, senza e' centrato
        frame.setResizable(false);
        frame.setVisible(true);
        
        
       
        
    }

    /* NON VA
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnCliente){
            this.dispose();
            ClienteFrame windowCliente = new ClienteFrame();
        }
    }*/

}
