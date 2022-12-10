package src.Modelo.Usuarios;

import java.util.ArrayList;


import src.Modelo.Equipos.EquipoFantasia;
import src.Modelo.Equipos.EquipoReal;
import src.Modelo.Jugadores.Jugador;
import src.Modelo.Temporadas.Temporada;

public class Participante extends Usuario{

    EquipoFantasia equipo = null;

    public Participante(String nombre, String contraseña, String rol) {
        super(nombre, contraseña, "Participante");
    }


    public EquipoFantasia crearEquipo(String nombre, int id, int puntajeActual, double presupuesto) {
        EquipoFantasia equipo = new EquipoFantasia(nombre, id, puntajeActual, presupuesto);
        return equipo;

    }

    public void configurarAlineacion(ArrayList<Jugador> alineacion, EquipoFantasia equipo) {
        equipo.setAlineacion(alineacion);
    }

    public Jugador comprarJugador(int id, String nombre) {
        Jugador comprar = new Jugador(id, nombre, nombre, null);
        return comprar;

    }

    public EquipoFantasia getEquipo() {
        return this.equipo;
    }

    public void setEquipo(EquipoFantasia equipo) {
        this.equipo = equipo;
    }

    public ArrayList<Jugador> mostrarJugadoresTemporada(Temporada temporada) {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

        for (EquipoReal equipo : temporada.getEquipos()) {
            for (Jugador jugador : equipo.getJugadores()) {
                jugadores.add(jugador);
            }
        }

        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " " + jugador.getPosicion() + " " + jugador.getPrecio());
        }

        return jugadores;
    }

    public Jugador buscarJugadorPorNombre(String nombreJugador, ArrayList<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombreJugador)) {
                return jugador;
            }
        }
        return null;
    }

}