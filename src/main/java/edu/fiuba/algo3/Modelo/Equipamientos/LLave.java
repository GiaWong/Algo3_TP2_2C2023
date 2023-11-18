package edu.fiuba.algo3.Modelo.Equipamientos;

import edu.fiuba.algo3.Modelo.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Ocupacion;

public class LLave extends Equipamiento implements Ocupacion {

    public LLave(){};

    @Override
    public Gladiador modificarEnergia(Gladiador unGladiador) {
        return null;
    }

    @Override
    public int modificarEnergia(int energia) {
        return 0;
    }

    @Override
    public Gladiador combatir(Gladiador ungladiador) {
        return null;
    }

    @Override
    public Gladiador recibirPremio(Gladiador ungladiador) {
        return null;
    }


}
