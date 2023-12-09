package edu.fiuba.algo3.Modelo.Casillas;

import edu.fiuba.algo3.Modelo.Gladiador;

public class NadaOcupacion implements Ocupable {
    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        //ver que hará el Nada
        return unGladiador;
    }


}

