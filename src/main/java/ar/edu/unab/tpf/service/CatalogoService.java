// src/main/java/com/unab/tpf/integrador/service/CatalogoService.java
package ar.edu.unab.tpf.service;

import ar.edu.unab.tpf.model.Pelicula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Servicio para gestionar la lógica de negocio del catálogo de películas.
 * Utiliza principios de POO como la composición, al manejar una lista de objetos Pelicula.
 */
@Service
public class CatalogoService {

    private final List<Pelicula> peliculas = new ArrayList<>();
    // Generador de IDs simples para las nuevas películas
    private final AtomicLong contadorId = new AtomicLong(100);

    public CatalogoService() {
        // Precargamos algunos datos para la demostración
        peliculas.add(new Pelicula("P001", "Pulp Fiction", "Quentin Tarantino", 1994));
        peliculas.add(new Pelicula("P002", "The Godfather", "Francis Ford Coppola", 1972));
        peliculas.add(new Pelicula("P003", "El Secreto de sus Ojos", "Juan José Campanella", 2009));
    }

    /**
     * Devuelve todas las películas del catálogo.
     * @return Una lista de películas.
     */
    public List<Pelicula> listarTodas() {
        return peliculas;
    }

    /**
     * Busca una película por su ID.
     * @param id El ID de la película a buscar.
     * @return Un Optional que contiene la película si se encuentra.
     */
    public Optional<Pelicula> buscarPorId(String id) {
        return peliculas.stream()
                        .filter(pelicula -> pelicula.getId().equalsIgnoreCase(id))
                        .findFirst();
    }

    /**
     * Agrega una nueva película al catálogo, asignándole un ID único.
     * @param titulo El título de la película.
     * @param director El director de la película.
     * @param ano El año de lanzamiento.
     * @return La película creada.
     */
    public Pelicula agregarPelicula(String titulo, String director, int ano) {
        String nuevoId = "P" + contadorId.incrementAndGet();
        Pelicula nuevaPelicula = new Pelicula(nuevoId, titulo, director, ano);
        peliculas.add(nuevaPelicula);
        return nuevaPelicula;
    }
}
