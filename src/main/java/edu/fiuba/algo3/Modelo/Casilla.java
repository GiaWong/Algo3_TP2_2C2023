package edu.fiuba.algo3.Modelo;

public class Casilla {
    Ocupacion unaOcupacion;

    public Casilla(Ocupacion ocupacion) {
        this.unaOcupacion = ocupacion;
    }

    public int modificarEnergia(int unaEnergia){
        return (unaOcupacion.modificarEnergia(unaEnergia) );
    }
}
