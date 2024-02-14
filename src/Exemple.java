import javax.swing.*;
import java.awt.*;

public class Exemple extends JDialog{
    private JPanel jpMain;
    private JTextField tfNom;
    private JTextField tfPrenom;
    private JTextField tfMail;
    private JTextField tfPassword;
    private JLabel jlNom;
    private JLabel jlPrenom;
    private JLabel jlMail;
    private JLabel jlPassword;
    private JButton jbAdd;

    public Exemple(JDialog parent){
        super(parent);
        setTitle("Ma super fenêtre");
        setContentPane(jpMain);
        setMinimumSize(new Dimension(300 ,400));
        setModal(false);
        setVisible(true);
    }
}
