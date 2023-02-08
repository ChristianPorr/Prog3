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
		
		
		panelClienti.setBackground(new Color(218,253,218));
		panelSala.setBackground(new Color(172,255,175));
		panelCassiere.setBackground(new Color(152,255,152));
		panelChef.setBackground(new Color(0,255,127)); //
		panelPizzayolo.setBackground(new Color(0,204,153));//
		
		    
	    /*Imposta il bordo dei pannelli*/
	    panelClienti.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		panelSala.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		panelChef.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		panelPizzayolo.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		panelCassiere.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		
		panel.add(panelClienti);
		panel.add(panelSala);
		panel.add(panelCassiere);
		panel.add(panelChef);
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