package src.Modelo.Temporadas;

public class Ranking {
    private int posicion;
    private String nombre;
    private int puntosTotales;

    public Ranking(int posicion, String nombre, int puntosTotales) {
        this.posicion = posicion;
        this.nombre = nombre;
        this.puntosTotales = puntosTotales;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

}
