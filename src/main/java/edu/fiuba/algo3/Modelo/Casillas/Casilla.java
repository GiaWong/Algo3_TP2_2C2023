package edu.fiuba.algo3.Modelo.Casillas;
import edu.fiuba.algo3.Modelo.Gladiador;


public class Casilla {
    Ocupable unaOcupacion;
    Ocupable unaSegundaOcupacion;

    int posicionEnX;
    int posicionEnY;

    public Casilla(Ocupable ocupacion) {
        this.unaOcupacion = ocupacion;
    }

    public Casilla(Ocupable obstaculo, Ocupable premio,int posX, int posY) {
        this.unaOcupacion = premio;
        this.unaSegundaOcupacion = obstaculo;
        this.posicionEnX = posX;
        this.posicionEnY = posY;
    }

    public int obtenerposicionEnX(){
        return posicionEnX;
    }

    public int obtenerposicionEny(){
        return posicionEnY;
    }


    public Gladiador interactuarConLaOcupacion(Gladiador ungladiador, int cantidadAMoverse, int tamanioLista) {

        ungladiador.aumentarEnergiaAlIniciarElTurno();
        ungladiador.avanzar(cantidadAMoverse);
        ungladiador = unaOcupacion.interactuarConLaOcupacion( ungladiador);


        //Le clavo un if para poder interactuar con dos casillas
        if (unaSegundaOcupacion !=null  ) {
            ungladiador = unaSegundaOcupacion.interactuarConLaOcupacion(ungladiador);
        }

        //estaEnLaUltimaPosicion(ungladiador,tamanioLista);
        return ungladiador;
    }

    /*
    private void estaEnLaUltimaPosicion(Gladiador ungladiador, int tamanioLista ) {

        if (esLaUltimaPosicion(ungladiador.obtenerPosicion(), tamanioLista)) {
            if (!ungladiador.tieneLLave()) {
                System.out.println("\n----Se LLegó a la meta sin equipamiento completo----\n");
                int cantidadAMoverse = obtenerPosicionMitadCasilla(tamanioLista);
                ungladiador.retroceder(cantidadAMoverse);
            }
            System.out.println("\n----Se LLegó a la meta con TODO el EQUIPAMIENTO completo----\n");
        }
    }
    */

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

