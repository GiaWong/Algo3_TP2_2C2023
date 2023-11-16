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


    public boolean validarTurno(Gladiador unGladiador){

        return (turno.jugar(unGladiador));
    }

    public Casilla obtenerCasilla(int unaPosicion) {
       return (listaDeCasillas.get(unaPosicion));
    }



    public void avanzar(Dado dado) {
        int moverUnasCasillas = dado.tirar();
        Gladiador ungladiador = listaDeGladiadores.get(0);

        if (this.validarTurno(ungladiador) == true) { //(esto es un pecado) refactorizar con excepcion

            //Casco casco=listaDeCasillas.get(0); //POSICION 0 DAME LO QUE TENES --> CASCO
            Casilla casillaActual = obtenerCasilla(ungladiador.obtenerPosicion());
            Ocupacion unaOcupacion = casillaActual.obtenerOcupacion();

            ungladiador.avanzar(moverUnasCasillas);
            int energiaModificada = unaOcupacion.modificarEnergia(ungladiador.obtenerEnergia());//por ahora es 1 sola casilla

            ungladiador.setEnergia(energiaModificada);
        }


    }

}
