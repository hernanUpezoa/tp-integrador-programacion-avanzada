package ar.edu.unab.tpf.model;

public class PeliculaDrama extends Pelicula {
    public PeliculaDrama(String id, String titulo, String director, int anio) {
        super(id, titulo, director, anio);
    }

    @Override
    public String toString() {
        return "[DRAMA] " + super.toString();
    }
}