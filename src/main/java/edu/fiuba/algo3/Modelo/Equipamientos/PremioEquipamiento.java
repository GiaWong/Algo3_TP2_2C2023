package edu.fiuba.algo3.Modelo.Equipamientos;

import edu.fiuba.algo3.Modelo.Casillas.Ocupable;
import edu.fiuba.algo3.Modelo.Gladiador;
public class PremioEquipamiento implements Ocupable {
    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        unGladiador.agregarEquipamientoSegunCantidadDePremios();
        return unGladiador;
    }

}
