import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


public class Chef extends Frame implements Cuoco{

	
	private ArrayList<Tavolo> reference = new ArrayList<Tavolo>();
	private ArrayList<String> listaPrimiPiatti = new ArrayList<String>();
	private ArrayList<Ordine> listaOrdini = new ArrayList<Ordine>();
	private JTextArea textArea = new JTextArea(50,40);
	private JPanel textPanel = new JPanel();
	private JButton nextOrd = new JButton("Ordine concluso");
	private Integer ordineSelezionato;
	private JPanel botPanel = new JPanel(new FlowLayout());
	private JButton btnStorico = new JButton("Storico ordini");
	
	
	public Chef() {
		frame.setTitle("Gestionale Ristorante-Chef");
		
		Border raisedetched, loweredetched;
		raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JScrollPane scrollPanel = new JScrollPane(panel);
		JScrollPane textScrollPanel = new JScrollPane(textPanel);
		textScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		textArea.setFont(new Font("Courier", Font.BOLD, 15));
		textArea.setEditable(false);
		
		//Personalizzazione componenti
		textPanel.setBackground(new Color(0,255,127));
		textArea.setBackground(new Color(239,239,239));
		panel.setBackground(new Color(239,239,239));
		
		
		nextOrd.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		panel.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		textArea.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		textPanel.setBorder(BorderFactory.createCompoundBorder(raisedetched,loweredetched));
		
		
		//Action Listener Bottoni
		textPanel.add(textArea);
		nextOrd.addActionListener(e -> {
			cucina(this.ordineSelezionato);
			nextOrd.setEnabled(false);
			frame.revalidate();
		});
		btnStorico.addActionListener(e -> {
			textArea.setText("");
			for(Ordine ord : listaOrdini) {
				textArea.append("Ordine numero: "+ord.getNumOrd()+"\tTavolo: "+ord.getNumTavolo()+"\n");
				for(Pietanze p : ord.getPietanze()) {
					textArea.append("-"+p.getNome()+" x"+p.getQnt()+"\n");
				}
				textArea.append("\t|----------|\n");
			}
		});
		botPanel.add(btnStorico);
		
		frame.add(botPanel, BorderLayout.SOUTH);
		frame.add(scrollPanel, BorderLayout.WEST);
		frame.add(textScrollPanel, BorderLayout.CENTER);
		frame.add(nextOrd, BorderLayout.EAST);
		
		System.out.println("Chef creato!");
		Menu menu = new Menu();
		for(Pietanze element : menu.sPP) {
			listaPrimiPiatti.add(element.getNome());
		}
	}
	
	@Override
	public void updateTODO(Tavolo tav, Ordine ordine) {
		Boolean trovato=false;
		Ordine ordTmp = new Ordine(ordine.getNumTavolo());
		/*Prendo le pietanze che riesce a fare il Pizzaiolo (pizze) e le aggiungo in ordine tmp che poi verra aggiunto agli ordini
		 *del pizzaiolo e che verra mostrato nel pannello */
		for(Tavolo t : this.reference) {
			if(t.getNumTav()==tav.getNumTav()) {
				trovato=true;
			}
		}
		if(!trovato) {
			reference.add(tav);
		}
		for(Pietanze elem : ordine.getPietanze()) {
			for(String nomePietanza : listaPrimiPiatti) {
				if(nomePietanza==elem.getNome()) {
					ordTmp.aggiungiPietanza(nomePietanza, elem.getQnt());
				}
			}
		}
		if(!ordTmp.getPietanze().isEmpty()) {
			listaOrdini.add(ordTmp);
			JButton btnTmp = new JButton("Ordine numero: "+ordine.getNumOrd());
			btnTmp.addActionListener(e -> {
				textArea.setText("Ordine numero: "+ordine.getNumOrd()+"\n");
				for(Pietanze p : ordTmp.getPietanze()) {
					textArea.append(p.getNome()+" x"+p.getQnt()+"\n");
				}
				this.ordineSelezionato=ordine.getNumTavolo();
				if(ordTmp.getState() instanceof OrdineConsegnato)
					nextOrd.setEnabled(true);
			});
			panel.add(btnTmp);
			frame.revalidate();
			tav.setStatusOrdine(new OrdineRicevuto());
		}
		/*
			this.textArea.append("[ORDINE] Ho aggiunto il tavolo "+ordTmp.getNumTavolo()+"\n");
			for(Pietanze pietanza : ordTmp.getPietanze()) {
				this.textArea.append("[ORDINE] Pietanza: "+pietanza.getNome()+" qnt: "+pietanza.getQnt()+"\n");
			}
		 */
		
	}
	
	public void cucina(Integer numTavolo) {
		System.out.println("Lo Chef sta preparando gli ingredienti");
		/*Questo sara il bottone che toglie da listaOrdini l'ordine selezionato
		 * e dal frame il pannellino contenente la card dell'ordine ( frame.remove(PANNELLO_ORDINE_SCELTO) )
		 */
		Integer delete=0;
		Boolean changed=false;
		for(Ordine ord : this.listaOrdini) {
			if(ord.getNumTavolo()==numTavolo) {
				ord.setState(new OrdineConsegnato());
			}
		}
		for(Integer i=0;i<reference.size();i++) {
			if(reference.get(i).getNumTav()==numTavolo) {
				reference.get(i).setStatusOrdine(new OrdineConsegnato());
				changed=true;
				delete=i;
			}
		}
		if(changed) {
			reference.remove(delete);
			}
	}
	
	

}