package edu.fiuba.algo3.Modelo.Equipamientos;

import edu.fiuba.algo3.Modelo.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Ocupacion;

public class EscudoYEspada extends Equipamiento implements Ocupacion {
    private int energia;
    public EscudoYEspada(int energia) {
        this.energia=energia;
    }

    @Override
    public Gladiador modificarEnergia(Gladiador unGladiador) { //estosMetodos está de mas =(
        return null;
    }
    @Override
    public Gladiador combatir(Gladiador ungladiador) {//estosMetodos está de mas =(
        return null;
    }

    @Override
    public Gladiador recibirPremio(Gladiador ungladiador) {//estosMetodos está de mas =(
        return null;
    }

    @Override
    public int modificarEnergia(int unaEnergia) {
        return (unaEnergia - energia);
    }


}
