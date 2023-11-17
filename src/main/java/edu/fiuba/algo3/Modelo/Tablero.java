package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Gladiador> listaDeGladiadores;
    private int cantidadDeJugadores;
    private ArrayList<Casilla> listaDeCasillas;
    private Turno turno;

    public Tablero(int cantidadJugadores, Turno turno) {
        this.cantidadDeJugadores = cantidadJugadores;
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


        Gladiador ungladiador = listaDeGladiadores.get(0);//refactorizar porque simpre estamos trabajando con primer gladiaor de la lista

        if (this.validarTurno(ungladiador)) { //(esto es un pecado) refactorizar con excepcion

            Casilla casillaActual = this.obtenerCasilla(ungladiador.obtenerPosicion());
            int energiaModificada = casillaActual.modificarEnergia(ungladiador.obtenerEnergia());
            ungladiador.setEnergia( energiaModificada);
            ungladiador.agregarEquipamiento( casillaActual.getEquipamiento() );
            ungladiador.avanzar(cantidadAMoverse);


        }


    }


}
