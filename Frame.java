import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class Frame {
    //istruzioni standard
    JButton btnCassa = new JButton();
    JButton btnCameriere = new JButton();
    JButton btnCliente = new JButton();
    ImageIcon img = new ImageIcon("icon.png");
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JMenuBar menuBar = new JMenuBar();

    public Frame(){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900,600);
    frame.setIconImage(img.getImage());
    //frame.setLayout(new FlowLayout(FlowLayout.LEFT));//LEADING E' TUTTO A SINISTRA, senza e' centrato
    //frame.setLayout(new FlowLayout());
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);

    }
}
