package controller;
import Modelo.Producto;
import dao.IProductoDAO;
import dao.productoDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/*
La clase ProductoController maneja la lógica de negocio relacionada con la entidad Prodcuto.
 */

public class ProductoController {
    private IProductoDAO productoDAO;
    
    public ProductoController (Connection conexion) {
        this.productoDAO = new productoDAO(conexion);
    }
    
    public List<Producto> obtenerTodosLosProductos() {
        return productoDAO.obtenerTodosLosProductos();
    }

    public void crearProducto(Producto producto) {
        productoDAO.crearProducto(producto);
    }
    
    public void eliminarProducto(String nombre) {
        productoDAO.eliminarProducto(nombre);
    }

    public Producto buscarProducto(String nombre) {
        return productoDAO.buscarProducto(nombre); 
    }

}
