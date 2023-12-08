package edu.fiuba.algo3.Modelo.Movimiento;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;


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

            //Se llama al método proximaPosicion de la Casilla en la dirección indicada
            Posicion nuevaPosicion = mapa[nuevaDireccionEnX][nuevaDireccionEnY].proximaPosicion(posicion, direccion, mapa);

            // Si la nueva posición es diferente de null, significa que se encontró un camino
            if (nuevaPosicion != null) {
                return nuevaPosicion;
            }
        }

        return null;





    }
}



/*ArrayList<Direccion> direcciones = new ArrayList<>();
        direcciones.add(new Direccion(1, 0));
        direcciones.add(new Direccion(0, -1));
        direcciones.add(new Direccion(0, 1));



        for (Direccion direccion : direcciones) {
            int nuevaDireccionEnX = posicion.obtenerX() + direccion.getFila();
            int nuevaDireccionEnY = posicion.obtenerY() + direccion.getColumna();

            // Verificar si la casilla en la dirección indicada tiene el atributo "camino"
           // mapa[nuevaDireccionEnX][nuevaDireccionEnY].proximaPosicion(posicion,direccion);

            if (mapa[nuevaDireccionEnX][nuevaDireccionEnY].obtenerTipo().equalsIgnoreCase("CAMINO") ) {
                posicion = new Posicion(nuevaDireccionEnX,nuevaDireccionEnY);
                return posicion;
            }
        }
        return null;*/


   /*else if ( mapa[nuevaDireccionEnX][nuevaDireccionEnY].obtenerTipo().equalsIgnoreCase("LLEGADA")) {
                Direccion nuevaDireccion = new Direccion(12, 4);

                return nuevaDireccion;

            }

             */