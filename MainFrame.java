import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class MainFrame extends Frame{
	private JButton btnSala,btnCliente,btnPizzayolo,btnCassiere,btnChef; 
	private JPanel panel,panelClienti,panelSala,panelPizzayolo,panelChef,panelCassiere;
	private ArrayList<Admin> admList = new ArrayList<Admin>();
	private ArrayList<Cuoco> cuochiList = new ArrayList<Cuoco>();

    
    

	@SuppressWarnings("unused")
	public MainFrame(){
		Dimension dim = new Dimension(170,120);
		 
		Border raisedetched, loweredetched;
			   
		raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);


		panel = new JPanel(new GridLayout(5,0));
		panelClienti = new JPanel();
		panelSala = new JPanel();
		panelCassiere = new JPanel();
		panelPizzayolo = new JPanel();
		panelChef = new JPanel();
		
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

	    /*Imposta la dimensione dei pannelli*/
	    panelClienti.setPreferredSize(dim);
		panelSala.setPreferredSize(dim);
		panelChef.setPreferredSize(dim);
		panelPizzayolo.setPreferredSize(dim);
		panelCassiere.setPreferredSize(dim);
		
		
		panelClienti.setBackground(new Color(255,191,0));
		panelSala.setBackground(new Color(172,255,175));
		panelChef.setBackground(new Color(1,121,111));
		panelPizzayolo.setBackground(new Color(255,253,208));
		panelCassiere.setBackground(new Color(255,77,0));
		    
	    /*Imposta il bordo dei pannelli*/
	    panelClienti.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		panelSala.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		panelChef.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		panelPizzayolo.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		panelCassiere.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		
		panel.add(panelClienti);
		panel.add(panelSala);
		panel.add(panelChef);
		panel.add(panelCassiere);
		panel.add(panelPizzayolo);
		
		
		frame.add(panel);
		
		/*Impostazioni del Frame*/
	    frame.setTitle("Gestionale Ristorante");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(850,600);
	    frame.setIconImage(img.getImage());
	    frame.setResizable(false);
	    frame.setVisible(true);
         
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