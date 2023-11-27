package edu.fiuba.algo3.Modelo.PatronState;

import edu.fiuba.algo3.Modelo.Equipamientos.Equipado;
import edu.fiuba.algo3.Modelo.Equipamientos.LLave;

import java.util.List;

public class EstadoConTresEquipamientos implements Estado {
    @Override
    public void ejercutarAccion(List<Equipado> listaDeEquipamiento) {
        listaDeEquipamiento.add(new LLave(2));
        System.out.println("\n===> Obtiene una llave como premio");
    }
}
