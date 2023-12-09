package edu.fiuba.algo3.Modelo.Movimiento;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;

import java.util.List;

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

    public Posicion PosicionSiguien(List<Casilla> camino, Direccion direccion,int cantidadAMoverse){
        return direccion.proximaPosicion(camino,this,cantidadAMoverse);
    }



}
