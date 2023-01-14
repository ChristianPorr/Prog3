import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.util.Formatter;

public class CassaFrame extends Frame{
    JButton btnHome = new JButton("Home");
    Vector<JButton> btnTav = new Vector<JButton>();
    Integer txtCount=0;
    public CassaFrame() {
    	JPanel panel = new JPanel();
    	JTextArea textArea = new JTextArea(30,30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> {
        								textArea.replaceRange("", 0, this.txtCount);
        								});
        
        btnHome.addActionListener(e -> {frame.dispose(); new MainFrame();});
        
        int i;
        
        for(i=1;i<=20;i++) {
        	File myObj = new File("tav"+i+".txt");
        	if(myObj.exists()) {
				btnTav.add(new JButton("Tavolo: "+i));
				final Integer ii = new Integer(i);
				btnTav.lastElement().addActionListener(e -> showOrder(ii, myObj, textArea));
				panel.add(btnTav.lastElement());
			}
        }
    	
        frame.setTitle("Cassa");
      
        panel.add(btnClear);
        panel.add(btnHome);
        frame.add(panel);
        frame.add(scrollPane, BorderLayout.LINE_END);
    }
    
    private void showOrder(Integer i, File file, JTextArea txt){
    	//Aggiungiamo l'ordine al textArea...
    	Scanner myReader;
    	String tmpCounter;
		try {
			myReader = new Scanner(file);
			String temp, temptxt;
	    	temptxt = txt.getText();
	    	if(!temptxt.isEmpty()) {
	    		txt.replaceRange("", 0, temptxt.length());
	    	}
	    	txt.append("Il tavolo "+i+" ha ordinato:\n");
	    	while(myReader.hasNextLine()) {
	    		temp = myReader.nextLine();
	    		txt.append(temp+"\n");
	    	}
	    	tmpCounter=txt.getText();
	    	this.txtCount = tmpCounter.length();
	    	myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Scanner non trovato");
		}
    } 
}
