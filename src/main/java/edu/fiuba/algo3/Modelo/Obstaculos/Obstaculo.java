package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public interface Obstaculo {
    void combatir(Gladiador unGladiador);

    public int modificarEnergia(int unaEnergia);

}
