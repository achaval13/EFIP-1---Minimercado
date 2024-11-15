package dao;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/*
La clase ProductoDAO implementa la interfaz IProductoDAO
y proporciona los métodos para realizar operaciones CRUD en la entidad Producto.
Aunque la gestión de productos no es el foco central del proyecto, se incluyó para complementar
las funcionalidades del sistema.
*/

public class productoDAO implements IProductoDAO {
    private Connection conexion;

    public productoDAO (Connection conexion) {
        this.conexion = conexion;
    }

    public Producto buscarProducto(String nombre) {
        String query = "SELECT * FROM producto WHERE nombre = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getString("tipo_producto")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // inserta un nuevo producto en la base de datos.
    public void crearProducto(Producto producto) {
        String query = "INSERT INTO Producto (nombre, tipo_producto, precio) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getTipoProducto());
            stmt.setDouble(3, producto.getPrecio());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Indicar error
        }
    }
    
    // inserta un nuevo producto en la base de datos.
    public void eliminarProducto(String nombre) {
        String query = "DELETE FROM Producto WHERE nombre = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Indicar error
        }
    }


    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM Producto";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id_producto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String tipoProducto = rs.getString("tipo_producto");
                Producto producto = new Producto(id_producto, nombre, precio, tipoProducto);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

}