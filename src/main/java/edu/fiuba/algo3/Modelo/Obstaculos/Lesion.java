package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Casillas.Ocupable;
import edu.fiuba.algo3.Modelo.DadoMock;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Turno;

public class Lesion implements Obstaculizador, Ocupable {

    @Override
    public void combatir(Gladiador unGladiador) {
    }

    public Lesion(){}
    public int modificarEnergia(int energia) {
        return energia;
    }

    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        System.out.println("\nEntró a Lesion");
        Turno.perderSiguienteTurno(unGladiador);
        return  unGladiador;
    }

}
