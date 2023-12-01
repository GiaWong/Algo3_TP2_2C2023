package edu.fiuba.algo3.Modelo.PatronState;
import edu.fiuba.algo3.Modelo.Equipamientos.Equipado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManejarEquipamiento {
    private Estado estado;

    public ManejarEquipamiento(){
        estado = new EstadoSinEquipamiento();
    }
    public void obtenerPremio(List<Equipado> listaDeEquipamiento) {
        estado = estado.ejercutarAccion(listaDeEquipamiento);
    }


}
