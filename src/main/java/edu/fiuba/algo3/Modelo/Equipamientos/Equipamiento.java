package edu.fiuba.algo3.Modelo.Equipamientos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public interface Equipamiento {
    Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador);
    Gladiador modificarEnergia(Gladiador unGladiador);

    int desgastar(int energia);
}
