// src/main/java/com/unab/tpf/integrador/model/Pelicula.java
package ar.edu.unab.tpf.model;

/**
 * Clase que representa una Película en el catálogo.
 * Encapsula los datos de la película como id, título, director y año.
 * Clase PADRE que sirve como base para todos los géneros.
 */
public class Pelicula {

    private String id; // Identificador único
    private String titulo;
    private String director;
    private int anio; // Año de lanzamiento

    public Pelicula(String id, String titulo, String director, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
    }

    // --- Getters y Setters ---
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    // Método para mostrar la información de la película de forma clara
    @Override
    public String toString() {
        return "Pelicula {" +
               "ID='" + id + '\'' +
               ", Título='" + titulo + '\'' +
               ", Director='" + director + '\'' +
               ", Año=" + anio +
               '}';
    }
}
