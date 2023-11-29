package edu.fiuba.algo3.Modelo.Premios;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupable;

/**
 *
 * Las anotaciones que empiezan con @ son mas que nada para que el json sepa que hay
 * una clase del tipo Comida
 *
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("comida")
public class Comida  implements Premio, Ocupable {

    private int energia;
    public Comida(int energiaPropia){this.energia = energiaPropia;}

    @Override
    public void modificarEnergia(Gladiador unGladiador) {
        unGladiador.aumentarEnergia(energia);
    }

    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        this.modificarEnergia(unGladiador);
        return unGladiador;
    }

}
