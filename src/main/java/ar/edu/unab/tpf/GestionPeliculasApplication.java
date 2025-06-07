// src/main/java/com/unab/tpf/integrador/GestionPeliculasApplication.java
package ar.edu.unab.tpf;

import ar.edu.unab.tpf.model.Pelicula;
import ar.edu.unab.tpf.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**
 * Aplicación Standalone de consola para la gestión de un catálogo de películas.
 * Implementa CommandLineRunner para ejecutar la lógica del menú interactivo.
 */
@SpringBootApplication
public class GestionPeliculasApplication implements CommandLineRunner {

    @Autowired
    private CatalogoService catalogoService;

    public static void main(String[] args) {
        SpringApplication.run(GestionPeliculasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("\n--- ¡Bienvenido al Sistema de Gestión de Películas! ---");

        while (opcion != 4) {
            mostrarMenu();
            System.out.print(" Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    listarPeliculas();
                    break;
                case 2:
                    agregarNuevaPelicula(scanner);
                    break;
                case 3:
                    buscarPelicula(scanner);
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n==================== MENÚ ====================");
        System.out.println("1. Listar todas las películas");
        System.out.println("2. Agregar una nueva película");
        System.out.println("3. Buscar película por ID");
        System.out.println("4. Salir");
        System.out.println("============================================");
    }

    private void listarPeliculas() {
        System.out.println("\n--- CATÁLOGO DE PELÍCULAS ---");
        catalogoService.listarTodas().forEach(System.out::println);
    }

    private void agregarNuevaPelicula(Scanner scanner) {
        System.out.println("\n--- AGREGAR NUEVA PELÍCULA ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Director: ");
        String director = scanner.nextLine();
        System.out.print("Año de lanzamiento: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Pelicula peliculaAgregada = catalogoService.agregarPelicula(titulo, director, ano);
        System.out.println("Película agregada con éxito con ID: " + peliculaAgregada.getId());
    }

    private void buscarPelicula(Scanner scanner) {
        System.out.println("\n--- BUSCAR PELÍCULA ---");
        System.out.print("Ingrese el ID a buscar (ej: P001): ");
        String id = scanner.nextLine();
        catalogoService.buscarPorId(id)
                .ifPresentOrElse(
                        pelicula -> System.out.println("Película encontrada: " + pelicula),
                        () -> System.out.println("No se encontró ninguna película con ese ID.")
                );
    }
}
