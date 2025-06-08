package ar.edu.unab.tpf.model;

public class PeliculaCienciaFiccion extends Pelicula {
    public PeliculaCienciaFiccion(String id, String titulo, String director, int anio) {
        super(id, titulo, director, anio);
    }

    @Override
    public String toString() {
        return "[CIENCIA FICCIÓN] " + super.toString();
    }
}