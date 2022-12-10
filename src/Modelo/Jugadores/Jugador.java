package src.Modelo.Jugadores;

public class Jugador {
    int id;
    String nombre;
    String posicion;
    Double precio;

    public Jugador(int id, String nombre, String posicion, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
