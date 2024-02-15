import com.addresse.model.DbConnexion;
import com.addresse.model.User;
import com.addresse.model.UserManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FormUser exemple = new FormUser(null);
        DbConnexion.getConnexion();


//
//        //Update un utilisateur
//        User update = new User("Update2","update2","test@test.com","123456");
//        //version avec boolean en sortie
//        if(UserManager.updateUser(update).getEmail() != null){
//            System.out.println("le compte "+ UserManager.updateUser(update).getEmail() +" a été mis à jour en BDD");
//        }
//        else{
//            System.out.println("Le compte n'existe pas");
//        }
//
        //Supprimer un utilisateur par son ID
//        User userToDelete = new User();
//        userToDelete.setId(1);
//        boolean deleted = UserManager.deleteUserById(userToDelete);
//        if (deleted) {
//            System.out.println("Utilisateur supprimé avec succès !");
//        } else {
//            System.out.println("Échec de la suppression de l'utilisateur.");
//        }
        //Supprimer tous les utilisateurs par leur IDs
        // Récupérer tous les utilisateurs
//        ArrayList<User> allUsers = UserManager.getAllUser();

//        // Supprimer tous les utilisateurs
//        for (User user : allUsers) {
//            boolean deleted = UserManager.deleteUserById(user);
//            if (deleted) {
//                System.out.println("Utilisateur avec l'ID " + user.getId() + " supprimé avec succès !");
//            } else {
//                System.out.println("Échec de la suppression de l'utilisateur avec l'ID " + user.getId() + ".");
//            }
//        }

//        //Afficher la liste des utilisateurs
//        System.out.println("-----------------------------------------------------------------");
//        System.out.printf("| %-2s | %-10s | %-10s | %-30s | \n", "ID", "Nom", "Prénom", "Email");
//        System.out.println("-----------------------------------------------------------------");
//        for (User user : allUsers) {
//            System.out.printf("| %-2s | %-10s | %-10s | %-30s | \n",
//                    user.getId(), user.getNom(), user.getPrenom(), user.getEmail());
//        }
//        System.out.println("-----------------------------------------------------------------");
    }
}
