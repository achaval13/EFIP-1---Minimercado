package controller;
import Modelo.DetalleVenta;
import Modelo.Venta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
La clase VentaController maneja la lógica de negocio relacionada con la entidad Venta.
 */

public class VentaController {
    private List<Venta> ventas = new ArrayList<>();
    private List<DetalleVenta> detalleVentas = new ArrayList<>();

    public void crearVenta(Venta venta) {
        ventas.add(venta);
    }

    public Venta buscarVenta(Date fecha) {
        return ventas.stream()
                .filter(c -> c.getFecha().equals(fecha))
                .findFirst()
                .orElse(null);
    }
    
    public void agregarProducto(DetalleVenta detalleVenta){
        detalleVentas.add(detalleVenta);
    }
    
}