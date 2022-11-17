import javax.swing.*;

public class CassaFrame extends Frame{
    JButton btnCompletaOrd = new JButton();
    public CassaFrame() {
        label.setText("Cassa");
        btnCompletaOrd.setText("Completa ordine!");

        btnCompletaOrd.addActionListener(e -> completaOrd());
        btnCompletaOrd.setFocusable(false);

        frame.add(label);
        frame.add(btnCompletaOrd);
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
