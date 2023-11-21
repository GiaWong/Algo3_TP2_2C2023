package edu.fiuba.algo3.Modelo.Premios;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public class Comida extends Ocupacion implements Premio {

    private int energia;
    public Comida(int energiaPropia){this.energia = energiaPropia;}
    @Override
    public void modificarEnergia(Gladiador unGladiador) {
        unGladiador.agregarEquipamientoSegunCantidadDePremios();
        unGladiador.aumentarEnergia(energia);
    }

    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador) {
        return  visitor.visitar(this, ungladiador);
    }
}
