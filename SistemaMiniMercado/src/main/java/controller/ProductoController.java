package controller;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/*
La clase ProductoController maneja la lógica de negocio relacionada con la entidad Prodcuto.
 */

public class ProductoController {
    private List<Producto> productos = new ArrayList<>();

    public void crearProducto(Producto producto) {
        productos.add(producto);
    }
    
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public Producto buscarProducto(String nombre) {
        return productos.stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public void modificarProducto(int id, String nuevoNombre, double nuevoPrecio, String nuevoTipoProducto) {
    for (Producto producto : productos) {
        if (producto.getId() == id) {
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            producto.setTipoProducto(nuevoTipoProducto);
            break; // Salimos del bucle una vez que encontramos y modificamos el producto
        }
    }
}
}