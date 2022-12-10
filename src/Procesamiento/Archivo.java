package src.Procesamiento;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import src.Modelo.Equipos.EquipoReal;
import src.Modelo.Jugadores.Jugador;
import src.Modelo.Partidos.Partido;
import src.Modelo.Temporadas.Ranking;
import src.Modelo.Temporadas.Temporada;
import src.Vista.App;

public class Archivo {

    public Temporada cargarTemporadas(String resourceName) {

        String loc = new String("data/datos_iniciales.json");
        File file = new File(loc);

        Temporada temporada;

        try {
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject jsonContent = new JSONObject(content);
            JSONObject temporadaActual = jsonContent.getJSONObject("temporada");
            temporada = cargaTemporada(temporadaActual);

        } catch (IOException e) {
            temporada = null;
            e.printStackTrace();
        }

        return temporada;
    }

    private Temporada cargaTemporada(JSONObject temporadaActual) {
        int id = temporadaActual.getInt("id");

        String nombre = temporadaActual.getString("nombre");
        String fechaInicio = temporadaActual.getString("fechaInicio");
        String fechaFinal = temporadaActual.getString("fechaFinal");
        int presupuesto = temporadaActual.getInt("presupuesto");

        ArrayList<Ranking> rankings = cargarRanking(temporadaActual);
        ArrayList<EquipoReal> equipos = cargarEquipos(temporadaActual);
        ArrayList<Partido> partidos = cargarPartidos(temporadaActual, equipos);

        Temporada temporada = new Temporada(id, nombre, fechaInicio, fechaFinal, presupuesto);

        temporada.setRankingActual(rankings);
        temporada.setEquipos(equipos);
        temporada.setPartidos(partidos);

        return temporada;
    }

    private ArrayList<Partido> cargarPartidos(JSONObject jsonContent, ArrayList<EquipoReal> equipos) {
        ArrayList<Partido> partidos = new ArrayList<Partido>();
        JSONArray jsonPartidos = jsonContent.getJSONArray("partidos");

        for (int i = 0; i < jsonPartidos.length(); i++) {
            int id = jsonPartidos.getJSONObject(i).getInt("id");
            int equipoLocalId = jsonPartidos.getJSONObject(i).getInt("equipoLocal");
            int equipoVisitanteId = jsonPartidos.getJSONObject(i).getInt("equipoVisitante");
            String fecha = jsonPartidos.getJSONObject(i).getString("fecha");
            String hora = jsonPartidos.getJSONObject(i).getString("hora");

            EquipoReal equipoLocal = buscarEquipoPorId(equipoLocalId, equipos);
            EquipoReal equipoVisitante = buscarEquipoPorId(equipoVisitanteId, equipos);

            Partido partido = new Partido(id, equipoLocal, equipoVisitante, fecha, hora);

            partidos.add(partido);
        }

        return partidos;
    }

    private EquipoReal buscarEquipoPorId(int id, ArrayList<EquipoReal> equipos) {
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getId() == id) {
                return equipos.get(i);
            }
        }
        return null;
    }

    private ArrayList<Ranking> cargarRanking(JSONObject jsonContent) {

        ArrayList<Ranking> rankings = new ArrayList<Ranking>();
        JSONArray jsonRankings = jsonContent.getJSONArray("ranking");

        for (int i = 0; i < jsonRankings.length(); i++) {
            JSONObject rankingActual = jsonRankings.getJSONObject(i);

            int posicion = rankingActual.getInt("posicion");
            String nombre = rankingActual.getString("nombre");
            int puntosTotales = rankingActual.getInt("puntosTotales");

            Ranking objetoRanking = new Ranking(posicion, nombre, puntosTotales);

            rankings.add(objetoRanking);
        }
        return rankings;
    }

    private ArrayList<EquipoReal> cargarEquipos(JSONObject jsonContent) {

        ArrayList<EquipoReal> equipos = new ArrayList<EquipoReal>();
        JSONArray jsonEquipos = jsonContent.getJSONArray("equipos");

        for (int i = 0; i < jsonEquipos.length(); i++) {
            JSONObject equipoActual = jsonEquipos.getJSONObject(i);

            int id = equipoActual.getInt("id");
            String nombre = equipoActual.getString("nombre");
            ArrayList<Jugador> jugadores = cargarJugadores(equipoActual);

            EquipoReal objetoEquipo = new EquipoReal(nombre, id);

            objetoEquipo.setJugadores(jugadores);

            equipos.add(objetoEquipo);
        }
        return equipos;
    }

    private ArrayList<Jugador> cargarJugadores(JSONObject jsonContent) {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        JSONArray jsonJugadores = jsonContent.getJSONArray("jugadores");
        for (int i = 0; i < jsonJugadores.length(); i++) {
            int idActual = jsonJugadores.getJSONObject(i).getInt("id");
            String nombre = jsonJugadores.getJSONObject(i).getString("nombre");
            String posicion = jsonJugadores.getJSONObject(i).getString("posicion");
            double precio = jsonJugadores.getJSONObject(i).getDouble("precio");

            Jugador objetoJugador = new Jugador(idActual, nombre, posicion, precio);

            // aniadir objetojuagdor a la lista de jugadores
            if (objetoJugador.getPosicion().equals("arquero")) {
                App.arqueros.add(objetoJugador);
            } else if (objetoJugador.getPosicion().equals("defensa")) {
                App.defensores.add(objetoJugador);
            } else if (objetoJugador.getPosicion().equals("mediocampista")) {
                App.mediocampistas.add(objetoJugador);
            } else if (objetoJugador.getPosicion().equals("delantero")) {
                App.delanteros.add(objetoJugador);
            }

            jugadores.add(objetoJugador);
        }
        return jugadores;
    }

    public void agregarTemporada() {

    }
}
