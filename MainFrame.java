import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = new Dimension(425,300);
		panel = new JPanel(new BorderLayout());
		pannelloClienti = new JPanel(new GridBagLayout());
		pannelloCassa = new JPanel(new GridBagLayout());
        btnCassa = new JButton();
        btnCliente = new JButton();

      
        panel.add(pannelloClienti,BorderLayout.CENTER);
        panel.add(pannelloCassa,BorderLayout.PAGE_END);
        
        
		pannelloClienti.setPreferredSize(dim);
		pannelloCassa.setPreferredSize(dim);
        
        
        Border bordoClienteInterno = BorderFactory.createTitledBorder("Area Clienti");
		Border bordoClienteEsterno = BorderFactory.createEmptyBorder(10,10,10,10);
		Border bordoClienteFinale = BorderFactory.createCompoundBorder(bordoClienteInterno, bordoClienteEsterno);
		((TitledBorder) bordoClienteInterno).setTitleJustification(TitledBorder.CENTER);
		pannelloClienti.setBorder(bordoClienteFinale);
		
		Border bordoCassaInterno = BorderFactory.createTitledBorder("Area Cassa");
		Border bordoCassaEsterno = BorderFactory.createEmptyBorder(10,10,10,10);
		Border bordoCassaFinale = BorderFactory.createCompoundBorder(bordoCassaInterno, bordoCassaEsterno);
		((TitledBorder) bordoCassaInterno).setTitleJustification(TitledBorder.CENTER);
		pannelloCassa.setBorder(bordoCassaFinale);

		
        frame.setTitle("Gestionale Ristorante");
		frame.setSize(850,600);
		frame.setIconImage(img.getImage());
        frame.setResizable(false);
        frame.setVisible(true); 
        frame.add(label,BorderLayout.PAGE_START);
        frame.add(panel);
        
        panel.setVisible(true);
        
        btnCassa.setText("Cassa");
        btnCassa.addActionListener(e -> {new Sala();});
        btnCassa.setFocusable(false);
        
        btnCliente.setText("Cliente");
        btnCliente.setFocusable(false);
        btnCliente.addActionListener(e -> {new ClienteFrame();});
        
        ///GBC
        GridBagConstraints gbc = new GridBagConstraints();
        
      //Bottone Cliente
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        
        gbc.ipadx = 30;
        gbc.ipady = 30;
        
        pannelloClienti.add(btnCliente,gbc);
        
        //Bottone Cassa
        gbc.gridx = 0;
        gbc.gridy = 1;
        
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        
        gbc.ipadx = 30;
        gbc.ipady = 30;
        
        pannelloCassa.add(btnCassa,gbc); 
    }

}