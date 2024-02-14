import com.addresse.model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DbConnexion.getConnexion();

        User userToDelete = new User();
        userToDelete.setId(1);
        boolean deleted = UserManager.deleteUser(userToDelete);
        if (deleted) {
            System.out.println("Utilisateur supprimé avec succès !");
        } else {
            System.out.println("Échec de la suppression de l'utilisateur.");
        }

        ArrayList<User> allUsers = UserManager.getAllUser();
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("| %-2s | %-10s | %-10s | %-30s | \n", "ID", "Nom", "Prénom", "Email");
        System.out.println("-----------------------------------------------------------------");
        for (User user : allUsers) {
            System.out.printf("| %-2s | %-10s | %-10s | %-30s | \n",
                    user.getId(), user.getNom(), user.getPrenom(), user.getEmail());
        }
        System.out.println("-----------------------------------------------------------------");


    }
}
