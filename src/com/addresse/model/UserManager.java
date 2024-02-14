package com.addresse.model;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class UserManager {
    private static Connection connexion = DbConnexion.getConnexion();

    //Méthode pour ajouter un utilisateur
    public static User addUser(User user) {
        User useradd = new User();
        try {
            //connexion
            Statement smt = connexion.createStatement();
            //requête
            String req = "INSERT INTO users(nom,prenom,email,password) VALUE (?,?,?,?)";
            //préparer la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(req);
            //binder les 4 paramètres
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            //exécution de la requête
            int addedRows = preparedStatement.executeUpdate();
            //tester si la requête est bien passé
            if (addedRows > 0) {
                //injecter les valeurs dans l'objet de sortie
                useradd.setNom(user.getNom());
                useradd.setPrenom(user.getPrenom());
                useradd.setEmail(user.getEmail());
                useradd.setPassword(user.getPassword());
            }
            smt.close();
            connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return useradd;
    }
    public static User findUser(User user){
        User verif = new User();
        try{
            //connexion
            Statement smt = connexion.createStatement();
            //requête
            String req = "SELECT id, nom, prenom,email, password FROM users WHERE email = ?";
            //préparer la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(req);
            //bind paramètre email
            preparedStatement.setString(1, user.getEmail());
            //résultat de la requête
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs);
            //boucler sur le résultat
            while (rs.next()){
                //test si la colonne id  posséde  une valeur
                if(rs.getString(1) !=null){
                    verif.setId(rs.getInt(1));
                    verif.setNom(rs.getString("nom"));
                    verif.setPrenom(rs.getString("prenom"));
                    verif.setEmail(rs.getString("email"));
                    verif.setPassword(rs.getString("password"));
                }
            }
            smt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return verif;
    }
    public static User updateUser(User user){
        User updateUser = new User();
        try{
            Statement smt = connexion.createStatement();
            String req = "UPDATE users SET nom = ?, prenom = ? WHERE email = ?";
            PreparedStatement preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getEmail());
            int nbrLigne = preparedStatement.executeUpdate();
            if(nbrLigne == 1) {
                updateUser.setNom(user.getNom());
                updateUser.setPrenom(user.getPrenom());
                updateUser.setEmail(user.getEmail());
                updateUser.setPassword(user.getPassword());
            }
            smt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return updateUser;
    }
    public static ArrayList<User> getAllUser() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            Statement smt = connexion.createStatement();
            String req = "SELECT id, nom, prenom, email, password FROM users";
            ResultSet rs = smt.executeQuery(req);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
            smt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
    public static boolean deleteUserById(User user) {
        boolean success = false;
        try {
            String req = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setInt(1, user.getId());
            int deletedRows = preparedStatement.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("L'utilisateur avec l'ID " + user.getId() + " a été supprimé avec succès.");
                success = true;
            } else {
                System.out.println("Impossible de trouver l'utilisateur avec l'ID " + user.getId() + ".");
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}

