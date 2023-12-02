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


    public Gladiador interactuarConLaOcupacion(Gladiador ungladiador, int cantidadAMoverse) {

        ungladiador.aumentarEnergiaAlIniciarElTurno();
        ungladiador.avanzar(cantidadAMoverse);
        ungladiador = unaOcupacion.interactuarConLaOcupacion( ungladiador);

        //Le clavo un if para poder interactuar con dos casillas
        if (unaSegundaOcupacion !=null  ) {
            ungladiador = unaSegundaOcupacion.interactuarConLaOcupacion(ungladiador);
        }

        return ungladiador;
    }


}

