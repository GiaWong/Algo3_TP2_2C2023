package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Casillas.Ocupable;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Vista.PantallaMapa;

public class Bacanal implements Obstaculizador, Ocupable {
    @Override
    public void combatir(Gladiador unGladiador) {
        unGladiador.combatir(this );
    }

    @Override
    public int modificarEnergia(int energia) {
        DadoMock dado = new DadoMock();
        int tragosTomados = dado.lanzarDado();
        return (energia - (4 * tragosTomados)) ;
    }

    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        this.combatir(unGladiador);
        System.out.println("\nEntró a Bacanal");
        PantallaMapa.obtenerLabelObstaculo().setText("El jugador entró a un Bacanal.");
        return  unGladiador;
    }
}
