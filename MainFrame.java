import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class MainFrame extends Frame{
    JButton btnCassa, btnCameriere, btnCliente; 
    
    MainFrame(){

    	
        btnCassa = new JButton();
        btnCliente = new JButton();

        btnCassa.setText("Cassa");
        btnCliente.setText("Cliente");
        btnCassa.addActionListener(e -> {frame.dispose(); new CassaFrame();});
        btnCassa.setFocusable(false);
        btnCliente.setFocusable(false);
        btnCliente.addActionListener(e -> {frame.dispose(); new ClienteFrame();});
        
		frame.setTitle("Gestionale Ristorante");
		frame.setSize(900,600);
		frame.setIconImage(img.getImage());
		//frame.add(btnCameriere);
        frame.add(btnCassa);
        frame.add(btnCliente);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));//LEADING E' TUTTO A SINISTRA, senza e' centrato
        frame.setResizable(false);
        frame.setVisible(true);
        
        
        JTextArea textArea = new JTextArea(30,30);
           
    }

}