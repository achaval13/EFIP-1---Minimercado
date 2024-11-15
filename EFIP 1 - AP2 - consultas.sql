SELECT 
    Venta.id_venta,
    Venta.fecha,
    Venta.monto_total,
    Producto.nombre AS producto,
    DetalleVenta.cantidad,
    DetalleVenta.forma_pago
FROM 
    Venta
JOIN 
    Cliente ON Venta.id_cliente = Cliente.id_cliente
JOIN 
    DetalleVenta ON Venta.id_detalle_venta = DetalleVenta.id_detalle_venta
JOIN 
    Producto ON DetalleVenta.id_producto = Producto.id_producto
WHERE 
    Cliente.dni = 12345678; 

SELECT 
    Producto.nombre AS producto,
    Inventario.fecha_ingreso,
    Inventario.fecha_vencimiento,
    Inventario.cantidad,
    CASE 
        WHEN Inventario.fecha_vencimiento < CURDATE() THEN 'Vencido'
        ELSE 'Vigente'
    END AS estado
FROM 
    Inventario
JOIN 
    Producto ON Inventario.id_producto = Producto.id_producto;
    
    
SELECT * FROM producto;
SELECT * FROM cliente;
SELECT * FROM proveedor;
SELECT * FROM inventario join producto on inventario.id_producto = producto.id_producto;
SELECT * FROM venta;
SELECT * FROM detalleventa;

-- Eliminar el cliente
DELETE FROM Cliente
WHERE id_cliente = 1;
