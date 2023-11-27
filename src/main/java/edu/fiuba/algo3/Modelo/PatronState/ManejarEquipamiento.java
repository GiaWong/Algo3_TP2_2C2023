package edu.fiuba.algo3.Modelo.PatronState;
import edu.fiuba.algo3.Modelo.Equipamientos.Equipado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManejarEquipamiento {
    private Estado estado;
    private Map<Integer, Estado> estados = new HashMap<>();
    private int estadoActual;

    public ManejarEquipamiento() {
        estados.put(0, new EstadoSinEquipamiento());
        estados.put(1, new EstadoConUnEquipamiento());
        estados.put(2, new EstadoConDosEquipamientos());
        estados.put(3, new EstadoConTresEquipamientos());
    }

    public void cambiarEstado(int nuevoEstado) {
        estadoActual = nuevoEstado;
    }

    public void obtenerPremio(List<Equipado> listaDeEquipamiento) {
        estado = estados.get(estadoActual);
        estado.ejercutarAccion(listaDeEquipamiento);
    }


}
