import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Cassiere extends JFrame implements Cassa {

	private Integer n=0;
	private static Integer numeroCassa = 0;
	private Integer idCassa;
	Vector<JButton> btnTav = new Vector<JButton>();
    Integer txtCount=0;
    JTextArea textArea = new JTextArea(10,30);
    JButton btnLiberaT = new JButton("Libera");
    JPanel mainPanel;
	
	Cassiere(){
		numeroCassa++;
		idCassa=numeroCassa;
		
		textArea.setEditable(false);
		JPanel buttonPanel = new JPanel(new FlowLayout());
		JButton btn = new JButton("Prova");
		btn.addActionListener(e -> aggiungiComanda(new Tavolo()));
		buttonPanel.add(btn);
		
		mainPanel = new JPanel(new FlowLayout());
		
		
		
		this.setSize(800,600);
	    this.setResizable(false);
	    this.setVisible(true);
	    this.setLocationRelativeTo(null);
	    
	    
	    this.add(buttonPanel, BorderLayout.PAGE_END);
	    this.add(textArea, BorderLayout.EAST);
	    this.add(mainPanel);
	    
	}
	
	@Override
	public void aggiungiComanda(Tavolo tavolo) {
		JButton btnTav = new JButton("btn "+ ++n);
		
		btnTav.addActionListener(e -> getInfo(tavolo));
		
		
		mainPanel.add(btnTav);
		this.validate();
	
	}
	
	public void getInfo(Tavolo tavolo) {
		tavolo.resocontoOrdini();
		this.textArea.setText("");
		this.textArea.append("Tavolo n"+tavolo.getNumTav()+":\n");
		for(Pietanze p : tavolo.getOrdineFinale().getPietanze()) {
			textArea.append(p.getNome()+" x"+p.getQnt()+" prezzo al pezzo: "+p.getPrezzo()+" e\n");
		}
		textArea.append("Totale: "+tavolo.getTot()+" e");
		
			
	}
	
}











