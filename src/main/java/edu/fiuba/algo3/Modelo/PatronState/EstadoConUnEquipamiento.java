package edu.fiuba.algo3.Modelo.PatronState;

import edu.fiuba.algo3.Modelo.Equipamientos.Armadura;
import edu.fiuba.algo3.Modelo.Equipamientos.Equipado;
import edu.fiuba.algo3.Vista.PantallaMapa;

import java.util.List;

public class EstadoConUnEquipamiento implements Estado{
    @Override
    public Estado ejercutarAccion(List<Equipado> listaDeEquipamiento) {
        listaDeEquipamiento.add(new Armadura(5));
        System.out.println("\n===> Obtiene una Armadura como premio");
        //PantallaMapa.obtenerLabelPremio().setText("Premio: obtiene una armadura.");
        return new EstadoConDosEquipamientos();
    }
}
