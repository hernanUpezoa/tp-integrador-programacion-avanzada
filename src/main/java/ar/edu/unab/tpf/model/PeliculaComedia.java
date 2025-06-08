package ar.edu.unab.tpf.model;

public class PeliculaComedia extends Pelicula {
    public PeliculaComedia(String id, String titulo, String director, int anio) {
        super(id, titulo, director, anio);
    }

    @Override
    public String toString() {
        return "[COMEDIA] " + super.toString();
    }
}
