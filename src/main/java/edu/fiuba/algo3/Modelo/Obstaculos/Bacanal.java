package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Casillas.Ocupable;
import edu.fiuba.algo3.Modelo.DadoMock;
import edu.fiuba.algo3.Modelo.Gladiador;

public class Bacanal implements Obstaculizador, Ocupable {
    @Override
    public void combatir(Gladiador unGladiador) {
        unGladiador.combatir(this );
    }

    public Bacanal(){}
    public int modificarEnergia(int energia) {
        DadoMock dado = new DadoMock();
        int tragosTomados = dado.lanzarDado();
        return (energia - (4 * tragosTomados)) ;
    }

    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        this.combatir(unGladiador);
        System.out.println("\nEntró a Bacanal");
        return  unGladiador;
    }
}
