package controller;
import Modelo.Proveedor;

import java.util.ArrayList;
import java.util.List;

/*
La clase ProveedorController maneja la lógica de negocio relacionada con la entidad Proveedor.
 */

public class ProveedorController {
    private List<Proveedor> proveedores = new ArrayList<>();

    public void crearProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }
    
    public void eliminarProveedor(Proveedor proveedor) {
        proveedores.remove(proveedor);
    }

    public Proveedor buscarProveedor(String rubro) {
        return proveedores.stream()
                .filter(p -> p.getRubro().equals(rubro))
                .findFirst()
                .orElse(null);
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