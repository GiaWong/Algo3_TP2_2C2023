package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public  class FieraSalvaje  extends Ocupacion implements Obstaculo {


    public FieraSalvaje() {
    }

    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador) {
        return  visitor.visitar(this, ungladiador);
    }

    @Override
    public void combatir(Gladiador unGladiador) {//pensarlo bien
        unGladiador.combatir();
    }


    /*@Override
    public int modificarEnergia(int energia) {
        return (energia -20) ;
    }*/




}
