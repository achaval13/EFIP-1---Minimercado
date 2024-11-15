package dao;
import Modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
La clase ClienteDAO implementa la interfaz IClienteDAO
proporciona la implementación de los métodos para realizar operaciones CRUD en la entidad Cliente.
Aunque la gestión de clientes excede el alcance central del aplicativo, se consideró necesario
incluirla para una funcionalidad básica.
 */

public class clienteDAO implements IClienteDAO {
    private Connection conexion;

    public clienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public Cliente buscarCliente(String apellido) {
        String query = "SELECT * FROM Cliente WHERE apellido = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, apellido);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getInt("id_cliente"),
                            rs.getInt("dni"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getInt("telefono"),
                            rs.getString("localidad"),
                            rs.getString("direccion")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // inserta un nuevo cliente en la base de datos.

    public void crearCliente(Cliente cliente) {
        String query = "INSERT INTO Cliente (dni, nombre, apellido, telefono, localidad, direccion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, cliente.getDni());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setInt(4, cliente.getTelefono());
            stmt.setString(5, cliente.getLocalidad());
            stmt.setString(6, cliente.getDireccion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente(String apellido) {
        String query = "DELETE FROM Cliente WHERE apellido = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, apellido);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Indicar error
        }
    }
    
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String localidad = rs.getString("localidad");
                String direccion = rs.getString("direccion");
                int dni = rs.getInt("dni");
                int telefono = rs.getInt("telefono");
                Cliente cliente = new Cliente(id_cliente, dni, nombre, apellido, telefono, localidad, direccion);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}