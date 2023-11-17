package edu.fiuba.algo3.Modelo;

public interface Ocupacion {
    Gladiador modificarEnergia(Gladiador unGladiador);

    int modificarEnergia(int energia);

    Gladiador combatir(Gladiador ungladiador);

    Gladiador recibirPremio(Gladiador ungladiador);
}
