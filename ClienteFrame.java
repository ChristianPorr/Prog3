import java.util.*;
import javax.swing.*;
import java.awt.*;


public class ClienteFrame extends Frame {
    JCheckBox cBox = new JCheckBox();
    JPanel panel = new JPanel();
    int risposta;
    
    
    

    public ClienteFrame(){
        frame.setTitle("Gestionale Ristorante-Cliente");
        label.setText("Menù");
        label.setFont(new Font(null, Font.ITALIC,25));
        frame.getContentPane().add(label, BorderLayout.PAGE_START); //SCRITTA MENU

        btnCliente.setText("Conferma ordine!");
        btnCliente.addActionListener(e -> confermaOrdine());
        btnCliente.setFocusable(false);
        frame.getContentPane().add(btnCliente, BorderLayout.SOUTH); 

        cBox.setFocusable(false);
        
        //INIZIALIZZAZIONE OGGETTI
        JPanel panPietanze = new JPanel();//quasi effimero
        JComboBox Pizze = new JComboBox<String>();
        JComboBox Bevande = new JComboBox<String>();
        Menu menu = new Menu();

        

        //MENU A TENDINA DI PIZZE E BEVANDE
        int i;
        for (i=0;i<menu.sP.size();i++){
            Pizze.addItem(menu.sP.get(i).getNome());
        }
       add(Pizze,BorderLayout.LINE_START);
        
        
        for(i=0;i<menu.sB.size();i++) {
        	Bevande.addItem(menu.sB.get(i).getNome());
        }
        
        

        JButton btnAdd = new JButton("+");
        JButton btnDec = new JButton("-");

        JTextArea textArea = new JTextArea(30,10);
        textArea.setEditable(false);

        frame.add(textArea, BorderLayout.LINE_END);


        
        //btnAdd.addActionListener(e -> addingP(jl));

        panPietanze.add(Pizze);
        panPietanze.add(Bevande);
        panPietanze.add(btnAdd);
        panPietanze.add(btnDec);

        frame.getContentPane().add(panPietanze);
    }
    
    
    
    

    private void add(JComboBox pizze, String lineStart) {
		// TODO Auto-generated method stub
		
	}





	public void confermaOrdine(){
        String[] answ = {"Si","No"};
        int scelta;//0 si, 1 no
        scelta = JOptionPane.showOptionDialog(null,
                                     "Sei sicuro delle tue scelte?",
                                      "Invio ordine...",
                                       JOptionPane.YES_NO_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE,
                                         null,answ,0);
        System.out.println(scelta);
        this.risposta=scelta;
    }

    public void showMenu(){
        Menu menu = new Menu();
        int i;
		for(i=0;i<menu.sP.size();i++){
            
        }
    }

    

}
