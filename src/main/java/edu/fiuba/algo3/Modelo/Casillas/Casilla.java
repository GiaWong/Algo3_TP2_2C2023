package edu.fiuba.algo3.Modelo.Casillas;
import edu.fiuba.algo3.Modelo.Gladiador;


public class Casilla {
    Ocupable unaOcupacion;
    Ocupable unaSegundaOcupacion;

    int posicionEnX;
    int posicionEnY;

    String tipo;

    public Casilla(Ocupable obstaculo, Ocupable premio,int posX, int posY, String tipo) {
        this.unaOcupacion = premio;
        this.unaSegundaOcupacion = obstaculo;
        this.posicionEnX = posX;
        this.posicionEnY = posY;
        this.tipo = tipo;
    }

    public int obtenerposicionEnX(){
        return posicionEnX;
    }

    public int obtenerposicionEny(){
        return posicionEnY;
    }

    public Gladiador interactuarConLaOcupacion(Gladiador ungladiador, int cantidadAMoverse) {

        ungladiador.aumentarEnergiaAlIniciarElTurno();
        ungladiador = unaOcupacion.interactuarConLaOcupacion( ungladiador);

        //Le clavo un if para poder interactuar con dos casillas
        if (unaSegundaOcupacion !=null  ) {
            ungladiador = unaSegundaOcupacion.interactuarConLaOcupacion(ungladiador);
        }

        return ungladiador;
    }

    public boolean tieneCamino(){
        if (tipo.equalsIgnoreCase("CAMINO")){
            return true ;
        }
        return false    ;
    }

    public String obtenerTipo(){
        return tipo;
    }

}

