import com.addresse.model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        DbConnexion.getConnexion();

        ArrayList<User> allUsers = UserManager.getAllUser();

        System.out.println("---------------------------------------------------------");
        System.out.printf("%-4s %-10s %-10s %-30s\n", "ID", "Nom", "Prénom", "Email");
        System.out.println("---------------------------------------------------------");
        for (User user : allUsers) {
            System.out.printf("%-4d %-10s %-10s %-30s\n",
                    user.getId(), user.getNom(), user.getPrenom(), user.getEmail());
        }
        System.out.println("---------------------------------------------------------");
    }
}