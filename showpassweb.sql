CREATE DATABASE showpass;
USE showpass;

CREATE TABLE evento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    fecha DATE NOT NULL,
    lugar VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    estado VARCHAR(10) DEFAULT 'activo'
);

INSERT INTO evento (nombre, fecha, lugar, precio, estado)
VALUES 
('Circo Luna', '2026-05-10', 'Popayán', 15000, 'activo'),
('Show Tropical', '2026-05-15', 'Cali', 20000, 'activo');