package dao;

import Modelo.Cliente;
import Modelo.Venta;
import Modelo.DetalleVenta;
import Modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/*
La clase ventaDAO implementa la interfaz IVentaDAO
proporciona la implementación de los métodos para realizar el CRUD en la entidad venta.
recibe una conexión a la base de datos y es responsable de gestionar la persistencia de las ventas.
 */

public class ventaDAO implements IVentaDAO {
    private Connection conexion;

    public ventaDAO(Connection conexion) {
        this.conexion = conexion;
    }
    
    public void crearDetalleVenta(Venta venta, Producto producto, int cantidad) {
        String queryDetalleVenta = "INSERT INTO detalleVenta (cantidad, id_venta, id_producto) VALUES (?, ?, ?)";

        try {
            // Iniciar una transacción
            conexion.setAutoCommit(false);
            // Insertar el detalle del Venta
                
            try (PreparedStatement stmtDetalleVenta = conexion.prepareStatement(queryDetalleVenta, Statement.RETURN_GENERATED_KEYS)) {
                stmtDetalleVenta.setInt(1, cantidad);
                stmtDetalleVenta.setInt(2, venta.getId_venta());
                stmtDetalleVenta.setInt(3, producto.getId_producto());
                stmtDetalleVenta.executeUpdate();
            }

            // Confirmar la transacción
            conexion.commit();
        } catch (SQLException e) {
            try {
                // Revertir la transacción en caso de error
                conexion.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conexion.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int crearVenta(Venta venta, Cliente cliente) {
        String queryVenta = "INSERT INTO Venta (id_cliente, fecha) VALUES (?, ?)";

        try {
            // Iniciar una transacción
            conexion.setAutoCommit(false);

            // Insertar el Venta
            try (PreparedStatement stmtVenta = conexion.prepareStatement(queryVenta, Statement.RETURN_GENERATED_KEYS)) {
                stmtVenta.setInt(1, cliente.getId());
                stmtVenta.setString(2, venta.getFecha());
                
                stmtVenta.executeUpdate();
                
                try (ResultSet generatedKeys = stmtVenta.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Devolver el ID generado
                } else {
                    throw new SQLException("No se pudo obtener el ID generado.");
                }
            }

            }
            // Confirmar la transacción
            //conexion.commit();
            
            
        } catch (SQLException e) {
            try {
                // Revertir la transacción en caso de error
                conexion.rollback();
                return -1;
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        }
        return -1;
    }
    
    
    public Venta buscarVenta(String fecha) {
        String queryBuscarVenta = "SELECT * FROM venta WHERE fecha = ?";
     
        try (PreparedStatement stmtVenta = conexion.prepareStatement(queryBuscarVenta)) {
                stmtVenta.setString(1, fecha);
                try (ResultSet rs = stmtVenta.executeQuery()) {
                if (rs.next()) {
                    return new Venta(
                            rs.getInt("id_venta"),
                            rs.getInt("id_cliente"),
                            rs.getString("fecha")
                    );
                }
                }
                conexion.commit();
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }

    public void insertarMontoTotal(int id_venta, double montoTotal) {
        String queryInsertarMonto = "UPDATE venta SET monto_total = ? WHERE id_venta = ?";
        
        try (PreparedStatement stmtInsertMonto = conexion.prepareStatement(queryInsertarMonto)) {
                stmtInsertMonto.setDouble(1, montoTotal);
                stmtInsertMonto.setInt(2, id_venta);
                
                stmtInsertMonto.executeUpdate();
            } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}