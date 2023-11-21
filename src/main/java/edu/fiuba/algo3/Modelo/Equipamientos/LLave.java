package edu.fiuba.algo3.Modelo.Equipamientos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public class LLave extends Ocupacion implements Equipamiento {

    public LLave(){}

    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador) {

        return  visitor.visitar(this, ungladiador);
    }

    @Override
    public Gladiador modificarEnergia(Gladiador unGladiador) {
        return  unGladiador;
    }
    @Override
    public int desgastar(int energiaGladiador) {
        return 0;
    }


}
