import com.addresse.model.User;
import com.addresse.model.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormUser extends JDialog {
    private JPanel jpMain;
    private JTextField tfNom;
    private JTextField tfPrenom;
    private JTextField tfMail;
    private JPasswordField pfPassword;
    private JLabel jlNom;
    private JLabel jlPrenom;
    private JLabel jlMail;
    private JLabel jlPassword;
    private JButton jbAdd;

    public FormUser(JDialog parent) {
        super(parent);
        setTitle("Formulaire d'inscription");
        setContentPane(jpMain);
        setMinimumSize(new Dimension(300, 400));
        setModal(false);
        setVisible(true);
        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vérification des champs vides
                if (tfNom.getText().isEmpty() || tfPrenom.getText().isEmpty() || tfMail.getText().isEmpty() || String.valueOf(pfPassword.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(parent,
                            "Veuillez remplir tous les champs du formulaire",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Vérification du format de l'e-mail (regex)
                String emailRegex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(tfMail.getText());
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(parent,
                            "Veuillez saisir une adresse e-mail valide",
                            "Erreur",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // Vérification du mot de passe (regex)
                String password = String.valueOf(pfPassword.getPassword());
                if (password.length() < 12 || !password.matches(".*\\d.*") || !password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*")) {
                    JOptionPane.showMessageDialog(parent,
                            "Le mot de passe doit contenir au moins 12 caractères, des chiffres, une lettre minuscule et une lettre majuscule",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Vérification de l'existence de l'utilisateur dans la BDD par l'email
                User newUser = new User(tfNom.getText(), tfPrenom.getText(), tfMail.getText(), String.valueOf(pfPassword.getPassword()));
                User existingUser = UserManager.findUser(newUser);
                if (existingUser.getId() != 0) {
                    JOptionPane.showMessageDialog(parent,
                            "L'utilisateur avec l'adresse e-mail " + newUser.getEmail() + " existe déjà.",
                            "Utilisateur existant",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    // Ajout de l'utilisateur à la base de données
                    User addedUser = UserManager.addUser(newUser);
                    if (addedUser != null) {
                        JOptionPane.showMessageDialog(parent,
                                "Le compte a été ajouté à la base de données avec succès.",
                                "Succès",
                                JOptionPane.INFORMATION_MESSAGE);
                        // Fermer la fenêtre après l'ajout de l'utilisateur
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(parent,
                                "Une erreur est survenue lors de l'ajout de l'utilisateur à la base de données.",
                                "Erreur",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
