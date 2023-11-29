package edu.fiuba.algo3.Modelo.Obstaculos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupable;

/**
 *
 * Las anotaciones que empiezan con @ son mas que nada para que el json sepa que hay
 * una clase del tipo FiraSalvaje
 *
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("fiera")
public  class FieraSalvaje implements Ocupable, Obstaculizador {
    private int unaEnergia;

    public FieraSalvaje(int energia) {
        unaEnergia = energia;
    }

    @Override
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
