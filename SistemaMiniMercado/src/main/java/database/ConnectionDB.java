package database;

import java.sql.*;

public class ConnectionDB {

    // Constantes para la conexión
    private static final String HOST = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "1323";
    private static final String BD = "minimercadodb";

    public static Connection conectarBD() {
        Connection conexion;
        System.out.println("Conectando...");

        try {
            // establece conexión.
            conexion = DriverManager.getConnection(HOST + BD, USER, PASS);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return conexion;
    }
}