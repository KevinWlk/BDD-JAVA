import com.addresse.model.*;

public class Main {
    public static void main(String[] args) {
        DbConnexion.getConnexion();
        User test = new User("Walencik", "Kevin", "test@test.com","1234");
        UserManager userManager = new UserManager();
        userManager.addUser(test);
    }
}