package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public interface Obstaculo {
    Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador);
    void combatir(Gladiador unGladiador);

}
