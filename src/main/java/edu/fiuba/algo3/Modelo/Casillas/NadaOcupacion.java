package edu.fiuba.algo3.Modelo.Casillas;

import edu.fiuba.algo3.Modelo.Gladiador;

public class NadaOcupacion extends Ocupacion {


    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador) {
        return ungladiador;
    }
}
