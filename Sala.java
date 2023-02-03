import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.util.Formatter;

public class Sala extends Frame implements Admin{
    JButton btnHome = new JButton("Home");
    Vector<JButton> btnTav = new Vector<JButton>();
    Integer txtCount=0;
    JTextArea textArea;
    JPanel panel;
    JButton btnLiberaT = new JButton("Libera");
    public Sala() {    	
    	Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
	    
    	blackline = BorderFactory.createLineBorder(Color.black);
    	raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    	loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    	raisedbevel = BorderFactory.createRaisedBevelBorder();
    	loweredbevel = BorderFactory.createLoweredBevelBorder();
    	empty = BorderFactory.createEmptyBorder();
    	
    	btnLiberaT = new JButton("Libera");
    	textArea = new JTextArea(30,30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> {textArea.setText("");});
        btnHome.addActionListener(e -> {new MainFrame();});
        btnLiberaT.addActionListener(e -> {liberaTav();});
        
        
        panel = new JPanel();
	
		panel.setBorder(BorderFactory.createCompoundBorder(raisedbevel,loweredbevel));



		
		for(Integer i=1;i<=20;i++) {
			btnTav.add(new JButton("Tavolo: "+i));
			this.panel.add(btnTav.get(i-1));
		}
        //INSERISCI METODO DI PAGAMENTO
        
        
        
    	
        frame.setTitle("Cassa");
      
        panel.add(btnClear);
        panel.add(btnHome);
        panel.add(btnLiberaT);
       
        frame.add(panel);
        frame.add(scrollPane, BorderLayout.LINE_END);
    }


	public void liberaTav() {
		String txt, numTav;
		int n;
		txt = this.textArea.getText();
		numTav = txt.substring(10,12);
		if(numTav.contains(" ")) numTav = txt.substring(10,11);
		n = Integer.parseInt(numTav);
		File tavolo = new File("tav"+n+".txt");
		tavolo.delete();
	}



	@Override
	public void aggiungiComanda(Tavolo tavolo) {
		/*JButton btnT = new JButton("Tavolo "+ tavolo.getNumTav());
		for(JButton btn : this.btnTav) {
			if(btnT.getText()==btn.getText())*/
				this.btnTav.get(tavolo.getNumTav()-1).addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						getInfo(tavolo);
						}
					}
				);
			this.btnTav.get(tavolo.getNumTav()-1).setEnabled(true);
		//}

		frame.validate();

	}

	public void getInfo(Tavolo tavolo) {
		Double totParziale=0.0;
		this.textArea.setText("");
		this.textArea.append("Tavolo n"+tavolo.getNumTav()+":\n");
		for(Ordine ord : tavolo.getOrdine()) {

			for(Pietanze p : ord.getPietanze()) {
				textArea.append(p.getNome()+" x"+p.getQnt()+" ("+p.getPrezzo()+" e)\n");
				totParziale += p.getPrezzo()*p.getQnt();
			}
			textArea.append("Il totale relativo a quest'ordine e': "+totParziale+"\n");
			totParziale=0.0;
			textArea.append("\n\t|----------------------| \n");
		}


	}
    
}

