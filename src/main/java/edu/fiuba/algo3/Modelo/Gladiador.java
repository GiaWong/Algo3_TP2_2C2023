package edu.fiuba.algo3.Modelo;

import java.util.Optional;

public class Gladiador {
    private int posicion;

    public Gladiador(int i, Novato novato, int i1) {
    }

    public int obtenerEnergia() {
        return 20;
    }


    public int  obtenerEquipamiento() {
        return (0);

    }

    public void avanzar(int moverUnasCasillas) {
        posicion = posicion + moverUnasCasillas;
    }

    public int obtenerPosicion() {
        return posicion;
    }
}
