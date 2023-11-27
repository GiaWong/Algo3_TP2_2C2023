package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public  class FieraSalvaje implements Ocupacion,Obstaculo {
    private int unaEnergia;

    public FieraSalvaje(int energia) {
        unaEnergia = energia;
    }

    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador) {
        return  visitor.visitar(this, ungladiador);
    }

    public int modificarEnergia(int energia) {
        return (energia - unaEnergia) ;
    }

    @Override
    public void combatir(Gladiador unGladiador) {
        unGladiador.combatir(this );
    }






}
