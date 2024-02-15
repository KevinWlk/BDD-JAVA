import com.addresse.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormUser extends JDialog{
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
    private JButton cliquePasIciButton;

    public FormUser(JDialog parent){
        super(parent);
        setTitle("Ma super fenêtre");
        setContentPane(jpMain);
        setMinimumSize(new Dimension(300 ,400));
        setModal(false);
        setVisible(true);
        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Récupérer les valeurs saisies dans les champs de texte
                String nom = tfNom.getText();
                String prenom = tfPrenom.getText();
                String email = tfMail.getText();
                String password = tfPassword.getText();

                User newUser = new User(nom, prenom, email, password);

                System.out.println("-------------------------------------------------------------------");
                System.out.println("Liste des utilisateurs :");
                System.out.println("-------------------------------------------------------------------");
                System.out.printf("| %-10s | %-10s | %-20s | %-15s |\n", "Nom", "Prénom", "Email", "Password");
                System.out.println("-------------------------------------------------------------------");
                System.out.printf("| %-10s | %-10s | %-20s | %-15s |\n",
                        newUser.getNom(), newUser.getPrenom(), newUser.getEmail(), newUser.getPassword());
                System.out.println("-------------------------------------------------------------------");
            }
        });
    }
}
