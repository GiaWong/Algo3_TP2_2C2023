package edu.fiuba.algo3.Modelo;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Movimiento.Direccion;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private ArrayList<Gladiador> listaDeGladiadores;
    private int cantidadDeJugadores;
    private Turno turno;
    private Casilla[][] mapa;
    private List<Casilla> camino;


    public Tablero(int cantidadJugadores, Turno turno, Casilla[][] unMapa) {
        this.cantidadDeJugadores = cantidadJugadores;
        this.listaDeGladiadores = new ArrayList<>();
        this.turno = turno;
        this.mapa = unMapa;
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

    public void setearCamino(List<Casilla> unCamino){
        camino = unCamino;
    }

    public void avanzar(Dado dado) {

        int cantidadAMoverse = dado.lanzarDado();
        Gladiador ungladiador = turno.siguienteTurno(listaDeGladiadores);

        if (this.validarTurno(ungladiador)) {

            ungladiador.avanzar(cantidadAMoverse);
            Casilla casillaActual = mapa[ungladiador.obetenerPosicionEnX()][ungladiador.obetenerPosicionEnY()];
            System.out.println("\nCasilla ---> (" + casillaActual.obtenerposicionEnX() + "," + casillaActual.obtenerposicionEny() + ")");

            ungladiador = casillaActual.interactuarConLaOcupacion(ungladiador, cantidadAMoverse);
        }
    }
/*
    public boolean FinalizarJuego() {
        boolean validacion = turno.validarFinalizarJuego();
        if (validacion) {
            reiniciarTodoLosValores();
        }
        return validacion;

    }
    /*
    public int LongitudDeTablero(){
        return this.listaDeCasillas.size();
    }

    public boolean validarGanador(Gladiador unGladiador) {

        boolean validarEquipamiento = unGladiador.cantidadEquipamientoPermitido();
        boolean validarPosicion = unGladiador.SeEncuentraEnUltimaPosicion(LongitudDeTablero());

        if (validarPosicion && validarEquipamiento){
            reiniciarTodoLosValores();
            System.out.println("\n----GANASTE, FELICIDADES!----\n");
            return true;
        }
        return false;

    }

    private void reiniciarTodoLosValores(){
        this.cantidadDeJugadores = 0;
        this.listaDeGladiadores.clear();
        this.listaDeCasillas.clear();
        this.turno = null;
    }

}

     */
}