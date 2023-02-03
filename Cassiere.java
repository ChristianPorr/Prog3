import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class Cassiere extends JFrame implements Admin {
	
	private static Integer numeroCassa = 0;
	private Integer idCassa;
	Vector<JButton> btnTav = new Vector<JButton>();
    Integer txtCount=0;
    JTextArea textArea = new JTextArea(10,30);
    JButton btnLiberaT = new JButton("Libera");
    JPanel mainPanel;
	
	Cassiere(){
		Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
	    
		blackline = BorderFactory.createLineBorder(Color.black);
		raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder();
		
		numeroCassa++;
		idCassa=numeroCassa;
		this.setTitle("Gestionale Ristorante-Cassa n"+idCassa);
		
		textArea.setBorder(BorderFactory.createCompoundBorder(raisedbevel,loweredbevel));
		textArea.setEditable(false);
		JPanel buttonPanel = new JPanel(new FlowLayout());
		JButton btn = new JButton("Prova");
		btn.addActionListener(e -> aggiungiComanda(new Tavolo()));
		buttonPanel.add(btn);
		
		mainPanel = new JPanel(new FlowLayout());
		
		this.mainPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory
			      .createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		this.mainPanel.setBackground(new Color(1,121,111));
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
		JButton btnTav = new JButton("Tavolo "+ tavolo.getNumTav());

		btnTav.addActionListener(e -> getInfo(tavolo));


		mainPanel.add(btnTav);
		this.validate();

	}

	public void getInfo(Tavolo tavolo) {
		//if(tavolo.getChiusura()) {
		this.textArea.setText("");
		this.textArea.append("Tavolo n"+tavolo.getNumTav()+":\n");
		for(Pietanze p : tavolo.getOrdineFinale().getPietanze()) {
			textArea.append(p.getNome()+" x"+p.getQnt()+" ("+p.getPrezzo()+" e)\n");
		}
		textArea.append("Totale: "+tavolo.getTot()+" e");
		//}	
	}
	
}











