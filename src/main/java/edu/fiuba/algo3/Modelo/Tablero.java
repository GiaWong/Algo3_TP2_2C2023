package edu.fiuba.algo3.Modelo;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Dados.Dado;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private ArrayList<Gladiador> listaDeGladiadores;
    private int cantidadDeJugadores;
    private Turno turno;
    private Casilla[][] mapa;
    private Dado dado;
    private Casilla casillaActual;
    private Gladiador ungladiador;
    private List<Casilla> camino;
    private  boolean gladiadorGanaPartida;

    public Tablero(int cantidadJugadores, Turno turno, Casilla[][] unMapa, List<Casilla> camino,Dado dado) {
        this.cantidadDeJugadores = cantidadJugadores;
        this.listaDeGladiadores = new ArrayList<>();
        this.turno = turno;
        this.mapa = unMapa;
        this.dado = dado;
        this.camino = camino;
        this.gladiadorGanaPartida = false;

    }
    public void agregarCasillaAlMapa(Casilla unaCasilla) {
        this.camino.add(unaCasilla);
        this.mapa[unaCasilla.obtenerposicionEnX()][unaCasilla.obtenerposicionEny()] = unaCasilla;
    }

    public void agregarJugador(Gladiador gladiador) {
        listaDeGladiadores.add(gladiador);
    }

    public boolean validarTurno(Gladiador unGladiador) {
        return (turno.jugar(unGladiador));
    }

    public void avanzar() {

        int cantidadAMoverse = dado.lanzarDado();
        this.ungladiador = turno.siguienteTurno(listaDeGladiadores);

        if (this.validarTurno(ungladiador)) {

            ungladiador.avanzar(cantidadAMoverse,camino);
            validarGanador(ungladiador);
            //Casilla casillaActual = mapa[ungladiador.obtenerPosicionEnX()][ungladiador.obtenerPosicionEnY()];
            this.casillaActual = mapa[ungladiador.obtenerPosicionEnX()][ungladiador.obtenerPosicionEnY()];

            ungladiador = casillaActual.interactuarConLaOcupacion(ungladiador);
        }
    }

    public void FinalizarJuego() {
        if (turno.validarFinalizarJuego()) {
            reiniciarTodoLosValores();
        }
    }

    public void validarGanador(Gladiador unGladiador){

        if (!camino.isEmpty()) {
            Casilla casillaMeta = camino.get(camino.size() - 1);// Obtener el último elemento
            gladiadorGanaPartida = unGladiador.validarLLegadaALaMeta(casillaMeta.obtenerposicionEnX(),casillaMeta.obtenerposicionEny(), camino);
            if(gladiadorGanaPartida){
                FinalizarJuego();
            }
        }
    }

    private void reiniciarTodoLosValores(){
        this.cantidadDeJugadores = 0;
        this.listaDeGladiadores.clear();
        this.turno = null;
    }

    public boolean gladiadorGanaPartida(){
        return gladiadorGanaPartida;
    }

    public Casilla obtenerCasillaALaQueSeDesplazo(){
        return casillaActual;
    }

    public Gladiador obtenerGladiadorQueJugo(){
        return ungladiador;
    }


}


