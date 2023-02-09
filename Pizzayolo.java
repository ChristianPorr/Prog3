import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Pizzayolo extends Frame implements Cuoco{
	
	private ArrayList<Tavolo> reference = new ArrayList<Tavolo>();
	private ArrayList<String> listaPizze = new ArrayList<String>();
	private ArrayList<Ordine> listaOrdini = new ArrayList<Ordine>();
	private JTextArea textArea = new JTextArea(50,40);
	private JPanel textPanel = new JPanel();
	private JButton nextOrd = new JButton("Ordine concluso");
	private Integer ordineSelezionato;
	private JPanel botPanel = new JPanel(new FlowLayout());
	private JButton btnStorico = new JButton("Storico ordini");
	
	//private LinkedList<LinkedList<String>> TODO = new LinkedList<LinkedList<String>>();
	
	public Pizzayolo() {
		frame.setTitle("Gestionale Ristorante-Pizzaiolo");
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JScrollPane scrollPanel = new JScrollPane(panel);
		JScrollPane textScrollPanel = new JScrollPane(textPanel);
		textScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		textArea.setFont(new Font("Courier", Font.BOLD, 15));
		textArea.setEditable(false);
		//fare delle piccole cards con all'interno l'ordine. IDEA aggiungere ogni volta dei pannelli con il bottone ai lati del PANNELLO al centro la text area
		textPanel.add(textArea);
		nextOrd.addActionListener(e -> {
			infornaPizze(this.ordineSelezionato);
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
				textArea.append("\n\t|----------|\n");
			}
		});
		botPanel.add(btnStorico);
		
		frame.add(botPanel, BorderLayout.SOUTH);
		frame.add(scrollPanel, BorderLayout.WEST);
		frame.add(textScrollPanel, BorderLayout.CENTER);
		frame.add(nextOrd, BorderLayout.EAST);
		
		System.out.println("Pizzayolo creato!");
		Menu menu = new Menu();
		for(Pietanze element : menu.sP) {
			listaPizze.add(element.getNome());
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
			for(String nomePietanza : listaPizze) {
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
	
	public void infornaPizze(Integer numTavolo) {
		System.out.println("Il pizzaiolo sta infornando le pizze");
		/*Questo sara il bottone che toglie da listaOrdini l'ordine selezionato
		 * e dal frame il pannellino contenente la card dell'ordine ( frame.remove(PANNELLO_ORDINE_SCELTO) )
		 */
		//tav.setStatusOrdine(new OrdineConsegnato());
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
