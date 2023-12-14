package edu.fiuba.algo3.Modelo.Movimiento;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import java.util.List;

public class Direccion {
    private int direccionEnX;
    private int direccionEnY;

    public Direccion(int direccionEnX, int direccionEnY) {

        this.direccionEnX = direccionEnX;
        this.direccionEnY = direccionEnY;
    }


    public Posicion proximaPosicion(List<Casilla> camino, Posicion posicion,int cantidadAMoverse) {


        for (int i = 0; i < camino.size(); i++) {
            Casilla casillaActual = camino.get(i);

            if (casillaActual.obtenerposicionEnX() == posicion.obtenerX() && casillaActual.obtenerposicionEny() == posicion.obtenerY()){


                Casilla nuevaCasilla = camino.get(i + cantidadAMoverse);

                Posicion nuevaPosicion = new Posicion(nuevaCasilla.obtenerposicionEnX(),nuevaCasilla.obtenerposicionEny());
                return nuevaPosicion;

            }

        }

        return null;
    }
}

