package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Gladiador> listaDeGladiadores;
    private int cantidadDeJugadores;
    private ArrayList<Casilla> listaDeCasillas;
    private Turno turno;

    public Tablero(int unosJugadores, Turno turno) {
        this.cantidadDeJugadores = unosJugadores;
        this.listaDeGladiadores = new ArrayList<>();
        this.listaDeCasillas = new ArrayList<>();
        this.turno = turno;
    }

    public void agregarCasilla(Casilla unaCasilla) {
        listaDeCasillas.add(unaCasilla);
    }

    public void agregarJugador(Gladiador gladiador) {
            listaDeGladiadores.add(gladiador);
    }

    public boolean validarTurno(Gladiador unGladiador){return (turno.jugar(unGladiador));}

    private Casilla obtenerCasilla(int unaPosicion){return (listaDeCasillas.get(unaPosicion));}

    public void avanzar(Dado dado) {

        int cantidadAMoverse = dado.tirar();


        Gladiador ungladiador = listaDeGladiadores.get(0);

        if (this.validarTurno(ungladiador)) { //(esto es un pecado) refactorizar con excepcion

            Casilla casillaActual = this.obtenerCasilla(ungladiador.obtenerPosicion());
            int energiaModificada = casillaActual.modificarEnergia(ungladiador.obtenerEnergia());
            ungladiador.setEnergia( energiaModificada);
            ungladiador.avanzar(cantidadAMoverse);


        }


    }


}
