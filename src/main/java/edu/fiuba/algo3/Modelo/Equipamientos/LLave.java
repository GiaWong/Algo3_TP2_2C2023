package edu.fiuba.algo3.Modelo.Equipamientos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public class LLave  implements Ocupacion,Equipamiento {
    private int energia;
    public LLave(int energia){this.energia =energia;}

    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador) {

        return  visitor.visitar(this, ungladiador);
    }

    @Override
    public int modificarEnergia(int unaEnergia) {
        return (unaEnergia); //+ energia);
    }


}
