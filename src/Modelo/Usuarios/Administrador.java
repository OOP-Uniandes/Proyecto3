package src.Modelo.Usuarios;

import src.Modelo.Equipos.EquipoReal;
import src.Modelo.Jugadores.Jugador;
import src.Modelo.Partidos.Partido;
import src.Modelo.Temporadas.Temporada;

public class Administrador extends Usuario {

    public Administrador(String nombre, String contraseña, String rol) {
        super(nombre, contraseña, rol);
    }

    public Temporada crearTemporada(int id, String nombre, String fechaInicio, String fechaFinal, int presupuesto) {
        Temporada temporada = new Temporada(id, nombre, fechaInicio, fechaFinal, presupuesto);
        return temporada;
    }

    public EquipoReal equipoReal(String nombre, int id) {
        EquipoReal equipo = new EquipoReal(nombre, id);
        return equipo;
    }

    public Jugador crearJugador(int id, String nombre, String posicion, Double precio) {
        Jugador jugador = new Jugador(id, nombre, posicion, precio);
        return jugador;
    }

    public Partido crearPartido(int id, EquipoReal equipoLocal, EquipoReal equipoVisitante, String fecha, String hora) {
        Partido partido = new Partido(id, equipoLocal, equipoVisitante, fecha, hora);
        return partido;
    }

    
}
