package edu.fiuba.algo3.Modelo.PatronState;

import edu.fiuba.algo3.Modelo.Equipamientos.Armadura;
import edu.fiuba.algo3.Modelo.Equipamientos.Equipamiento;

import java.util.List;

public class EstadoConUnEquipamiento implements Estado{
    @Override
    public void ejercutarAccion(List<Equipamiento> listaDeEquipamiento) {
        listaDeEquipamiento.add(new Armadura(5));
        System.out.println("\n===> Obtiene una Armadura como premio");
    }
}
