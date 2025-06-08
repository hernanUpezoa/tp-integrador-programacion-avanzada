package ar.edu.unab.tpf.model;

public class PeliculaAccion extends Pelicula {
    public PeliculaAccion(String id, String titulo, String director, int anio) {
        super(id, titulo, director, anio);
    }

    @Override
    public String toString() {
        return "[ACCIÓN] " + super.toString();
    }
}