package Modelo;
import java.sql.Date;
import java.util.stream.Stream;

public class Venta {
    private int id_venta;
    private int id_detalleVenta;
    private Date fecha;
    private double montoTotal;
    private int id_cliente;

    public Venta(int id_cliente, int id_detalleVenta, Date fecha) {
        this.id_cliente = id_cliente;
        this.id_detalleVenta = id_detalleVenta;
        this.fecha = fecha;
    }

    public int getId() {
        return id_venta;
    }

    public void setId(int id) {
        this.id_venta = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getId_detalleVenta() {
        return id_detalleVenta;
    }

    public void setId_detalleVenta(int id_detalleVenta) {
        this.id_detalleVenta = id_detalleVenta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
