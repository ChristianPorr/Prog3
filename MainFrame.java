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

	MainFrame(){
	FlowLayout flow = new FlowLayout();
	Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
		    
	blackline = BorderFactory.createLineBorder(Color.black);
	raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	raisedbevel = BorderFactory.createRaisedBevelBorder();
	loweredbevel = BorderFactory.createLoweredBevelBorder();
	empty = BorderFactory.createEmptyBorder();
	
	Dimension dim = new Dimension(170,120);
	panel = new JPanel(new FlowLayout());
	
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
    
    panelClienti.add(btnCliente);
    panelSala.add(btnSala);
    panelChef.add(btnChef);
    panelPizzayolo.add(btnPizzayolo);
    panelCassiere.add(btnCassiere);
    

    panel.setVisible(true);
    panel.add(panelClienti);
    panel.add(panelSala);
    panel.add(panelCassiere);
    panel.add(panelPizzayolo);
    panel.add(panelChef);
    
        
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
    btnSala.addActionListener(e -> {new Sala();});
    btnSala.setFocusable(false);
        
    btnCliente.setText("Cliente");
    btnCliente.setFocusable(false);
    btnCliente.addActionListener(e -> {new ClienteFrame();});
    
    
    btnCassiere.setText("Cassa");
    btnCassiere.setFocusable(false);
    btnCassiere.addActionListener(e -> {new Cassiere();});
        
    btnPizzayolo.setText("Pizzayolo");
    btnPizzayolo.setFocusable(false);
    btnPizzayolo.addActionListener(e -> {new Pizzayolo();});
        
        
    btnChef.setText("Chef");
    btnChef.setFocusable(false);
    btnChef.addActionListener(e -> {new Chef();});
   
    
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