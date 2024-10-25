package Modelo;

public class DetalleVenta {
    private int id_detalleVenta;
    private int cantidad;
    private int id_producto;
    private String formaPago;

    public DetalleVenta() {
    }

    public DetalleVenta(int id_detalleVenta, int cantidad, int id_producto, String formaPago) {
        this.id_detalleVenta = id_detalleVenta;
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
    
    public double calcularTotal() {
        // Aquí se debe buscar el producto por id_producto y obtener su precio
        // Suponiendo que tenemos acceso a un método que obtiene el producto
        Producto producto = obtenerProductoPorId(id_producto);
        return this.cantidad * producto.getPrecio();
    }

    private Producto obtenerProductoPorId(int id_producto) {
        // Implementar la lógica para obtener el producto por su ID
        return new Producto("Nombre", 10.0, "Tipo"); // Ejemplo
    }
}
