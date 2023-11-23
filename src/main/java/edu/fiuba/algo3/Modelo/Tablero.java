package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.OperacionVisitorDeCasillas;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Gladiador> listaDeGladiadores;
    private int cantidadDeJugadores;
    private ArrayList<Casilla> listaDeCasillas;
    private Turno turno;
    private int controladorCantidadMoverse;

    public Tablero(int cantidadJugadores, Turno turno) {
        this.cantidadDeJugadores = cantidadJugadores;
        this.listaDeGladiadores = new ArrayList<>();
        this.listaDeCasillas = new ArrayList<>();
        this.turno = turno;
        this.controladorCantidadMoverse = 0;
    }

    public void agregarCasilla(Casilla unaCasilla) {
        listaDeCasillas.add(unaCasilla);
    }

    public void agregarJugador(Gladiador gladiador) {
            listaDeGladiadores.add(gladiador);
    }

    public boolean validarTurno(Gladiador unGladiador){return (turno.jugar(unGladiador));}

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
        Gladiador ungladiador = turno.siguienteTurno(listaDeGladiadores);

        if (this.validarTurno(ungladiador)) {//refactorizar
            ungladiador.aumentarEnergiaAlIniciarElTurno();

            if(hayMasCasillas()) {

                ungladiador.avanzar(cantidadAMoverse);
                //Patron visitor
                VisitorDeCasillas visitor = new OperacionVisitorDeCasillas();
                controladorCantidadMoverse = controladorCantidadMoverse + cantidadAMoverse;
                Casilla casillaActual = listaDeCasillas.get(controladorCantidadMoverse);
                ungladiador = casillaActual.interactuarConLaOcupacion(visitor, ungladiador);

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

    public boolean validarFinalizarJuego(){
        int turno = this.turno.obtenerTurno(); //violando ocultamiento de la informacion(?
        boolean devolver = false; // inicizalizamos el valor de un boleano
        if (turno >= 30){
            System.out.println("Se finalizo el juego ----> cantidad de turnos para llegar a 30 es " + (30-turno));
            devolver = true;
        }
        if (turno < 30){
            System.out.println("Aun NO se finalizo el juego ----> cantidad de turnos para llegar a 30 es " + (30-turno));
            devolver = false;
        }
        return devolver;
    }

}

