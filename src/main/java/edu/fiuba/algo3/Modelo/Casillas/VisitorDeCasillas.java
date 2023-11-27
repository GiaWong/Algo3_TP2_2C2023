package edu.fiuba.algo3.Modelo.Casillas;

import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Obstaculos.Bacanal;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Premios.Comida;

public interface VisitorDeCasillas {

    Gladiador visitar(Casco casco, Gladiador unGladiador);
    Gladiador visitar(Armadura armadura, Gladiador unGladiador);
    Gladiador visitar(EscudoYEspada escudoYEspada, Gladiador unGladiador);
    Gladiador visitar(LLave lLave, Gladiador unGladiador);
    Gladiador visitar(FieraSalvaje fieraSalvaje, Gladiador unGladiador);
    Gladiador visitar(Bacanal bacanal, Gladiador unGladiador);
    Gladiador visitar(NadaOcupacion nada, Gladiador unGladiador);

    Gladiador visitar(Comida comida, Gladiador unGladiador);

    Gladiador visitar(PremioEquipamiento unPremio, Gladiador unGladiador);
}
