//package de modelo
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Inventario;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Venta;
//package de controller
import controller.ClienteController;
import controller.InventarioController;
import controller.ProductoController;
import controller.ProveedorController;
import controller.VentaController;
//libreria de java y sql
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * La clase Main maneja la interacción del usuario con el sistema a través de un menú de selección.
 * Permite crear, listar, ver y eliminar ventas, y necesaria interacción con clientes y productos.
 */

public class Main {
    private static ClienteController clienteController = new ClienteController();
    private static ProductoController productoController = new ProductoController();
    private static ProveedorController proveedorController = new ProveedorController();
    private static VentaController ventaController = new VentaController();
    private static InventarioController inventarioController = new InventarioController();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int opcion;
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
                    eliminarCliente();
                    break;
                case 5:
                    crearProducto();
                    break;
                case 6:
                    buscarProducto();
                    break;
                case 7:
                    eliminarProducto();
                    break;
                case 8:
                    crearProveedor();
                    break;
                case 9:
                    buscarProveedor();
                    break;
                case 10:
                    eliminarProveedor();
                    break;
                case 11:
                    crearInventario();
                    break;
                case 12:
                    consultarInventario();
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
    private static void mostrarMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Crear Venta");
        System.out.println("2. Crear Cliente");
        System.out.println("3. Buscar Cliente");
        System.out.println("4. Eliminar Cliente");
        System.out.println("5. Crear Producto");
        System.out.println("6. Buscar Producto");
        System.out.println("7. Eliminar Producto");
        System.out.println("8. Crear Proveedor");
        System.out.println("9. Buscar Proveedor");
        System.out.println("10. Eliminar Proveedor");
        System.out.println("11. Crear Inventario");
        System.out.println("12. Consultar Inventario");
        System.out.println("13. Eliminar Inventario");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    //funcion para crear un cliente y que el usuario ingrese de manera manual los datos necesarios para crear el mismo
    private static void crearCliente() {
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

        Cliente cliente = new Cliente(dni, nombre, apellido, telefono, localidad, direccion);
        clienteController.crearCliente(cliente);
        System.out.println("Cliente creado exitosamente.");
    }
    //funcion para que el usuario ingrese el apellido del cliente y lo busque
    private static void buscarCliente() {
        System.out.print("Ingrese apellido del cliente a buscar: ");
        String apellido = scanner.nextLine();
        Cliente cliente = clienteController.buscarCliente(apellido);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNombre() + " " + cliente.getApellido());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    //funcion para eliminar un cliente
    private static void eliminarCliente() {
        System.out.print("Ingrese apellido del cliente a eliminar: ");
        String apellido = scanner.nextLine();
        Cliente cliente = clienteController.buscarCliente(apellido);
        if (cliente != null) {
            clienteController.elimiararCliente(cliente);
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    //funcion para crear un producto y que el usuario ingrese de manera manual los datos necesarios para crear el mismo
    private static void crearProducto() {
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese tipo de producto: ");
        String tipoProducto = scanner.nextLine();

        Producto producto = new Producto(nombre, precio, tipoProducto);
        productoController.crearProducto(producto);
        System.out.println("Producto creado exitosamente.");
    }
    //funcion para que el usuario ingrese el apellido del cliente y lo busque
    private static void buscarProducto() {
        System.out.print("Ingrese nombre del producto a buscar: ");
        String nombre = scanner.nextLine();
        Producto producto = productoController.buscarProducto(nombre);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto.getNombre() + " - Precio: " + producto.getPrecio());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    //funcion para eliminar un cliente
    private static void eliminarProducto() {
        System.out.print("Ingrese nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        Producto producto = productoController.buscarProducto(nombre);
        if (producto != null) {
            productoController.eliminarProducto(producto);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    //funcion para crear un proveedor y que el usuario ingrese de manera manual los datos necesarios para crear el mismo
    private static void crearProveedor() {
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
    private static void buscarProveedor() {
        System.out.print("Ingrese rubro del proveedor a buscar: ");
        String rubro = scanner.nextLine();
        Proveedor proveedor = proveedorController.buscarProveedor(rubro);
        if (proveedor != null) {
            System.out.println("Proveedor encontrado: Rubro - " + proveedor.getRubro());
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }
    //funcion para eliminar un cliente
    private static void eliminarProveedor() {
        System.out.print("Ingrese rubro del proveedor a eliminar: ");
        String rubro = scanner.nextLine();
        Proveedor proveedor = proveedorController.buscarProveedor(rubro);
        if (proveedor != null) {
            proveedorController.eliminarProveedor(proveedor);
            System.out.println("Proveedor eliminado exitosamente.");
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }
    
    //funcion para crear una venta, relacionar la venta con el detalle, el producto seleccionado y el cliente
    public static void crearVenta() {
        
        System.out.println("----------- Crear Venta -----------");

        int idGenerado =IDGenerator.generateId();
                
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

                cliente = new Cliente(dni, nombre, apellido, telefono, localidad, direccion);
                clienteController.crearCliente(cliente);
                System.out.println("Cliente creado exitosamente.");
            }

        System.out.println("\nCliente: " + cliente.getNombre() + " " + cliente.getApellido());

        List<DetalleVenta> detalleVentas = new ArrayList<>();
        while (true) {
            System.out.print("Ingrese nombre del Producto (o 'salir' para finalizar, o 'listar' para ver productos): ");
            String input = scanner.nextLine(); // Cambiado a nextLine para consistencia
            if (input.equalsIgnoreCase("salir")) {
                break;
            } else if (input.equalsIgnoreCase("listar")) {
                //Utils.mostrarListaProductos();
                continue;
            }

            String nombreProducto;
            try {
                nombreProducto = input;
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


            detalleVentas.add(new DetalleVenta(idGenerado, cantidad, producto.getId(), "Efectivo", producto));
        }

        if (detalleVentas.isEmpty()) {
            System.out.println("No se puede crear una venta sin productos. Venta cancelada.\n");
            return;
        } else {
            Venta ventas = new Venta(cliente.getId(), idGenerado, Date.valueOf(LocalDate.MAX), cliente);
            ventas.setMontoTotal(detalleVentas.stream().map(dv -> dv.calcularTotal()));
            
            ventaController.crearVenta(ventas);
        }
    }
    //Generador de id para relacionar la venta y el detalle de venta
    public class IDGenerator {
        private static int currentId = 0;

        public static int generateId() {
            return ++currentId;
        }
    }
    //funcion para crear un inventario y que el usuario ingrese de manera manual los datos necesarios para crear el mismo
    private static void crearInventario() {
        System.out.print("Ingrese nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        Producto producto = productoController.buscarProducto(nombreProducto);
        System.out.print("Ingrese la cantidad del producto ingresado: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la fecha de vencimiento del producto: (con el siguiente formato AAAA-MM-DD)");
        String strFechaVencimiento = scanner.nextLine();
        Date fecVencimiento = Date.valueOf(strFechaVencimiento);

        Inventario inventario = new Inventario(cantidad, Date.valueOf(LocalDate.MAX), fecVencimiento, producto);
        inventarioController.crearInventario(inventario);
        System.out.println("Inventario creado exitosamente.");
    }
    //ver la lista de productos en el inventario
    private static void consultarInventario() {
        inventarioController.consultarInventario();
    }

}