# Practica de laboratorio - Semana 09

## Caso elegido:

Se obtuvo el conjunto de datos un gimnacio que contienen los registros diarios de la asistencia
de los miembros del gimnasio, junto con detalles de sus actividades de entrenamiento. Se realizara un
api que conecte a la base de datos y analice las tendencias de los clientes.
Link del dataset: https://www.kaggle.com/datasets/zahranusratt/daily-gym-attendance-and-workout-activity-dataset?resource=download

## Instrucciones de Ejecución

### Requisitos Previos

1. Tener instalado Java (JDK 8 o superior).
2. Tener instalado MySQL.
3. Tener el driver **MySQL Connector/J** en la carpeta `lib/` del proyecto.

### Pasos para levantar el proyecto

1. **Base de Datos:** Ejecuta el script `database.sql` en tu gestor de base de datos (MySQL Workbench, phpMyAdmin, etc.) para crear las tablas.
2. **Configuración:** Abre el archivo `src/DatabaseConexion.java` y modifica las variables `user` y `pass` con las credenciales de tu base de datos local.
3. **Compilación y Ejecución:**
   Desde la carpeta raíz del proyecto, ejecuta los siguientes comandos en la terminal:

   ```bash
   # Compilar (Windows)
   javac -cp "src;lib/*" src/*.java

   # Ejecutar
   java -cp "src;lib/*" GimnasioApi
   ```

4. **Probar:** Abre tu navegador en `http://localhost:8080/api/miembros`.
