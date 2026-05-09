package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    public static Connection getConexion() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/showpass",
                "root",
                "3127"
            );

            System.out.println("CONEXIÓN EXITOSA ✔");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error conexión: " + e.getMessage());
        }

        return con;
    }
}