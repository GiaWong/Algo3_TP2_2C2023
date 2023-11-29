package edu.fiuba.algo3.Modelo.Obstaculos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.fiuba.algo3.Modelo.Casillas.Ocupable;
import edu.fiuba.algo3.Modelo.DadoMock;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Turno;

/**
 *
 * Las anotaciones que empiezan con @ son mas que nada para que el json sepa que hay
 * una clase del tipo Lesion
 *
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("lesion")
public class Lesion implements Obstaculizador, Ocupable {

    @Override
    public void combatir(Gladiador unGladiador) {
    }

    @Override
    public int modificarEnergia(int energia) {
        return energia;
    }

    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        System.out.println("\nEntró a Lesion");
        Turno.perderSiguienteTurno(unGladiador);
        return  unGladiador;
    }

}
