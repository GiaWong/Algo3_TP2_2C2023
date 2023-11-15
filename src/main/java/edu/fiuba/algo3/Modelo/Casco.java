package edu.fiuba.algo3.Modelo;

public class Casco implements Ocupacion {
    private int energia;

    public Casco(int energia) {
        this.energia = energia;
    }

    @Override
    public int modificarEnergia(int unaEnergia) {
        return (unaEnergia + energia);
    }
}
