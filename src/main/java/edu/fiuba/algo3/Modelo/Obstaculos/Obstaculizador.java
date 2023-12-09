package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Gladiador;

public interface Obstaculizador {
    void combatir(Gladiador unGladiador);
    int modificarEnergia(int unaEnergia);

}
