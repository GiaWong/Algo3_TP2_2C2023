package edu.fiuba.algo3.Modelo.Equipamientos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public class LLave  implements Ocupacion,Equipamiento {

    public LLave(){}

    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador) {

        return  visitor.visitar(this, ungladiador);
    }

    //Por ahora la llave no tiene energia
    @Override
    public int modificarEnergia(int unaEnergia) {
        return (unaEnergia); //+ energia);
    }


}
