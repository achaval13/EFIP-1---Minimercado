package Modelo;

public class DetalleVenta {
    private int id_detalleVenta;
    private int cantidad;
    private int id_producto;
    private String formaPago;
    private int id_venta;


    public DetalleVenta(int id_detalleVenta, int id_venta, int cantidad, int id_producto, String formaPago) {
        this.id_detalleVenta = id_detalleVenta;
        this.id_venta = id_venta;
        this.cantidad = cantidad;
        this.id_producto = id_producto;
        this.formaPago = formaPago;
    }

    public int getId() {
        return id_detalleVenta;
    }

    public void setId(int id) {
        this.id_detalleVenta = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getProducto() {
        return id_producto;
    }

    public void setProducto(int producto) {
        this.id_producto = producto;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
    
}
