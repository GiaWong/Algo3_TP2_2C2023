package edu.fiuba.algo3.Modelo.PatronState;

import edu.fiuba.algo3.Modelo.Equipamientos.Casco;
import edu.fiuba.algo3.Modelo.Equipamientos.Equipamiento;

import java.util.List;

public class EstadoSinEquipamiento implements Estado{
    @Override
    public void ejercutarAccion(List<Equipamiento> listaDeEquipamiento) {
        listaDeEquipamiento.add(new Casco(5));
        System.out.println("\n===> Obtiene un Casco como premio");
    }
}
