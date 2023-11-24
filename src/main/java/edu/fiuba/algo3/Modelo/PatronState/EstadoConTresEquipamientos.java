package edu.fiuba.algo3.Modelo.PatronState;

import edu.fiuba.algo3.Modelo.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Modelo.Equipamientos.LLave;

import java.util.List;

public class EstadoConTresEquipamientos implements Estado {

    @Override
    public void ejercutarAccion(List<Equipamiento> listaDeEquipamiento) {
        listaDeEquipamiento.add(new LLave());
        System.out.println("\n===> Obtiene una llave como premio");
    }
}
