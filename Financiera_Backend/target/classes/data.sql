-- CREATE TABLE student (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     firstname VARCHAR(255),
--     lastname VARCHAR(255),
--     email VARCHAR(255)
-- );

-- INSERT INTO student (firstname, lastname, email) VALUES ('John', 'Doe', 'john.doe@example.com');
-- INSERT INTO student (firstname, lastname, email) VALUES ('Jane', 'Smith', 'jane.smith@example.com');


-- Tabla Cliente
CREATE TABLE cliente (
    id INT NOT NULL PRIMARY KEY,
    nombres VARCHAR NOT NULL,
    apellidos VARCHAR NOT NULL,
    dni VARCHAR NOT NULL,
    telefono VARCHAR,
    email VARCHAR
);

-- Tabla Venta
CREATE TABLE venta (
    id INT NOT NULL PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

-- Tabla Producto
CREATE TABLE producto (
    id INT NOT NULL PRIMARY KEY,
    nombre VARCHAR NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

-- Tabla Detalle_Venta
CREATE TABLE detalle_venta (
    id INT NOT NULL PRIMARY KEY,
    id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES venta(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

