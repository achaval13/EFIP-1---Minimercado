package view;

//package de modelo
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Inventario;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Venta;
//package de controller
import controller.ClienteController;
import controller.ProductoController;
import controller.ProveedorController;
import controller.VentaController;
//libreria de java y sql

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.sql.Date;
import database.ConnectionDB;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Calendar;


/*
 * La clase Main maneja la interacción del usuario con el sistema a través de un menú de selección.
 * Permite crear, listar, ver y eliminar ventas, y necesaria interacción con clientes y productos.
 */

public class Menu {
    private static ClienteController clienteController;
    private final ProductoController productoController;
    private static ProveedorController proveedorController;
    private static VentaController ventaController;
    private static Scanner scanner = new Scanner(System.in);
    private final Connection conexion;

    public Menu(Connection conexion) {
        this.conexion = conexion;
        this.productoController = new ProductoController(conexion);
        this.clienteController = new ClienteController(conexion);
        this.proveedorController = new ProveedorController(conexion);
        this.ventaController = new VentaController(conexion);
    }

    public void mostrarMenuPrincipal() {
        int opcion;
        Connection conexion = ConnectionDB.conectarBD();
        
        if (conexion != null) {
            System.out.println("Conectado correctamente.");
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearVenta();
                    break;
                case 2:
                    crearCliente();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    listarCliente();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                case 6:
                    crearProducto();
                    break;
                case 7:
                    buscarProducto();
                    break;
                case 8:
                    listarProducto();
                    break;
                case 9:
                    eliminarProducto();
                    break;
                case 10:
                    crearProveedor();
                    break;
                case 11:
                    buscarProveedor();
                    break;
                case 12:
                    eliminarProveedor();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no valida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
    //funcion para mostrar el menu y seleccionar la funcionalidad a realizar
    public void mostrarMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Crear Venta");
        System.out.println("2. Crear Cliente");
        System.out.println("3. Buscar Cliente");
        System.out.println("4. Listar Cliente");
        System.out.println("5. Eliminar Cliente");
        System.out.println("6. Crear Producto");
        System.out.println("7. Buscar Producto");
        System.out.println("8. Listar Producto");
        System.out.println("9. Eliminar Producto");
        System.out.println("10. Crear Proveedor");
        System.out.println("11. Buscar Proveedor");
        System.out.println("12. Eliminar Proveedor");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    //funcion para crear un cliente y que el usuario ingrese de manera manual los datos necesarios para crear el mismo
    public void crearCliente() {
        System.out.print("Ingrese DNI: ");
        int dni = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese telefono: ");
        int telefono = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese localidad: ");
        String localidad = scanner.nextLine();
        System.out.print("Ingrese direccion: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(0, dni, nombre, apellido, telefono, localidad, direccion);
        clienteController.crearCliente(cliente);
        System.out.println("Cliente creado exitosamente.");
    }
    //funcion para que el usuario ingrese el apellido del cliente y lo busque
    public void buscarCliente() {
        System.out.print("Ingrese apellido del cliente a buscar: ");
        String apellido = scanner.nextLine();
        Cliente cliente = clienteController.buscarCliente(apellido);
        if (cliente != null) {
            System.out.println("ID: " + cliente.getId_cliente() + "Cliente encontrado: " + cliente.getNombre() + " " + cliente.getApellido() + " - DNI:" + cliente.getDni() + " - Localidad: " + cliente.getLocalidad());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    
    public void listarCliente() {
        System.out.println("---------- Listado de Cliente ----------");
        List<Cliente> clientes = clienteController.obtenerTodosLosClientes();
        
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.\n");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println("ID cliente: " + cliente.getId_cliente() +
                        " | DNI: " + cliente.getDni() +
                        " | Nombre: " + cliente.getNombre() +
                        " | Apellido: " + cliente.getApellido() +
                        " | Localidad: " + cliente.getLocalidad() +
                        " | Direccion: " + cliente.getDireccion() +
                        " | Telefono: " + cliente.getTelefono()
                        );
            }
            System.out.println();
        }
    }
    
    //funcion para eliminar un cliente
    public void eliminarCliente() {
        System.out.print("Ingrese apellido del cliente a eliminar: ");
        String apellido = scanner.nextLine();
        Cliente cliente = clienteController.buscarCliente(apellido);
        if (cliente != null) {
            clienteController.elimiararCliente(cliente.getApellido());
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    //funcion para crear un producto y que el usuario ingrese de manera manual los datos necesarios para crear el mismo
    public void crearProducto() {
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese tipo de producto: ");
        String tipoProducto = scanner.nextLine();

        Producto producto = new Producto(0, nombre, precio, tipoProducto);
        productoController.crearProducto(producto);
        System.out.println("Producto creado exitosamente.");
    }
    //funcion para que el usuario ingrese el apellido del cliente y lo busque
    public void buscarProducto() {
        System.out.print("Ingrese nombre del producto a buscar: ");
        String nombre = scanner.nextLine();
        Producto producto = productoController.buscarProducto(nombre);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto.getNombre() + " - Precio: " + producto.getPrecio() + " - Tipo de producto: " + producto.getTipoProducto());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    
    public void listarProducto() {
        System.out.println("---------- Listado de Productos ----------");
        List<Producto> productos = productoController.obtenerTodosLosProductos();
        
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.\n");
        } else {
            for (Producto producto : productos) {
                System.out.println("ID producto: " + producto.getId_producto() +
                        " | Nombre: " + producto.getNombre() +
                        " | Precio: " + producto.getPrecio() +
                        " | Tipo de producto: " + producto.getTipoProducto());
            }
            System.out.println();
        }
    }

    
    //funcion para eliminar un cliente
    public void eliminarProducto() {
        System.out.print("Ingrese nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        Producto producto = productoController.buscarProducto(nombre);
        if (producto != null) {
            productoController.eliminarProducto(producto.getNombre());
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    //funcion para crear un proveedor y que el usuario ingrese de manera manual los datos necesarios para crear el mismo
    public void crearProveedor() {
        System.out.print("Ingrese teléfono del proveedor: ");
        int telefono = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese rubro del proveedor: ");
        String rubro = scanner.nextLine();

        Proveedor proveedor = new Proveedor(telefono, rubro);
        proveedorController.crearProveedor(proveedor);
        System.out.println("Proveedor creado exitosamente.");
    }
    //funcion para que el usuario ingrese el apellido del cliente y lo busque
    public void buscarProveedor() {
        System.out.print("Ingrese el id del proveedor a buscar: ");
        int id = scanner.nextInt();
        Proveedor proveedor = proveedorController.buscarProveedor(id);
        if (proveedor != null) {
            System.out.println("Proveedor encontrado: Rubro: " + proveedor.getRubro() + " - Telefono: " + proveedor.getTelefono() + proveedor.getId());
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }
    //funcion para eliminar un cliente
    public void eliminarProveedor() {
        System.out.print("Ingrese el id del proveedor a eliminar: ");
        int id = scanner.nextInt();
        //Proveedor proveedor = proveedorController.buscarProveedor(id);
        //System.out.println(proveedor.getId() + " - " + proveedor.getRubro());
        proveedorController.eliminarProveedor(id);
        System.out.println("Proveedor eliminado exitosamente.");
    }
    
    //funcion para crear una venta, relacionar la venta con el detalle, el producto seleccionado y el cliente
    public void crearVenta() {
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        System.out.println("----------- Crear Venta -----------");

        //int idGenerado =IDGenerator.generateId();
                
        System.out.println("\nIngrese el apellido del cliente.");
        String nombreCliente = scanner.nextLine();
        Cliente cliente = clienteController.buscarCliente(nombreCliente);
            if (cliente == null) {
                System.out.println("\nCliente no encontrado. Ingrese datos del nuevo cliente.");
            
                System.out.print("Ingrese DNI: ");
                int dni = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese apellido: ");
                String apellido = scanner.nextLine();
                System.out.print("Ingrese telefono: ");
                int telefono = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese localidad: ");
                String localidad = scanner.nextLine();
                System.out.print("Ingrese direccion: ");
                String direccion = scanner.nextLine();

                cliente = new Cliente(0, dni, nombre, apellido, telefono, localidad, direccion);
                clienteController.crearCliente(cliente);
                System.out.println("Cliente creado exitosamente.");
            }

        System.out.println("\nCliente: " + cliente.getNombre() + " " + cliente.getApellido() + " - ID: " + cliente.getId());
        System.out.println("\nFecha: " + currentTime);
        
        Venta ventas = new Venta(0, cliente.getId(), currentTime);
        int id_venta = ventaController.crearVenta(ventas, cliente);
        
        
        double montoTotal = 0;

        while (true) {
            System.out.print("Ingrese nombre del Producto (o 'salir' para finalizar, o 'listar' para ver productos): ");
            String input_producto = scanner.nextLine(); // Cambiado a nextLine para consistencia
            
            if (input_producto.equalsIgnoreCase("salir")) {
                break;
            }

            String nombreProducto;
            try {
                nombreProducto = input_producto;
            } catch (NumberFormatException e) {
                System.out.println("Nombre de producto inválido. Por favor, ingrese otro nombre.\n");
                continue;
            }
            
            Producto producto = productoController.buscarProducto(nombreProducto);
            if (producto == null) {
                System.out.println("Nombre del producto incorrecto. Ingrese un nombre válido.\n");
                continue;
            }

            System.out.println("Ingrese cantidad: ");
            int cantidad =   Integer.parseInt(scanner.nextLine());
            
            ventaController.crearDetalleVenta(ventas, producto, cantidad);
            
            montoTotal += (producto.getPrecio() * cantidad);
        }
        
        ventaController.insertarMontoTotal(id_venta, montoTotal);
        System.out.println("El id de la venta es: " + id_venta + " - El monto total es de: " + montoTotal + "\n");
        System.out.println("Se ha registrado la venta exitosamente.\n");
    }

}