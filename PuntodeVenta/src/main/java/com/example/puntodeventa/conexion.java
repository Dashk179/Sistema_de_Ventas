package com.example.puntodeventa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName="bd_sistema_ventas";
        String databaseUser="root";
        String databasePassoword = "root";
        String url ="jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassoword);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return databaseLink;
    }
}
