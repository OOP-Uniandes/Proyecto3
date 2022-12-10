package src.Vista;

import java.io.IOException;
import java.util.ArrayList;

import src.Interfaces.Login;
import src.Modelo.Equipos.EquipoReal;
import src.Modelo.Jugadores.Jugador;
import src.Modelo.Temporadas.Temporada;
import src.Modelo.Usuarios.Administrador;
import src.Modelo.Usuarios.Participante;
import src.Modelo.Usuarios.Usuario;
import src.Procesamiento.Archivo;

public class App {

	public static Usuario usuarioActual = null;
	public static boolean usuarioLogueado = false;
	public static Administrador adminActual = null;
	public static Participante participanteActual = null;
	public static Temporada temporada;
	public static ArrayList<Jugador> arqueros = new ArrayList<Jugador>();
	public static ArrayList<Jugador> defensores = new ArrayList<Jugador>();
	public static ArrayList<Jugador> mediocampistas = new ArrayList<Jugador>();
	public static ArrayList<Jugador> delanteros = new ArrayList<Jugador>();

	public static void main(String[] args) throws IOException {
		{
			Archivo reader = new Archivo();
			temporada = reader.cargarTemporadas("data/datos_iniciales.json");
			new Login();
			

		}
	}

	public static ArrayList<Jugador> getJugadoresPorPosicion(String posicion) {
		if (posicion.equals("arquero")) {
			return arqueros;
		} else if (posicion.equals("defensa")) {
			return defensores;
		} else if (posicion.equals("mediocampista")) {
			return mediocampistas;
		} else if (posicion.equals("delantero")) {
			return delanteros;
		}
		return null;
	}

	public static EquipoReal getEquipoPorJugador(String nombreJugador) {
		for (int i = 0; i < temporada.getEquipos().size(); i++) {
			for (int j = 0; j < temporada.getEquipos().get(i).getJugadores().size(); j++) {
				if (temporada.getEquipos().get(i).getJugadores().get(j).getNombre().equals(nombreJugador)) {
					return temporada.getEquipos().get(i);
				}
			}

		}
		return null;
	}

	public static Jugador getJugadorPorNombre(String nombreJugador) {
		for (int i = 0; i < temporada.getEquipos().size(); i++) {
			for (int j = 0; j < temporada.getEquipos().get(i).getJugadores().size(); j++) {
				if (temporada.getEquipos().get(i).getJugadores().get(j).getNombre().equals(nombreJugador)) {
					return temporada.getEquipos().get(i).getJugadores().get(j);
				}
			}

		}
		return null;
	}

	}
