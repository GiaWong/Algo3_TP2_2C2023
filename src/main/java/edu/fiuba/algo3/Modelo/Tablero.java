package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
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


    public void avanzar(Dado dado) {

        int cantidadAMoverse = dado.tirar();
        Gladiador ungladiador = turno.siguienteTurno(listaDeGladiadores);

        if (this.validarTurno(ungladiador)) {

            controladorCantidadMoverse = controladorCantidadMoverse + cantidadAMoverse;
            Casilla casillaActual = listaDeCasillas.get(controladorCantidadMoverse);
            ungladiador = casillaActual.siguiente(ungladiador, cantidadAMoverse, listaDeCasillas.size());

            //hay que actualizar la lista de gladiadores para despues por eso esta ungladiador con color gris


        }
    }

    public boolean FinalizarJuego(){
        return turno.validarFinalizarJuego();
        //ACA SE TIENE QUE TERMINAR EL TABLERO Y TODO EL JUEGO EN GENERAL
    }

}

