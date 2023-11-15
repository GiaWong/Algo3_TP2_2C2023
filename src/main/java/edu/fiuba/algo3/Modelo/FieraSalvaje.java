package edu.fiuba.algo3.Modelo;

public  class FieraSalvaje implements Ocupacion {

    @Override
    public int modificarEnergia(int unaEnergia) {
        return (unaEnergia-20);
    }
}
