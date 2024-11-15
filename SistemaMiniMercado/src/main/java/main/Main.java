package main;

import view.Menu;
import database.ConnectionDB;
import java.sql.Connection;

/*
Punto de entrada de la aplicación
establece la conexión a la base de datos
y ejecuta el menu principal de la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        Connection conexion = ConnectionDB.conectarBD();
        if (conexion != null) {
            Menu menu = new Menu(conexion);
            menu.mostrarMenuPrincipal();
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }
    }
}