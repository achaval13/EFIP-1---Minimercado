package controller;
import Modelo.Cliente;
import dao.IClienteDAO;
import dao.clienteDAO;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

/*
La clase ClienteController maneja la lógica de negocio relacionada con la entidad Cliente.
 */

public class ClienteController {
    
    private IClienteDAO clienteDAO;
    
    public ClienteController (Connection conexion) {
        this.clienteDAO = new clienteDAO(conexion);
    }
    
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDAO.obtenerTodosLosClientes();
    }

    public void crearCliente(Cliente cliente) {
        clienteDAO.crearCliente(cliente);
    }
    
    public void elimiararCliente(String apellido) {
        clienteDAO.eliminarCliente(apellido);
    }

    public Cliente buscarCliente(String apellido) {
        return clienteDAO.buscarCliente(apellido);
    }
    
  
}