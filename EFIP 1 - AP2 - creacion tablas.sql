-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS MinimercadoDB;

-- Seleccionar la base de datos
USE MinimercadoDB;

CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY auto_increment,
    apellido VARCHAR(255),
    nombre VARCHAR(255),
    telefono INT,
    direccion VARCHAR(255),
    localidad VARCHAR(255),
    dni INT
);

CREATE TABLE Proveedor (
    id_proveedor INT PRIMARY KEY auto_increment,
    rubro VARCHAR(255),
    telefono INT
);

CREATE TABLE Producto (
    id_producto INT PRIMARY KEY auto_increment,
    nombre VARCHAR(255),
    tipo_producto VARCHAR(255),
    precio FLOAT
);

CREATE TABLE DetalleVenta (
    id_detalle_venta INT PRIMARY KEY auto_increment,
    id_venta INT,
    cantidad INT,
    id_producto INT,
    forma_pago VARCHAR(255),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

CREATE TABLE Venta(
	id_venta INT PRIMARY KEY auto_increment,
    fecha VARCHAR(30),
    monto_total FLOAT,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_detalle_venta) REFERENCES detalleVenta(id_detalle_venta)
);

CREATE TABLE OrdenCompra(
	id_orden_compra INT PRIMARY KEY auto_increment,
    fecha DATETIME,
    monto_total FLOAT,
    cantidad INT,
    id_proveedor INT,
    id_producto INT,
    FOREIGN KEY (id_proveedor) REFERENCES Proveedor(id_proveedor),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

CREATE TABLE Inventario(
	id_inventario INT PRIMARY KEY auto_increment,
    fecha_ingreso DATETIME,
    fecha_vencimiento DATE,
    cantidad INT,
    id_producto INT,
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

