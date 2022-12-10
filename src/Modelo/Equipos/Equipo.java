package src.Modelo.Equipos;

import java.util.ArrayList;

import src.Modelo.Jugadores.Jugador;

public class Equipo {
    private int id;
    private String nombre;
    protected ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    public Equipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
