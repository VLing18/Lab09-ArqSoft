-- 1. Creación de la base de datos
CREATE DATABASE IF NOT EXISTS db_practica09;
USE db_practica09;

-- 2. Tabla: miembros
-- Contiene los datos que no cambian en cada visita (evita repetir edad y género innecesariamente)
CREATE TABLE miembros (
    member_id INT PRIMARY KEY,
    age INT,
    gender VARCHAR(20),
    membership_type VARCHAR(50)
);

-- 3. Tabla: asistencias
-- Contiene el registro de cada actividad realizada
-- Mantiene exactamente las columnas solicitadas
CREATE TABLE asistencias (
    visit_id INT AUTO_INCREMENT PRIMARY KEY, -- ID técnico para control de registros
    member_id INT,
    visit_date DATE,
    workout_type VARCHAR(100),
    workout_duration_minutes INT,
    calories_burned INT,
    check_in_time TIME,
    attendance_status VARCHAR(50),
    -- Relación con la tabla miembros
    CONSTRAINT fk_miembro FOREIGN KEY (member_id) REFERENCES miembros(member_id)
);

