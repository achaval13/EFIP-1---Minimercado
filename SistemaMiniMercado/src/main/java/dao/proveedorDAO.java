package dao;
import Modelo.Proveedor;
import java.sql.*;

/*
La clase proveedorDAO implementa la interfaz IProveedorDAO
proporciona la implementación de los métodos para realizar operaciones CRUD en la entidad Proveedor.
Aunque la gestión de clientes excede el alcance central del aplicativo, se consideró necesario
incluirla para una funcionalidad básica.
 */

public class proveedorDAO implements IProveedorDAO {
    private Connection conexion;

    public proveedorDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public Proveedor buscarProveedor(int id) {
        String query = "SELECT * FROM Proveedor WHERE id_proveedor = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Proveedor(
                            rs.getInt("telefono"),
                            rs.getString("rubro")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // inserta un nuevo cliente en la base de datos.

    public void crearProveedor(Proveedor proveedor) {
        String query = "INSERT INTO Proveedor (telefono, rubro) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, proveedor.getTelefono());
            stmt.setString(2, proveedor.getRubro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProveedor(int id) {
        String query = "DELETE FROM Proveedor WHERE id_proveedor = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Indicar error
        }
    }

}