package controller;
import Modelo.Inventario;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

/*
La clase InventarioController maneja la lógica de negocio relacionada con la entidad Inventario.
 */

public class InventarioController {
    private List<Inventario> inventarios = new ArrayList<>();

    public void crearInventario(Inventario inventario) {
        inventarios.add(inventario);
    }

    public List<Inventario> consultarInventario() {
        return inventarios;
    }

    public void modificarInventario(int id, int cantidad, Date fechaIngreso, Date fechaVencimiento) {
        for (Inventario inv : inventarios) {
            if (inv.getId() == id) {
                inv.setCantidad(cantidad);
                inv.setFechaIngreso(fechaIngreso);
                inv.setFechaVencimiento(fechaVencimiento);
                break;
            }
        }
    }
}