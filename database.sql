-- 1. Creación de la base de datos
CREATE DATABASE IF NOT EXISTS db_practica09;
USE db_practica09;

-- 2. Tabla: miembros (Datos estáticos del usuario)
CREATE TABLE miembros (
    member_id INT PRIMARY KEY,
    age INT,
    gender VARCHAR(20),
    membership_type VARCHAR(50)
);

-- 3. Tabla: tipos_ejercicio (Catálogo de actividades)
-- Esto es lo que faltaba para la normalización completa
CREATE TABLE tipos_ejercicio (
    exercise_id INT AUTO_INCREMENT PRIMARY KEY,
    exercise_name VARCHAR(100) UNIQUE -- Ej: 'Yoga', 'HIIT', 'Cardio'
);

-- 4. Tabla: asistencias (Transaccional)
CREATE TABLE asistencias (
    visit_id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT,
    visit_date DATE,
    exercise_id INT, -- Ahora es una llave foránea, no un texto
    workout_duration_minutes INT,
    calories_burned INT,
    check_in_time TIME,
    attendance_status VARCHAR(50),
    
    -- Relaciones (Llaves Foráneas)
    CONSTRAINT fk_miembro FOREIGN KEY (member_id) REFERENCES miembros(member_id),
    CONSTRAINT fk_ejercicio FOREIGN KEY (exercise_id) REFERENCES tipos_ejercicio(exercise_id)
);
