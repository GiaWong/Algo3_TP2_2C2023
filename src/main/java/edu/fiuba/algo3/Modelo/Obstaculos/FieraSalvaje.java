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

    //La fiera tiene que poder restar la energia del gladiador
    public int modificarEnergia(int energia) {
        return (energia - unaEnergia) ;
    }

    //Una forma de pensarlo es pasarle por param la ocupacion y que el gladiador se reste los putnos
    //En su "combatir"
    @Override
    public void combatir(Gladiador unGladiador) {
        unGladiador.combatir(this );
    }






}
