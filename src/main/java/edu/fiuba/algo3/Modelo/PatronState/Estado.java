package edu.fiuba.algo3.Modelo.PatronState;
import edu.fiuba.algo3.Modelo.Equipamientos.Equipado;
import java.util.List;

public interface Estado {
    void ejercutarAccion(List<Equipado> listaDeEquipamiento);
}
