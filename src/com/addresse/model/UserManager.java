package com.addresse.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UserManager {
    private static Connection connexion;
    public UserManager(){
        //assigner la connexion à la BDD.
        connexion = DbConnexion.getConnexion();
    }
    public User addUser(User user) {
        //instancier un Objet User
        User userAdd = new User();
        try{
            //Connection à la BDD...
            Statement stmt = connexion.createStatement();
            //requête SQL
            String sql = "INSERT INTO users (nom, prenom, email, password) VALUES (?, ?, ?, ?)";
            //Préparation de la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);
            //Bind des paramètres
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            //Exécution de la requête
            int addedRows = preparedStatement.executeUpdate();
            //test si l'enregistrement est ok
            if (addedRows > 0) {
                //Création d'un Objet User
                userAdd = new User();
                userAdd.setNom(user.getNom());
                userAdd.setPrenom(user.getPrenom());
                userAdd.setEmail(user.getEmail());
                userAdd.setPassword(user.getPassword());
            }
            //fermeture de la connexion BDD
            stmt.close();
            connexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //Retourne un Objet User
        return userAdd;
    }
    public User updateUser(User user) {
        User updatedUser = new User();
        try {
            // Connexion à la base de données
            connexion = DbConnexion.getConnexion();

            // Requête SQL pour mettre à jour l'utilisateur
            String sql = "UPDATE users SET nom=?, prenom=?, email=?, password=? WHERE id=?";

            // Préparation de la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);

            // Bind des paramètres
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getId()); // Supposons que getId() retourne l'identifiant de l'utilisateur à mettre à jour

            // Exécution de la requête
            int updatedRows = preparedStatement.executeUpdate();

            // Vérification si la mise à jour a réussi
            if (updatedRows > 0) {
                // Mise à jour réussie, mettez à jour l'objet User avec les nouvelles valeurs
                updatedUser = user;
            }

            // Fermeture des ressources
            preparedStatement.close();
            connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updatedUser;
    }

}
