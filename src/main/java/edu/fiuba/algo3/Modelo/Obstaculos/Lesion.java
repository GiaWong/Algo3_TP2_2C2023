package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Casillas.Ocupable;
import edu.fiuba.algo3.Modelo.Gladiador;

public class Lesion implements Obstaculizador, Ocupable {
    @Override
    public void combatir(Gladiador unGladiador) {

    }

    @Override
    public int modificarEnergia(int unaEnergia) {
        return 0;
    }

    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador ungladiador) {
        return ungladiador;
    }
}
