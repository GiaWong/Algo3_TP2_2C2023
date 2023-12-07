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

    public Direccion obtenerProximaCasillaConCamino(Casilla[][] mapa) {

        ArrayList<Direccion> direcciones = new ArrayList<>();
        direcciones.add(new Direccion(1, 0));
        direcciones.add(new Direccion(0, -1));
        direcciones.add(new Direccion(0, 1));
        direcciones.add(new Direccion(-1, 0));

        for (Direccion direccion : direcciones) {
            int nuevaDireccionEnX = direccionEnX + direccion.getFila();
            int nuevaDireccionEnY = direccionEnY + direccion.getColumna();

            // Verificar si la casilla en la dirección indicada tiene el atributo "camino"
            if (mapa[nuevaDireccionEnX][nuevaDireccionEnY].obtenerTipo().equalsIgnoreCase("CAMINO")) {
                Direccion nuevaDireccion = new Direccion(nuevaDireccionEnX, nuevaDireccionEnY);
                return nuevaDireccion;
            }

        }
        return null;
    }
}
