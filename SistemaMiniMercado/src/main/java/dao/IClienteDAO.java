package dao;

import Modelo.Cliente;
import java.util.List;
 /*
 La interfaz IClienteDAO define los métodos para realizar operaciones CRUD en la entidad Cliente.
 Esta interfaz proporciona una abstracción para la gestión de clientes en el sistema.
 */

public interface IClienteDAO {
    Cliente buscarCliente(String apellido);
    void crearCliente(Cliente cliente);
    void eliminarCliente(String apellido);
    List<Cliente> obtenerTodosLosClientes();
}

