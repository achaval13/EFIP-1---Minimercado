package Modelo;

public class Proveedor {
    private int id;
    private int telefono;
    private String rubro;

    public Proveedor() {
    }

    public Proveedor(int telefono, String rubro) {
        this.telefono = telefono;
        this.rubro = rubro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
