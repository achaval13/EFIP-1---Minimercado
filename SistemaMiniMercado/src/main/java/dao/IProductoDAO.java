package dao;
import Modelo.Producto;
import java.util.List;


/*
La interfaz IProductoDAO define los métodos para realizar operaciones CRUD en la entidad Producto.
Esta interfaz proporciona una abstracción para la gestión de productos en el sistema.
*/

public interface IProductoDAO {
    Producto buscarProducto(String nombre);
    void crearProducto(Producto producto);
    void eliminarProducto(String nombre);
    List<Producto> obtenerTodosLosProductos();
}