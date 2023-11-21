package edu.fiuba.algo3.Modelo.Casillas;

import edu.fiuba.algo3.Modelo.Equipamientos.Armadura;
import edu.fiuba.algo3.Modelo.Equipamientos.Casco;
import edu.fiuba.algo3.Modelo.Equipamientos.EscudoYEspada;
import edu.fiuba.algo3.Modelo.Equipamientos.LLave;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Premios.Comida;

public interface VisitorDeCasillas {

    Gladiador visitar(Casco casco, Gladiador unGladiador);
    Gladiador visitar(Armadura armadura, Gladiador unGladiador);
    Gladiador visitar(EscudoYEspada escudoYEspada, Gladiador unGladiador);
    Gladiador visitar(LLave lLave, Gladiador unGladiador);
    Gladiador visitar(FieraSalvaje fieraSalvaje, Gladiador unGladiador);
    Gladiador visitar(NadaOcupacion nada, Gladiador unGladiador);

    Gladiador visitar(Comida comida, Gladiador unGladiador);
}
