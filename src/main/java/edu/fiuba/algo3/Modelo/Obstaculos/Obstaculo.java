package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Gladiador;

public interface Obstaculo {
    void combatir(Gladiador unGladiador);
    int modificarEnergia(int unaEnergia);

}
