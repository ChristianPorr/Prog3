import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class MainFrame extends Frame{
    JButton btnCassa, btnCliente; 
    JPanel panel,pannelloClienti,pannelloCassa;

	MainFrame(){	
		JLabel label = new JLabel("Benvenuti");
		panel = new JPanel(new BorderLayout());
		pannelloClienti = new JPanel(new GridBagLayout());
		pannelloCassa = new JPanel(new GridBagLayout());
        btnCassa = new JButton();
        btnCliente = new JButton();
        
        panel.add(pannelloClienti,BorderLayout.PAGE_START);
        panel.add(pannelloCassa,BorderLayout.CENTER);
        
        Border bordoClienteInterno = BorderFactory.createTitledBorder("Area Clienti");
		Border bordoClienteEsterno = BorderFactory.createEmptyBorder(10,10,10,10);
		Border bordoClienteFinale = BorderFactory.createCompoundBorder(bordoClienteInterno, bordoClienteEsterno);
		pannelloClienti.setBorder(bordoClienteFinale);
		
		Border bordoCassaInterno = BorderFactory.createTitledBorder("Area Cassa");
		Border bordoCassaEsterno = BorderFactory.createEmptyBorder(10,10,10,10);
		Border bordoCassaFinale = BorderFactory.createCompoundBorder(bordoCassaInterno, bordoCassaEsterno);
		pannelloCassa.setBorder(bordoCassaFinale);
		
		
		
	
        frame.setTitle("Gestionale Ristorante");
		frame.setSize(850,600);
		frame.setIconImage(img.getImage());
        frame.setResizable(false);
        frame.setVisible(true); 
        frame.add(panel);
        
        panel.setVisible(true);
        
        btnCassa.setText("Cassa");
        btnCassa.addActionListener(e -> {frame.dispose(); new CassaFrame();});
        btnCassa.setFocusable(false);
        
        btnCliente.setText("Cliente");
        btnCliente.setFocusable(false);
        btnCliente.addActionListener(e -> {frame.dispose(); new ClienteFrame();});
        
        ///GBC
        GridBagConstraints gbc = new GridBagConstraints();
        
        //Bottone Cliente
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        gbc.gridwidth = 3;
        
        gbc.ipadx = 30;
        gbc.ipady = 30;
        
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        
        pannelloClienti.add(btnCliente,gbc);
        
        //Bottone Cassa
        gbc.gridx = 1;
        gbc.gridy = 0;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        gbc.gridwidth = 3;
        
        gbc.ipadx = 30;
        gbc.ipady = 30;
        
        gbc.anchor = GridBagConstraints.LINE_START;
        pannelloCassa.add(btnCassa,gbc);
        
        
    }

}