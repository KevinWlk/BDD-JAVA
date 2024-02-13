package com.addresse.model;

import java.sql.*;
public class DbConnexion {
    //Attribut paramètre BDD
    static final String DB_URL = "jdbc:mysql://srv511.hstgr.io/u444410201_java?serverTimezone=UTC";
    static final String USERNAME = "u444410201_java";
    static final String PASSWORD = "RD1&KsLp4xE1";
    //Connexion à la BDD
    private static Connection connexion;
    static {
        try {
            connexion = DriverManager.getConnection(DB_URL, USERNAME,
                    PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnexion(){
        return connexion;
    }
}