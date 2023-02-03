import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class MainFrame extends Frame{
    JButton btnSala,btnCliente,btnPizzayolo,btnCassiere,btnChef; 
    JPanel panel,panelClienti,panelSala,panelPizzayolo,panelChef,panelCassiere;
    ArrayList<Admin> admList = new ArrayList<Admin>();
    ArrayList<Cuoco> cuochiList = new ArrayList<Cuoco>();

	@SuppressWarnings("unused")
	MainFrame(){
    ImageIcon img = new ImageIcon("white.jpg");
	Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
		    
	blackline = BorderFactory.createLineBorder(Color.black);
	raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	raisedbevel = BorderFactory.createRaisedBevelBorder();
	loweredbevel = BorderFactory.createLoweredBevelBorder();
	empty = BorderFactory.createEmptyBorder();
	
	Dimension dim = new Dimension(170,120);
	panel = new JPanel(new GridBagLayout());
	
	panelClienti = new JPanel(new FlowLayout());
	panelSala = new JPanel(new FlowLayout());
	panelCassiere = new JPanel(new FlowLayout());
	panelPizzayolo = new JPanel(new FlowLayout());
	panelChef = new JPanel(new FlowLayout());
	
	btnSala = new JButton("Sala");
	btnPizzayolo = new JButton("Pizzayolo");
	btnChef = new JButton("Chef");
    btnCassiere = new JButton("Cassa");
    btnCliente = new JButton("Cliente");
    
    /*Aggiunge i bottoni ai relativi pannelli*/
    panelClienti.add(btnCliente);
    panelSala.add(btnSala);
    panelChef.add(btnChef);
    panelPizzayolo.add(btnPizzayolo);
    panelCassiere.add(btnCassiere);
    
    /*Aggiunge i pannelli al pannello principale*/ 
    panel.setVisible(true);
    panel.add(panelClienti);
    panel.add(panelSala);
    panel.add(panelChef);
    panel.add(panelPizzayolo);
    panel.add(panelCassiere);
       
    /*Imposta la dimensione dei pannelli*/
    panelClienti.setPreferredSize(dim);
	panelSala.setPreferredSize(dim);
	panelChef.setPreferredSize(dim);
	panelPizzayolo.setPreferredSize(dim);
	panelCassiere.setPreferredSize(dim);
	    
    /*Imposta il bordo dei pannelli*/
    panelClienti.setBorder(BorderFactory.createCompoundBorder(raisedbevel,loweredbevel));
	panelSala.setBorder(BorderFactory.createCompoundBorder(raisedbevel,loweredbevel));
	panelChef.setBorder(BorderFactory.createCompoundBorder(raisedbevel,loweredbevel));
	panelPizzayolo.setBorder(BorderFactory.createCompoundBorder(raisedbevel,loweredbevel));
	panelCassiere.setBorder(BorderFactory.createCompoundBorder(raisedbevel,loweredbevel));
         
    /*ActionListener dei Bottoni*/
    btnSala.setText("Sala");
        btnSala.addActionListener(e -> {
            Sala sala = new Sala();
            admList.add(sala); });
        btnSala.setFocusable(false);
        
    btnCliente.setText("Cliente");
    btnCliente.setFocusable(false);
        btnCliente.addActionListener(e -> {
            ClienteFrame clienteFrame = new ClienteFrame(admList, cuochiList);
        });
    
    
    btnCassiere.setText("Cassa");
    btnCassiere.setFocusable(false);
    btnCassiere.addActionListener(e -> {
        Cassiere cassiere = new Cassiere();
        admList.add(cassiere);});
        
    btnPizzayolo.setText("Pizzayolo");
    btnPizzayolo.setFocusable(false);
        btnPizzayolo.addActionListener(e -> {
            Pizzayolo pizzaiolo = new Pizzayolo();
            cuochiList.add(pizzaiolo);});
        
        
    btnChef.setText("Chef");
    btnChef.setFocusable(false);
        btnChef.addActionListener(e -> {
            Chef chef = new Chef();
            cuochiList.add(chef);});
    
    /*Impostazione del GridBagLayout*/
    GridBagConstraints gbc = new GridBagConstraints();
    
    /*Posizione Pannelli*/
    
    //Pannello Clienti
    gbc.gridx = 0;
    gbc.gridy = 0;
    
    gbc.weightx = 0.01;
    gbc.weighty = 0.01;
    
    gbc.insets = new Insets(100,30,0,0);  
    
    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    
    panel.add(panelClienti,gbc);
    
    //Pannello Sala
    gbc.gridx = 1;
    gbc.gridy = 0;
    
    gbc.weightx = 0.01;
    gbc.weighty = 0.01;
    
    gbc.anchor = GridBagConstraints.PAGE_START;
    
    panel.add(panelSala,gbc);
   
    //Pannello Cassiere
    gbc.gridx = 2;
    gbc.gridy = 0;
    
    gbc.weightx = 0.01;
    gbc.weighty = 0.01;
    
    gbc.insets = new Insets(100,30,30,30);  
    
    gbc.anchor = GridBagConstraints.FIRST_LINE_END;
    
    panel.add(panelCassiere,gbc);
    
    //Pannello Chef
    gbc.gridx = 0;
    gbc.gridy = 1;
    
    gbc.weightx = 0.01;
    gbc.weighty = 0.01;
    
    gbc.gridwidth = 2;
    
    gbc.insets = new Insets(0,0,100,0); 
   
    gbc.anchor = GridBagConstraints.CENTER;
    
    panel.add(panelChef,gbc);
    
    //Pannello Pizzayolo
    gbc.gridx = 1;
    gbc.gridy = 1;
    
    gbc.weightx = 0.01;
    gbc.weighty = 0.01;
    
    gbc.insets = new Insets(0,0,100,0); 
    
    gbc.anchor = GridBagConstraints.CENTER;
    
    panel.add(panelPizzayolo,gbc);
   
    
    /*Impostazioni del Frame*/
    frame.setTitle("Gestionale Ristorante");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(850,600);
    frame.setIconImage(img.getImage());
    frame.setResizable(false);
    frame.setVisible(true); 
    frame.add(label,BorderLayout.PAGE_START);
    frame.add(panel);
    frame.getContentPane().add(panel);

    }

}