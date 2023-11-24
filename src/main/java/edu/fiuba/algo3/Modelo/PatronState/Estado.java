package edu.fiuba.algo3.Modelo.PatronState;
import edu.fiuba.algo3.Modelo.Equipamientos.Equipamiento;
import java.util.List;

public interface Estado {
    void ejercutarAccion(List<Equipamiento> listaDeEquipamiento);
}
