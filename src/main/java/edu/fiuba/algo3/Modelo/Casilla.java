package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Premios.Comida;

public class Casilla {
    Ocupacion unaOcupacion;

    public Casilla(Ocupacion ocupacion) {
        this.unaOcupacion = ocupacion;

    }


    public Gladiador enfrentarObstaculo(Gladiador ungladiador) {

        if(esObstaculo()) {
            System.out.println("\nEs obstaculo\n");
            ungladiador = unaOcupacion.combatir(ungladiador);
        }
        ungladiador.agregarEquipamiento(unaOcupacion);
        return ungladiador;
    }

    //no le toma al obstaculo
    private boolean esObstaculo() {
        return (unaOcupacion.getClass().equals(FieraSalvaje.class));//refactorizar a la FieraSalvaje con una abstraccion
    }


    public Gladiador recibirPremio(Gladiador ungladiador) {

        if(esPremio()) {
            System.out.println("\nEs Premio\n");
            ungladiador = unaOcupacion.recibirPremio(ungladiador);
        }
        return ungladiador;
    }

    // no lo toma al premio
    private boolean esPremio() {
        return unaOcupacion.getClass().equals(Comida.class);//refactorizar a la Comida con una abstraccion
    }
}

