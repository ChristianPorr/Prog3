import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class CassaFrame extends Frame{
    JButton btnCompletaOrd = new JButton();
    public CassaFrame() {
    	JPanel panel = new JPanel();
    	JTextArea textArea = new JTextArea(30,30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JButton btnClear = new JButton("Clear");
        
        int i;
        
        for(i=1;i<=20;i++) {
        try {
            File myObj = new File("tav"+i+".txt");
            Scanner myReader = new Scanner(myObj);
            //panel.add(new JButton("Tavolo: "+i).addActionListener(e -> ));
            /*
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }*/
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("Non esiste il tav"+i);
            //e.printStackTrace();
          }
        }
    	
        frame.setTitle("Cassa");
        btnCompletaOrd.setText("Completa ordine!");

        btnCompletaOrd.addActionListener(e -> completaOrd());
        btnCompletaOrd.setFocusable(false);
        
        
        panel.add(btnClear);
        frame.add(panel);
        frame.add(scrollPane, BorderLayout.LINE_END);
        frame.add(btnCompletaOrd, BorderLayout.SOUTH);
    }
    
    private void showOrder(){
    	//Aggiungiamo l'ordine al textArea...
    }

    public void completaOrd(){
        String[] answ = {"Si","No"};
        int scelta;//0 si, 1 no
        scelta = JOptionPane.showOptionDialog(null,
                                     "Sei sicuro delle tue scelte?",
                                      "Invio ordine...",
                                       JOptionPane.YES_NO_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE,
                                         img,
                                          answ,
                                           0);
        System.out.println(scelta);
        
    }
    
    
}
