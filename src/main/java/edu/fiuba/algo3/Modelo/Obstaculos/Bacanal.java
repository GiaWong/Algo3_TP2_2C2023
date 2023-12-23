package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Casillas.Ocupable;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Vista.PantallaMapa;

public class Bacanal implements Obstaculizador, Ocupable {
    private Gladiador gladiador;
    @Override
    public void combatir(Gladiador unGladiador) {
        unGladiador.tomarTragos(this );
    }

    @Override
    public int modificarEnergia(int energia) {
        //DadoMock dado = new DadoMock();
        //int tragosTomados = dado.lanzarDado();
        return (energia - (4 * gladiador.obtenerTragosATomar()));
    }

    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        this.gladiador = unGladiador;
        this.combatir(unGladiador);
        System.out.println("\nEntró a Bacanal");
        //PantallaMapa.obtenerLabelObstaculo().setText("Obstaculo: entró a un Bacanal.");
        return  unGladiador;
    }
}
