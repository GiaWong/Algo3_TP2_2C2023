package edu.fiuba.algo3.Modelo;

public class Armadura implements Ocupacion {
    private int energia;

    public Armadura(int energia) {
        this.energia = energia;
    }

    @Override
    public int modificarEnergia(int unaEnergia) {
        return (unaEnergia + energia);
    }
}
