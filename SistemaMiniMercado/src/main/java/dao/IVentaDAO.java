package dao;

import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Venta;

import java.util.List;

/*
La interfaz IVentaDAO define los métodos para realizar operaciones CRUD en la entidad Venta.
Esta interfaz proporciona una abstracción para la gestión de ventas en el sistema.
*/

public interface IVentaDAO {
    int crearVenta(Venta venta, Cliente cliente);
    void crearDetalleVenta(Venta venta, Producto producto, int cantidad);
    void insertarMontoTotal(int id_venta, double montoTotal);
    Venta buscarVenta(String fecha);
}