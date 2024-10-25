package Modelo;
import java.sql.Date;

public class OrdenCompra {
    private int id;
    private Date fecha;
    private int cantidad;
    private double montoTotal;

    public OrdenCompra(int id, Date fecha, int cantidad, double montoTotal) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
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
}
