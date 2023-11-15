package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Gladiador> listaDeGladiadores ;
    private int cantidadDeJugadores;
    private Casilla unasCasillas;
    private Turno turno;

    public Tablero(int unosJugadores, Casilla casilla, Turno turno) {
        this.cantidadDeJugadores = unosJugadores;
        this.unasCasillas = casilla ;
        this.listaDeGladiadores = new ArrayList<>();
        this.turno = turno;
    }

    public Tablero(int unosJugadores, Casilla casilla) {
        this.cantidadDeJugadores = unosJugadores;
        this.unasCasillas = casilla ;
        this.listaDeGladiadores = new ArrayList<>();
    }


    public void agregarJugador(Gladiador gladiador) {
            listaDeGladiadores.add(gladiador);
    }


    public boolean validarTurno(Gladiador unGladiador){

        return (turno.jugar(unGladiador.obtenerEnergia()));
    }

    public void avanzar(Dado dado) {
        int moverUnasCasillas = dado.tirar();
        Gladiador ungladiador = listaDeGladiadores.get(0);
        if (this.validarTurno(ungladiador) == true) { //(esto es un pecado) refactorizar con excepcion


            ungladiador.avanzar(moverUnasCasillas);
            int energiaModificada = unasCasillas.modificarEnergia(ungladiador.obtenerEnergia());//por ahora es 1 sola casilla
            ungladiador.setEnergia(energiaModificada);
        }


    }

}
