package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;
import edu.fiuba.algo3.Modelo.DadoMock;
import edu.fiuba.algo3.Modelo.Gladiador;

public class Bacanal implements Obstaculo, Ocupacion {

    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador) {
        return  visitor.visitar(this, ungladiador);
    }
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

}
