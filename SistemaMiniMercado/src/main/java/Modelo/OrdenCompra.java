package Modelo;

import java.sql.Date;

public class OrdenCompra {
    private int id;
    private Date fecha;
    private int cantidad;
    private double montoTotal;
    private Proveedor proveedor;
    private Producto producto;

    public OrdenCompra() {
    }

    public OrdenCompra(int id, Date fecha, int cantidad, double montoTotal, Proveedor proveedor, Producto producto) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
        this.proveedor = proveedor;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public double calcularTotal() {
        return this.cantidad * this.producto.getPrecio();
    }
}
