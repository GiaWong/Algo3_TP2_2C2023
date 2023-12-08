package edu.fiuba.algo3.Modelo.Movimiento;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import javafx.geometry.Pos;

import java.util.ArrayList;

public class Direccion {
    private int direccionEnX;
    private int direccionEnY;

    public Direccion(int direccionEnX, int direccionEnY) {

        this.direccionEnX = direccionEnX;
        this.direccionEnY = direccionEnY;
    }

    public int getFila() {
        return direccionEnX;
    }

    public int getColumna() {
        return direccionEnY;
    }

    public Posicion proximaPosicion(Casilla[][] mapa, Posicion posicion) {

        ArrayList<Direccion> direcciones = new ArrayList<>();
        direcciones.add(new Direccion(1, 0));
        direcciones.add(new Direccion(0, -1));
        direcciones.add(new Direccion(0, 1));


        for (Direccion direccion : direcciones) {
            int nuevaDireccionEnX = posicion.obtenerX() + direccion.getFila();
            int nuevaDireccionEnY = posicion.obtenerY() + direccion.getColumna();

            // Verificar si la casilla en la dirección indicada tiene el atributo "camino"
            if (mapa[nuevaDireccionEnX][nuevaDireccionEnY].obtenerTipo().equalsIgnoreCase("CAMINO") ) {
                posicion = new Posicion(nuevaDireccionEnX,nuevaDireccionEnY);

                return posicion;

            }

            /*else if ( mapa[nuevaDireccionEnX][nuevaDireccionEnY].obtenerTipo().equalsIgnoreCase("LLEGADA")) {
                Direccion nuevaDireccion = new Direccion(12, 4);

                return nuevaDireccion;

            }

             */

        }
        return null;
    }
}
