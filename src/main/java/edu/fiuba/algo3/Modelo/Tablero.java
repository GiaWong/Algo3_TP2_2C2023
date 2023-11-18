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

    private int obtenerPosicionMitadCasilla() {

        int longitud = listaDeCasillas.size();
        if (longitud > 0) {
            int indiceMitad = longitud / 2;
            System.out.println("Cantidad casillas a retroceder: " + indiceMitad);
            return indiceMitad ;

        } else {
            return 0;
        }
    }
    private boolean hayMasCasillas() {
        return (listaDeCasillas.size() > 1);
    }

    private boolean esLaUltimaPosicion(int posicion) {
        return  (posicion == listaDeCasillas.size() - 1);
    }



    public void avanzar(Dado dado) {

        int cantidadAMoverse = dado.tirar();
        Gladiador ungladiador = listaDeGladiadores.get(0);//refactorizar porque simpre estamos trabajando con primer gladiaor de la lista

        if (this.validarTurno(ungladiador)) { //(esto es un pecado) refactorizar con excepcion
            ungladiador.aumentarEnergiaAlIniciarElTurno();

            Casilla casillaActual = obtenerCasilla(ungladiador.obtenerPosicion());

            //Hay que debugear y ver por que no lo toma el test 7 y 8 al entrar al metodo enfrentarObstaculo()
            ungladiador = casillaActual.enfrentarObstaculo(ungladiador);
            ungladiador = casillaActual.recibirPremio(ungladiador);

            if(hayMasCasillas()) {
                ungladiador.avanzar(cantidadAMoverse);
            }

            if(esLaUltimaPosicion(ungladiador.obtenerPosicion())){//porque asumí que si ya no hay mas casillas entonces se llegó a la meta

                if (!ungladiador.tieneLLave()) { //si no tiene llave
                    System.out.println("\n----Se LLegó a la meta sin equipamiento completo----\n");
                    cantidadAMoverse = obtenerPosicionMitadCasilla();
                    ungladiador.retroceder(cantidadAMoverse);
                }

            }

        }
    }

}
