package Modelo;

public class Proveedor {
    private int id_proveedor;
    private int telefono;
    private String rubro;

    public Proveedor(int telefono, String rubro) {
        this.telefono = telefono;
        this.rubro = rubro;
    }

    public int getId() {
        return id_proveedor;
    }

    public void setId(int id) {
        this.id_proveedor = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }
}
