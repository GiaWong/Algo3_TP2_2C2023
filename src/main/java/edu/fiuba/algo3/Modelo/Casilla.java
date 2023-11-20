package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Equipamientos.LLave;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Premios.Comida;

public class Casilla {
    Ocupacion unaOcupacion;

    public Casilla(Ocupacion ocupacion) {
        this.unaOcupacion = ocupacion;

    }

    public Gladiador enfrentarObstaculo(Gladiador ungladiador) {

        if(esObstaculo()) { //viola telldont ask --> Refactorizar
            System.out.println("\nEs obstaculo\n");
            ungladiador = unaOcupacion.combatir(ungladiador);

            return ungladiador;
        }

        ungladiador.agregarEquipamiento(unaOcupacion);
        return ungladiador;
    }

    //Es un tema los tipos de datos
    private boolean esObstaculo() {
        return (unaOcupacion.getClass().equals(FieraSalvaje.class));//refactorizar a la FieraSalvaje con una abstraccion
    }


    public Gladiador recibirPremio(Gladiador ungladiador) {

        if(esPremio()) { //viola del dont ask --> Reffactorizar
            System.out.println("\nEs Premio\n");
            ungladiador = unaOcupacion.recibirPremio(ungladiador);
        }
        return ungladiador;
    }

    private boolean esPremio() {
        return unaOcupacion.getClass().equals(Comida.class);//refactorizar a la Comida con una abstraccion
    }
}

