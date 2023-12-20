package edu.fiuba.algo3.Modelo.Premios;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupable;
import edu.fiuba.algo3.Vista.PantallaMapa;


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
        System.out.println("\nEntró a Comida");
        PantallaMapa.obtenerLabelPremio().setText("Premio: obtiene comida.");
        return unGladiador;
    }

}
