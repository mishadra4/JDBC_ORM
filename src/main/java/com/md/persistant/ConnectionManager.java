package com.md.persistant;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/sample?serverTimeZone=UTC&useSSL=false";
    private static final String username = "root";
    private static final String password = "root";

    private static Connection connection = null;

    private ConnectionManager (){}

    private static Connection getConnection(){
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
