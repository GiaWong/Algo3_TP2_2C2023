package edu.fiuba.algo3.Modelo.Casillas;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Movimiento.Direccion;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;




public class Casilla {
    Ocupable unaOcupacion;
    Ocupable unaSegundaOcupacion;

    int posicionEnX;
    int posicionEnY;

    String tipo;


    public Casilla(Ocupable primeraOcupacion, Ocupable segundaOcupacion,int posX, int posY, String tipo) {
        this.unaOcupacion = primeraOcupacion;
        this.unaSegundaOcupacion = segundaOcupacion;
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

    public Gladiador interactuarConLaOcupacion(Gladiador ungladiador) {

        ungladiador.aumentarEnergiaAlIniciarElTurno();
        ungladiador = unaSegundaOcupacion.interactuarConLaOcupacion(ungladiador);
        ungladiador = unaOcupacion.interactuarConLaOcupacion( ungladiador);

        return ungladiador;
    }


    public Posicion proximaPosicion(Posicion posicion, Direccion direccion, Casilla[][] mapa) {

        int nuevaDireccionEnX = posicion.obtenerX() + direccion.getFila();
        int nuevaDireccionEnY = posicion.obtenerY() + direccion.getColumna();

        // Verificar si la nueva posición está dentro de los límites del mapa
        if (nuevaDireccionEnX >= 0 && nuevaDireccionEnX < mapa.length &&
                nuevaDireccionEnY >= 0 && nuevaDireccionEnY < mapa[0].length) {

            // Verificar si la casilla en la dirección indicada es un camino
            if (mapa[nuevaDireccionEnX][nuevaDireccionEnY].esCamino()) {
                return new Posicion(nuevaDireccionEnX, nuevaDireccionEnY);
            }
        }

        return null;
    }

    private boolean esCamino() {
        return tipo.equalsIgnoreCase("Camino");
    }
}

