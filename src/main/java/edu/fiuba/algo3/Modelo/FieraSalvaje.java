package edu.fiuba.algo3.Modelo;

public  class FieraSalvaje implements Ocupacion {

    private int energia;
    public FieraSalvaje(int energiaPropia) {
        this.energia = energiaPropia;
    }

    @Override
    public int modificarEnergia(int unaEnergia) {
        return (unaEnergia-energia);
    }
}
