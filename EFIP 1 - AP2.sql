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
    forma_pago VARCHAR(255),
    cantidad INT,
    id_producto INT,
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

CREATE TABLE Venta(
	id_venta INT PRIMARY KEY auto_increment,
    fecha DATETIME,
    monto_total FLOAT,
    id_cliente INT,
    id_detalle_venta INT,
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

-- Falta de aca para abajo
-- Insertar datos aleatorios en la tabla Mozo
INSERT INTO Cliente (apellido, nombre, telefono, direccion, localidad, dni) 
VALUES 
('Pérez', 'Juan', 35448845, 'Av. Siempreviva 123', 'Oliva', 32145678),
('Gómez', 'María', 35448896, 'Calle Falsa 456', 'Oliva', 12345678),
('Rodríguez', 'Pedro', 35448832, 'Boulevard San Cayetano 789', 'Oliva', 87654321);

INSERT INTO Proveedor (rubro, telefono) 
VALUES 
('Limpieza', 35447654),
('Bebidas', 35448456),
('Alimentos Congelados', 35442349);

INSERT INTO Producto (nombre, tipo_producto, precio) 
VALUES 
('Detergente', 'Limpieza', 150.00),
('Cerveza', 'Bebidas', 120.50),
('Pizza Congelada', 'Alimentos Congelados', 250.00);

INSERT INTO DetalleVenta (forma_pago, cantidad, id_producto) 
VALUES 
('Efectivo', 2, 1),  -- Detergente
('Tarjeta de Crédito', 6, 2),  -- Cerveza
('Débito', 1, 3);  -- Pizza Congelada

INSERT INTO Venta (fecha, monto_total, id_cliente, id_detalle_venta) 
VALUES 
(NOW(), 300.00, 1, 1),
(NOW(), 723.00, 2, 2),
(NOW(), 250.00, 3, 3);

INSERT INTO OrdenCompra (fecha, monto_total, cantidad, id_proveedor, id_producto) 
VALUES 
(NOW(), 450.00, 10, 1, 1),  -- Limpieza
(NOW(), 1200.00, 50, 2, 2),  -- Bebidas
(NOW(), 500.00, 20, 3, 3);  -- Alimentos Congelados

INSERT INTO Inventario (fecha_ingreso, fecha_vencimiento, cantidad, id_producto) 
VALUES 
(NOW(), '2025-09-01', 100, 1),  -- Detergente
(NOW(), '2024-12-31', 200, 2),  -- Cerveza
(NOW(), '2024-10-15', 50, 3);  -- Pizza Congelada
