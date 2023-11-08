package com.cristian.TresEnRaya.infrastructure.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    private DBConnection(){}

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://database-1.czxapucafvwz.us-east-1.rds.amazonaws.com/tresEnRaya",
                        "admin", "potolo123");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

}