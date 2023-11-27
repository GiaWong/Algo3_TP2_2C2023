package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupable;

public  class FieraSalvaje implements Ocupable,Obstaculo {
    private int unaEnergia;

    public FieraSalvaje(int energia) {
        unaEnergia = energia;
    }

    public int modificarEnergia(int energia) {
        return (energia - unaEnergia) ;
    }

    @Override
    public void combatir(Gladiador unGladiador) {
        unGladiador.combatir(this );
    }


    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        this.combatir(unGladiador);
        System.out.println("\nEntró a FieraSalvaje");
        return  unGladiador;
    }
}
