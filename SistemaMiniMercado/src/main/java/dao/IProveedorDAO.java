package dao;

import Modelo.Proveedor;
 /*
 La interfaz IproveedorDAO define los métodos para realizar operaciones CRUD en la entidad proveedor.
 Esta interfaz proporciona una abstracción para la gestión de clientes en el sistema.
 */

public interface IProveedorDAO {
    Proveedor buscarProveedor(int id);
    void crearProveedor(Proveedor proveedor);
    void eliminarProveedor(int id);
}

