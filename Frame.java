import javax.swing.*;
import java.awt.*;


public abstract class Frame {
    //istruzioni standard
	JPanel panel = new JPanel(new BorderLayout());
    JButton btnCassa = new JButton();
    JButton btnCliente = new JButton();
    ImageIcon img = new ImageIcon("icon.png");
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JMenuBar menuBar = new JMenuBar();
    Tavolo tav[];
    
    public Frame(){
    
    
    frame.setSize(800,600);
    frame.setIconImage(img.getImage());
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    
    }
}
