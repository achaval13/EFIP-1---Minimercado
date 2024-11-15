package controller;
import Modelo.Proveedor;
import dao.IProveedorDAO;
import dao.proveedorDAO;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

/*
La clase ProveedorController maneja la lógica de negocio relacionada con la entidad Proveedor.
 */

public class ProveedorController {
    private IProveedorDAO proveedorDAO;
    
    public ProveedorController (Connection conexion) {
        this.proveedorDAO = new proveedorDAO(conexion);
    }
    private List<Proveedor> proveedores = new ArrayList<>();

    public void crearProveedor(Proveedor proveedor) {
        proveedorDAO.crearProveedor(proveedor);
    }
    
    public void eliminarProveedor(int id) {
        proveedorDAO.eliminarProveedor(id);
    }

    public Proveedor buscarProveedor(int id) {
        return proveedorDAO.buscarProveedor(id);
    }
    
    public void modificarProveedor(int id, int nuevoTelefono, String nuevoRubro) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId() == id) {
                proveedor.setTelefono(nuevoTelefono);
                proveedor.setRubro(nuevoRubro);
                break; // Salimos del bucle una vez que encontramos y modificamos el proveedor
            }
        }
    }
    
}