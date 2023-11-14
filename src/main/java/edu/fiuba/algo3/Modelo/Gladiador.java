package edu.fiuba.algo3.Modelo;

import java.util.Optional;

public class Gladiador {
    private int posicion;
    private int energia;

    public Gladiador(int unaEneriga, Novato novato, int unTurno, int posicion) {
    }

    public int obtenerEnergia() {
        return energia;
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
