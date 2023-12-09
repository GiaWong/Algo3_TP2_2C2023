package edu.fiuba.algo3.Modelo.Movimiento;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;

public class Posicion {

    private int posicionEnX;
    private int posicionEnY;

    public Posicion(int posicionEnX,int posicionEnY){
        this.posicionEnX = posicionEnX;
        this.posicionEnY = posicionEnY;
    }

    public int obtenerX(){
        return posicionEnX;
    }

    public int obtenerY(){
        return posicionEnY;
    }

    public Posicion PosicionSiguiente(Casilla[][] mapa, Direccion direccion){
        return direccion.proximaPosicion(mapa,this);
    }



}
