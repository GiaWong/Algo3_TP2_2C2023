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


    public Casilla(Ocupable primeraOcupacion, Ocupable segundaOcupacion, int posX, int posY, String tipo) {
        this.unaOcupacion = primeraOcupacion;
        this.unaSegundaOcupacion = segundaOcupacion;
        this.posicionEnX = posX;
        this.posicionEnY = posY;
        this.tipo = tipo;

    }

    public int obtenerposicionEnX() {
        return posicionEnX;
    }

    public int obtenerposicionEny() {
        return posicionEnY;
    }

    public Gladiador interactuarConLaOcupacion(Gladiador ungladiador) {

        ungladiador.aumentarEnergiaAlIniciarElTurno();
        ungladiador = unaSegundaOcupacion.interactuarConLaOcupacion(ungladiador);
        ungladiador = unaOcupacion.interactuarConLaOcupacion(ungladiador);

        return ungladiador;
    }

}

