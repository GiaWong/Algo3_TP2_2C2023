package edu.fiuba.algo3.Modelo;
import edu.fiuba.algo3.Modelo.Casillas.Camino;
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

    public Tablero(int cantidadJugadores, Turno turno, Casilla[][] unMapa, Dado dado) {
        this.cantidadDeJugadores = cantidadJugadores;
        this.listaDeGladiadores = new ArrayList<>();
        this.turno = turno;
        this.mapa = unMapa;
        this.dado = dado;

    }
    //Por ahora agrego elcamino asi:
    public List<Casilla> obtenerCamino(){
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        return mapa.obtenereCamino();

    }
    public void agregarCasillaAlMapa(Casilla unaCasilla) {
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
        Gladiador ungladiador = turno.siguienteTurno(listaDeGladiadores);

        if (this.validarTurno(ungladiador)) {

            ungladiador.avanzar(cantidadAMoverse, mapa, this.obtenerCamino());
            Casilla casillaActual = mapa[ungladiador.obtenerPosicionEnX()][ungladiador.obtenerPosicionEnY()];
            System.out.println("\nCasilla ---> (" + casillaActual.obtenerposicionEnX() + "," + casillaActual.obtenerposicionEny() + ")");

            ungladiador = casillaActual.interactuarConLaOcupacion(ungladiador);
        }
    }

    public boolean FinalizarJuego() {
        boolean validacion = turno.validarFinalizarJuego();
        if (validacion) {
            reiniciarTodoLosValores();
        }
        return validacion;

    }

    private void reiniciarTodoLosValores(){
        this.cantidadDeJugadores = 0;
        this.listaDeGladiadores.clear();
        this.turno = null;
    }

    public Gladiador proximoJugador(){
        return turno.siguienteTurno(listaDeGladiadores);
    }
}


