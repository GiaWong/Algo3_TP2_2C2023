package edu.fiuba.algo3.Modelo.Casillas;

import edu.fiuba.algo3.Modelo.Gladiador;

public class Casilla {
    Ocupacion unaOcupacion;

    public Casilla(Ocupacion ocupacion) {
        this.unaOcupacion = ocupacion;

    }

    public Gladiador interactuarConLaOcupacion(VisitorDeCasillas visitor, Gladiador ungladiador) {

        return unaOcupacion.aceptarVisitante(visitor, ungladiador);

    }
}

