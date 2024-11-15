package Modelo;

public class Venta {
    private int id_venta;
    private String fecha;
    private double montoTotal;
    private int id_cliente;

    public Venta(int id_venta, int id_cliente, String fecha) {
        this.id_cliente = id_cliente;
        this.fecha = fecha;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id) {
        this.id_venta = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
