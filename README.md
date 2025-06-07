# TPF Integrador - Programación Avanzada (UNAB 2025)

## 🎬 Sistema de Gestión de Catálogo de Películas

Este proyecto es una aplicación de consola **standalone** desarrollada en **Java** con el framework **Spring Boot**. El objetivo es demostrar los principios de la **Programación Orientada a Objetos (POO)** a través de un sistema simple pero funcional para gestionar un catálogo de películas.

### Integrantes

* [Nombre y Apellido del Alumno 1]
* [Nombre y Apellido del Alumno 2]

---

### 🎯 Problema Resuelto

La aplicación aborda la necesidad de llevar un registro digital de una colección personal de películas. Permite al usuario realizar las siguientes operaciones a través de un menú interactivo en la consola:

1.  **Listar todas las películas** disponibles en el catálogo.
2.  **Agregar una nueva película** especificando su título, director y año de lanzamiento.
3.  **Buscar una película específica** por su ID para ver sus detalles.
4.  **Salir** de la aplicación.

---

### 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3
* **Build Tool:** Maven
* **IDE:** IntelliJ IDEA / VS Code

### 🚀 Cómo Ejecutar el Proyecto

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/tu-repositorio-privado.git](https://github.com/tu-usuario/tu-repositorio-privado.git)
    ```
2.  **Navegar a la carpeta del proyecto:**
    ```bash
    cd tpf-integrador
    ```
3.  **Ejecutar la aplicación con Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```
    La aplicación se iniciará y mostrará el menú interactivo en la consola.

---

### 🏛️ Estructura y Diseño POO

El proyecto está estructurado siguiendo las mejores prácticas para separar las responsabilidades, con un enfoque claro en POO:

* **`model/Pelicula.java`**: Representa el **objeto de dominio**. Es una clase POJO que encapsula los atributos y el estado de una película.
* **`service/CatalogoService.java`**: Representa la **capa de lógica de negocio**. Gestiona las operaciones sobre una colección de objetos `Pelicula`, demostrando el principio de **composición**.
* **`GestionPeliculasApplication.java`**: Es el **punto de entrada** y la capa de presentación (vista/controlador de consola). Orquesta las llamadas al servicio y maneja la interacción con el usuario.
