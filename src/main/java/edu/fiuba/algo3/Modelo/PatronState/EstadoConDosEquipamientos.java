package edu.fiuba.algo3.Modelo.PatronState;

import edu.fiuba.algo3.Modelo.Equipamientos.Equipado;
import edu.fiuba.algo3.Modelo.Equipamientos.EscudoYEspada;

import java.util.List;

public class EstadoConDosEquipamientos implements Estado{

    @Override
    public Estado ejercutarAccion(List<Equipado> listaDeEquipamiento) {
        listaDeEquipamiento.add(new EscudoYEspada(8));
        System.out.println("\n===> Obtiene un Escudo y una espada como premio");
        return new EstadoConTresEquipamientos();
    }
}
