package edu.fiuba.algo3.Modelo;

public interface Ocupacion {
    Gladiador modificarEnergia(Gladiador unGladiador);

    int modificarEnergia(int energia);

    //Ya que este metodo solo lo usa obstaculo, podriamos ponerlo ahi y quitarlo de ocupacion
    Gladiador combatir(Gladiador ungladiador);

    //Esto podria tenerlo Premio tambien y lo quitamos de aca
    Gladiador recibirPremio(Gladiador ungladiador);
}
