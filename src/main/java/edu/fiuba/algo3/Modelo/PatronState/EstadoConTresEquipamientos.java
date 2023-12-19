package edu.fiuba.algo3.Modelo.PatronState;

import edu.fiuba.algo3.Modelo.Equipamientos.Equipado;
import edu.fiuba.algo3.Modelo.Equipamientos.LLave;
import edu.fiuba.algo3.Vista.PantallaMapa;

import java.util.List;

public class EstadoConTresEquipamientos implements Estado {
    @Override
    public Estado ejercutarAccion(List<Equipado> listaDeEquipamiento) {
        listaDeEquipamiento.add(new LLave(2));
        System.out.println("\n===> Obtiene una llave como premio");
        PantallaMapa.obtenerLabel().setText("El jugador obtiene una llave como premio");
        return new EstadoSinEquipamiento();
    }
}
