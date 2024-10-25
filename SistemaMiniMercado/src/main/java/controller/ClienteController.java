package controller;
import Modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

/*
La clase ClienteController maneja la lógica de negocio relacionada con la entidad Cliente.
 */

public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();

    public void crearCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void elimiararCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public Cliente buscarCliente(String apellido) {
        return clientes.stream()
                .filter(c -> c.getNombre().equals(apellido))
                .findFirst()
                .orElse(null);
    }
    
    public void modificarCliente(int id, int nuevoDni, String nuevoNombre, String nuevoApellido, int nuevoTelefono, String nuevaLocalidad, String nuevaDireccion) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setDni(nuevoDni);
                cliente.setNombre(nuevoNombre);
                cliente.setApellido(nuevoApellido);
                cliente.setTelefono(nuevoTelefono);
                cliente.setLocalidad(nuevaLocalidad);
                cliente.setDireccion(nuevaDireccion);
                break; // Salimos del bucle una vez que encontramos y modificamos el cliente
            }
        }
    }
}