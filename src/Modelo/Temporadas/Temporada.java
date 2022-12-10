package src.Modelo.Temporadas;

import java.util.ArrayList;

import src.Modelo.Equipos.EquipoReal;
import src.Modelo.Partidos.Partido;

public class Temporada {
    private int id;
    private String fechaInicio;
    private String fechaFinal;
    private String nombre;
    private int presupuesto;

    private ArrayList<Partido> partidos = new ArrayList<Partido>();
    private ArrayList<Ranking> rankingActual = new ArrayList<Ranking>();
    private ArrayList<EquipoReal> equipos = new ArrayList<EquipoReal>();

    public Temporada(int id, String nombre, String fechaInicio, String fechaFinal, int presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.presupuesto = presupuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public ArrayList<Ranking> getRankingActual() {
        return rankingActual;
    }

    public void setRankingActual(ArrayList<Ranking> rankingActual) {
        this.rankingActual = rankingActual;
    }

    public ArrayList<EquipoReal> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<EquipoReal> equipos) {
        this.equipos = equipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresupuesto(double d) {
        this.presupuesto = 0;

    }

    public int getPresupuesto() {
        return presupuesto;
    }

}
