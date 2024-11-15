package Modelo;

public class Producto {
    private int id_producto;
    private String nombre;
    private double precio;
    private String tipoProducto;
    

    public Producto(int id_producto, String nombre, double precio, String tipoProducto) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id) {
        this.id_producto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

}
