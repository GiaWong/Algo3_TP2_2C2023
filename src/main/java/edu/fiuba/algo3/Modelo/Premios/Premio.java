package edu.fiuba.algo3.Modelo.Premios;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public interface Premio {
    Gladiador aceptarVisitante(VisitorDeCasillas visitor,Gladiador ungladiador);
    void modificarEnergia(Gladiador unGladiador);
}
