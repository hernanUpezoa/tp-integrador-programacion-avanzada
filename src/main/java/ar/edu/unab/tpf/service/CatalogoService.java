// RUTA: src/main/java/ar/edu/unab/tpf/service/CatalogoService.java
package ar.edu.unab.tpf.service;

import ar.edu.unab.tpf.model.*; // Importa todas las clases del paquete model
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Servicio para gestionar la lógica de negocio del catálogo de películas.
 * Utiliza principios de POO como la composición y el polimorfismo.
 */
@Service
public class CatalogoService {

    // La lista puede contener cualquier objeto que sea hijo de Pelicula.
    private final List<Pelicula> peliculas = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(100);

    public CatalogoService() {
        // Precargamos datos de ejemplo con los diferentes géneros.
        peliculas.add(new PeliculaAccion("P001", "Duro de Matar", "John McTiernan", 1988));
        peliculas.add(new PeliculaComedia("P002", "Supercool", "Greg Mottola", 2007));
        peliculas.add(new PeliculaCienciaFiccion("P003", "Blade Runner", "Ridley Scott", 1982));
        peliculas.add(new PeliculaDrama("P004", "Forrest Gump", "Robert Zemeckis", 1994));
        peliculas.add(new PeliculaTerror("P005", "El Exorcista", "William Friedkin", 1973));
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
     * Agrega una nueva película (de cualquier género) al catálogo.
     * Le asigna un ID único antes de agregarla.
     * @param pelicula El objeto Pelicula (o una de sus hijas) a agregar.
     */
    public void agregarPelicula(Pelicula pelicula) {
        String nuevoId = "P" + contadorId.incrementAndGet();
        pelicula.setId(nuevoId);
        peliculas.add(pelicula);
    }

    /**
     * Elimina una película del catálogo usando su ID.
     * @param id El ID de la película a eliminar.
     * @return `true` si la película fue encontrada y eliminada, `false` en caso contrario.
     */
    public boolean eliminarPelicula(String id) {
        return peliculas.removeIf(pelicula -> pelicula.getId().equalsIgnoreCase(id));
    }
}