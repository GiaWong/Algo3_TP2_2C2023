package edu.fiuba.algo3.Modelo.PatronState;
import edu.fiuba.algo3.Modelo.Equipamientos.Equipamiento;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManejarEquipamiento {
    private Estado estado;
    private Map<Integer, Estado> estados = new HashMap<>();
    private int estadoActual;

    //uso un map para sacar los ifs de encima
    public ManejarEquipamiento() {
        estados.put(0, new EstadoSinEquipamiento());
        estados.put(1, new EstadoConUnEquipamiento());
        estados.put(2, new EstadoConDosEquipamientos());
        estados.put(3, new EstadoConTresEquipamientos());
    }

    public void cambiarEstado(int nuevoEstado) {
        estadoActual = nuevoEstado;
    }

    public void obtenerPremio(List<Equipamiento> listaDeEquipamiento) {
        estado = estados.get(estadoActual);
        estado.ejercutarAccion(listaDeEquipamiento);
    }


}
