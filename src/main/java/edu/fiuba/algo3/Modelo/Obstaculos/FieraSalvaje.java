package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Ocupacion;

public  class FieraSalvaje extends Obstaculo implements Ocupacion {


    public FieraSalvaje() {
    }

    @Override
    public Gladiador modificarEnergia(Gladiador unGladiador) {//estosMetodos está de mas =(
        return null;
    }

    @Override
    public int modificarEnergia(int energia) {//estosMetodos está de mas =(
        return (energia -20) ;
    }

    @Override
    public Gladiador combatir(Gladiador unGladiador) {

        // Rompo todo principio aprendido, refactorizar!
        unGladiador.setEnergia(this.modificarEnergia(unGladiador.obtenerEnergia()));

        //Lo mando a combatir y lo equipo
        unGladiador.combatir();
        return unGladiador;
    }

    @Override
    public Gladiador recibirPremio(Gladiador ungladiador) {//estosMetodos está de mas =(
        return null;
    }
}
