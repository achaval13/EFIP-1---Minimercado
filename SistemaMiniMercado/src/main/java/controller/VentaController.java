package controller;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.Venta;
import dao.IVentaDAO;
import dao.ventaDAO;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

/*
La clase VentaController maneja la lógica de negocio relacionada con la entidad Venta.
 */

public class VentaController {
    private IVentaDAO ventaDAO;

    public VentaController(Connection conexion) {
        this.ventaDAO = new ventaDAO(conexion);
    }

    public int crearVenta(Venta venta, Cliente cliente) {
        return ventaDAO.crearVenta(venta, cliente);
    }
    
    public void crearDetalleVenta(Venta venta, Producto producto, int cantidad) {
        ventaDAO.crearDetalleVenta(venta, producto, cantidad);
    }

    public Venta buscarVenta(String fecha) {
        return ventaDAO.buscarVenta(fecha);
    }
    
    public void insertarMontoTotal(int id_venta, double montoTotal){
        ventaDAO.insertarMontoTotal(id_venta, montoTotal);
    }
    
}