import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JPanel mainPanel;
    String tavoloSelezionato = new String();
    Integer iTavoli=0;
    ClienteFrame riferimento;
    Tavolo tmp;
    
    Cassiere(){
    	start();
    }
    
    Cassiere(ClienteFrame cf){
    	this.riferimento=cf;
    	start();
    }
	public void start(){
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
		JButton btn = new JButton("Libera tavolo");
		btn.addActionListener(e -> {
			String tmp[] = {"Carta di credito", "Contanti"};
			Integer risposta;
			risposta = JOptionPane.showOptionDialog(null, "Scegli il metodo di pagamento:", "Pagamento",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tmp, 0);
			System.out.println("risposta: "+risposta);
			System.out.println("Il bottone "+this.tavoloSelezionato);
			if(risposta>=0) {
				//tavoli.remove(tavoli.indexOf(buttonPanel))
				System.out.println("Stai liberando il tavolo "+tavoloSelezionato);
				this.removeButton();
				this.riferimento.rinnovaTavolo(this.tmp);
			}
			
			}
		);
		buttonPanel.add(btn);
		
		
		mainPanel = new JPanel(new FlowLayout());
		
		for(Integer i=1;i<=20;i++) {
			btnTav.add(new JButton("Tavolo: "+i));
			btnTav.get(i-1).setEnabled(false);
			this.mainPanel.add(btnTav.get(i-1));
		}
		
		mainPanel.add(new JButton("bottoneProva"));
		
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
		if(tavolo.getChiusura()) {//SE CHIUSO ALLORA AGGIUNGILO ALLA SCHERMATA
			
			String btnName = ("Tavolo: "+ tavolo.getNumTav());
			
			this.btnTav.get(tavolo.getNumTav()-1).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
				getInfo(tavolo);
				tavoloSelezionato=btnName;
				}
			});
			this.btnTav.get(tavolo.getNumTav()-1).setEnabled(true);
			
			
			
			this.validate();
		}

	}

	public void getInfo(Tavolo tavolo) {
		this.tmp=tavolo;
		this.textArea.setText("");
		this.textArea.append("Tavolo n"+tavolo.getNumTav()+":\n");
		for(Pietanze p : tavolo.getOrdineFinale().getPietanze()) {
			textArea.append(p.getNome()+" x"+p.getQnt()+" ("+p.getPrezzo()+" e)\n");
		}
		textArea.append("Totale: "+tavolo.getTot()+" e");
		//this.tavoloSelezionato=tavolo.getNumTav();
		
	}
	
	public void removeButton() {
		
		
		for(JButton btn : this.btnTav) {
			if(tavoloSelezionato.equals(btn.getText())) {
				
				for(ActionListener al : btn.getActionListeners()) {
					btn.removeActionListener(al);
				}
				btn.setEnabled(false);
			}
		}
		this.textArea.setText("");

		//IMPORTANT
		mainPanel.validate();
		mainPanel.repaint();
		
	}

	
}

	









