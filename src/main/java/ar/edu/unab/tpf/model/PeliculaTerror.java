package ar.edu.unab.tpf.model;

public class PeliculaTerror extends Pelicula {
    public PeliculaTerror(String id, String titulo, String director, int anio) {
        super(id, titulo, director, anio);
    }

    @Override
    public String toString() {
        return "[TERROR] " + super.toString();
    }
}