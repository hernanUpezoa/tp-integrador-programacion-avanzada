// RUTA: src/main/java/ar/edu/unab/tpf/IntegradorApplication.java
package ar.edu.unab.tpf;

import ar.edu.unab.tpf.model.*;
import ar.edu.unab.tpf.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class IntegradorApplication implements CommandLineRunner {

    @Autowired
    private CatalogoService catalogoService;

    public static void main(String[] args) {
        SpringApplication.run(IntegradorApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("\n--- ¡Bienvenido al Sistema de Gestión de Películas! ---");

        while (opcion != 5) {
            mostrarMenu();
            try {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1 -> listarPeliculas();
                    case 2 -> agregarNuevaPelicula(scanner);
                    case 3 -> buscarPelicula(scanner);
                    case 4 -> eliminarPelicula(scanner);
                    case 5 -> System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer en caso de error
            }
        }
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n==================== MENÚ ====================");
        System.out.println("1. Listar todas las películas");
        System.out.println("2. Agregar una nueva película");
        System.out.println("3. Buscar película por ID");
        System.out.println("4. Eliminar una película");
        System.out.println("5. Salir");
        System.out.println("============================================");
    }

    private void listarPeliculas() {
        System.out.println("\n--- CATÁLOGO DE PELÍCULAS ---");
        catalogoService.listarTodas().forEach(System.out::println);
    }

    private void agregarNuevaPelicula(Scanner scanner) {
        System.out.println("\n--- AGREGAR NUEVA PELÍCULA ---");
        System.out.println("Seleccione el género:");
        System.out.println("1. Acción");
        System.out.println("2. Comedia");
        System.out.println("3. Drama");
        System.out.println("4. Ciencia Ficción");
        System.out.println("5. Terror");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Director: ");
        String director = scanner.nextLine();
        System.out.print("Año de lanzamiento: ");
        int anio = scanner.nextInt();
        scanner.nextLine();

        Pelicula nuevaPelicula;
        switch (tipo) {
            case 1 -> nuevaPelicula = new PeliculaAccion(null, titulo, director, anio);
            case 2 -> nuevaPelicula = new PeliculaComedia(null, titulo, director, anio);
            case 3 -> nuevaPelicula = new PeliculaDrama(null, titulo, director, anio);
            case 4 -> nuevaPelicula = new PeliculaCienciaFiccion(null, titulo, director, anio);
            case 5 -> nuevaPelicula = new PeliculaTerror(null, titulo, director, anio);
            default -> {
                System.out.println("Género no válido.");
                return;
            }
        }

        catalogoService.agregarPelicula(nuevaPelicula);
        System.out.println("Película agregada con éxito.");
    }

    private void buscarPelicula(Scanner scanner) {
        System.out.println("\n--- BUSCAR PELÍCULA ---");
        System.out.print("Ingrese el ID a buscar: ");
        String id = scanner.nextLine();
        catalogoService.buscarPorId(id)
                .ifPresentOrElse(
                        pelicula -> System.out.println("Película encontrada: " + pelicula),
                        () -> System.out.println("No se encontró ninguna película con ese ID.")
                );
    }

    private void eliminarPelicula(Scanner scanner) {
        System.out.println("\n--- ELIMINAR PELÍCULA ---");
        System.out.print("Ingrese el ID de la película a eliminar: ");
        String id = scanner.nextLine();
        if (catalogoService.eliminarPelicula(id)) {
            System.out.println("Película eliminada con éxito.");
        } else {
            System.out.println("No se encontró ninguna película con ese ID.");
        }
    }
}