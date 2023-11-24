package edu.fiuba.algo3.Modelo.Casillas;

import edu.fiuba.algo3.Modelo.Gladiador;

public class Casilla {
    Ocupacion unaOcupacion;
    VisitorDeCasillas visitor;

    public Casilla(Ocupacion ocupacion) {
        this.unaOcupacion = ocupacion;
        this.visitor = new OperacionVisitorDeCasillas();

    }


    public Gladiador siguiente(Gladiador ungladiador, int cantidadAMoverse, int tamanioLista) {

        ungladiador.aumentarEnergiaAlIniciarElTurno();
        ungladiador.avanzar(cantidadAMoverse);
        ungladiador = unaOcupacion.aceptarVisitante(visitor, ungladiador);//Patron visitor
        estaEnLaUltimaPosicion(ungladiador,tamanioLista);
        return ungladiador;
    }


    private void estaEnLaUltimaPosicion(Gladiador ungladiador, int tamanioLista ) {

        //porque se asume que si ya no hay mas casillas entonces se llegó a la meta
        if (esLaUltimaPosicion(ungladiador.obtenerPosicion(), tamanioLista)) {
            if (!ungladiador.tieneLLave()) {
                System.out.println("\n----Se LLegó a la meta sin equipamiento completo----\n");
                int cantidadAMoverse = obtenerPosicionMitadCasilla(tamanioLista);
                ungladiador.retroceder(cantidadAMoverse);
            }
        }
    }
    private boolean esLaUltimaPosicion(int posicion, int tamanioLista) {
        return  (posicion == tamanioLista - 1);
    }

    private int obtenerPosicionMitadCasilla(int tamanioLista) {

        if (tamanioLista > 0) {
            int indiceMitad = tamanioLista / 2;
            System.out.println("Cantidad casillas a retroceder: " + indiceMitad);
            return indiceMitad ;

        } else {
            return 0;
        }
    }



}

